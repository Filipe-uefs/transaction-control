package com.api.transactioncontrol.services;

import com.api.transactioncontrol.models.TransactionStatusModel;
import com.api.transactioncontrol.repositories.TransactionStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionStatusService {

    @Autowired
    TransactionStatusRepository transactionStatusRepository;

    public TransactionStatusModel findTransactionStatusByName(String name) {
        return transactionStatusRepository.findOneByName(name);
    }
}
