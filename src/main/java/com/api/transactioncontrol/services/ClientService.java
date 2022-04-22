package com.api.transactioncontrol.services;

import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Transactional
    public ClientModel save(ClientModel client) {
        return clientRepository.save(client);
    }
}
