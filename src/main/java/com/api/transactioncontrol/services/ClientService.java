package com.api.transactioncontrol.services;

import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    public Page<ClientModel> getAllClients(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }

    public ClientModel getClientByCPF(String cpf) {
        return clientRepository.findOneByCpf(cpf);
    }

    public ClientModel getClientByNumber(int ddd, Long telephone) {
        return clientRepository.findByDddAndTelephone(ddd, telephone);
    }
}
