package com.api.transactioncontrol.services;

import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.models.TransactionModel;
import com.api.transactioncontrol.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionService {

    @Autowired TransactionRepository transactionRepository;

    @Autowired ClientService clientService;

    public Page<TransactionModel> getAllTransactions(Pageable pageable) {
        return transactionRepository.findAll(pageable);
    }
    public List<TransactionModel> getTransactionsByCPF(String cpf, String type) {
        ClientModel client = clientService.getClientByCPF(cpf);
        List<TransactionModel> transactions;
        if (Objects.isNull(client)) {
            transactions = new ArrayList<>();
        } else if (Objects.equals(type, "sent")) {
            transactions = transactionRepository.findBySenderClient(client);
        } else {
            transactions = transactionRepository.findByRecipientClient(client);
        }

        return transactions;
    }
    @Transactional
    public TransactionModel save(TransactionModel transactionModel) {
        return transactionRepository.save(transactionModel);
    }
}
