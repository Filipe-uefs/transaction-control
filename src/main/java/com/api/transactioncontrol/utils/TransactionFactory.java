package com.api.transactioncontrol.utils;

import com.api.transactioncontrol.dtos.TransactionDto;
import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.models.TransactionModel;
import com.api.transactioncontrol.models.TransactionStatusModel;
import com.api.transactioncontrol.models.TransactionTypeModel;
import com.api.transactioncontrol.services.ClientService;
import com.api.transactioncontrol.services.TransactionService;
import com.api.transactioncontrol.services.TransactionStatusService;
import com.api.transactioncontrol.services.TransactionTypeService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class TransactionFactory {

    private final TransactionStatusService transactionStatusService;
    private final TransactionTypeService transactionTypeService;
    private final ClientService clientService;
    private final TransactionService transactionService;
    @Getter @Setter private TransactionDto transactionDto;

    public TransactionFactory(TransactionStatusService transactionStatusService,
                              TransactionTypeService transactionTypeService,
                              ClientService clientService, TransactionService transactionService) {
        this.transactionStatusService = transactionStatusService;
        this.transactionTypeService = transactionTypeService;
        this.clientService = clientService;
        this.transactionService = transactionService;
    }

    public TransactionModel createTransaction() {
        TransactionStatusModel transactionStatusModel = getTransactionStatusModel();
        TransactionTypeModel transactionTypeModel = getTransactionTypeModel();
        ClientModel senderClient = clientService.getClientByCPF(transactionDto.getSenderClient().getCpf());
        ClientModel recipientClient = clientService.getClientByCPF(transactionDto.getRecipientClient().getCpf());
        TransactionModel transaction = new TransactionModel();
        transaction.setTransactionType(transactionTypeModel);
        transaction.setTransactionStatus(transactionStatusModel);
        transaction.setSenderClient(senderClient);
        transaction.setRecipientClient(recipientClient);
        transaction.setValue(transactionDto.getValue());
        transaction.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return transactionService.save(transaction);

    }

    public TransactionStatusModel getTransactionStatusModel() {
        String transactionStatusName = transactionDto.getTransactionStatus().getName();
        return transactionStatusService.findTransactionStatusByName(transactionStatusName);
    }

    public TransactionTypeModel getTransactionTypeModel() {
        String transactionTypeName = transactionDto.getTransactionType().getName();
        return transactionTypeService.findTransactionTypeByName(transactionTypeName);
    }
}
