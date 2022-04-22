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
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.save(client));
    }
}
