package com.api.transactioncontrol.services;

import com.api.transactioncontrol.models.TransactionTypeModel;
import com.api.transactioncontrol.repositories.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionTypeService {

    @Autowired
    TransactionTypeRepository transactionTypeRepository;

    public TransactionTypeModel findTransactionTypeByName(String name) {
        return transactionTypeRepository.findOneByName(name);
    }
}
