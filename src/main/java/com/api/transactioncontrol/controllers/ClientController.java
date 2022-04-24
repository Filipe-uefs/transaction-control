package com.api.transactioncontrol.controllers;

import com.api.transactioncontrol.dtos.ClientDto;
import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.services.ClientService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public ResponseEntity<Object> saveClientDto (@RequestBody @Valid ClientDto clientDto) {
        ClientModel client = new ClientModel();
        BeanUtils.copyProperties(clientDto, client);
        client.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        try {
            ClientModel clientModel = clientService.save(client);
            return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
        } catch (Exception e) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("message", e.getMessage());
            map.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(map);
        }


    }
}
