package com.api.transactioncontrol.controllers;

import com.api.transactioncontrol.dtos.ClientDto;
import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.services.ClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/client")
@Api(value = "Clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    @ApiOperation(value = "Create Client")
    public ResponseEntity<Object> saveClientDto (@RequestBody @Valid ClientDto clientDto) {
        ClientModel client = new ClientModel();
        BeanUtils.copyProperties(clientDto, client);
        client.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        try {
            ClientModel clientModel = clientService.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
        } catch (Exception e) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("message", e.getMessage());
            map.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(map);
        }
    }

    @GetMapping
    @ApiOperation(value = "Get Clients")
    public ResponseEntity<Page<ClientModel>> getAllClients(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
                    Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getAllClients(pageable));
    }

    @GetMapping("/getByNumber")
    @ApiOperation(value = "Get Client by number")
    public ResponseEntity<ClientModel> getClientByNumber(int ddd, Long telephone) {
        return ResponseEntity.status(HttpStatus.OK).body(clientService.getClientByNumber(ddd, telephone));
    }
}
