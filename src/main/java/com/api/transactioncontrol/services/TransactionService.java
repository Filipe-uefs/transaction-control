package com.api.transactioncontrol.services;

import com.api.transactioncontrol.models.TransactionModel;
import com.api.transactioncontrol.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Page<TransactionModel> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
}
