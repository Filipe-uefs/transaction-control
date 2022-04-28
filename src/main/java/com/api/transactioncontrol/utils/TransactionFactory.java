package com.api.transactioncontrol.utils;

import com.api.transactioncontrol.dtos.TransactionDto;
import com.api.transactioncontrol.models.TransactionStatusModel;
import com.api.transactioncontrol.models.TransactionTypeModel;
import com.api.transactioncontrol.services.TransactionStatusService;
import com.api.transactioncontrol.services.TransactionTypeService;
import lombok.Getter;
import lombok.Setter;

public class TransactionFactory {

    private final TransactionStatusService transactionStatusService;
    private final TransactionTypeService transactionTypeService;
    @Getter @Setter private TransactionDto transactionDto;

    public TransactionFactory(TransactionStatusService transactionStatusService,
                              TransactionTypeService transactionTypeService) {
        this.transactionStatusService = transactionStatusService;
        this.transactionTypeService = transactionTypeService;
    }

    public void createTransaction() {
        TransactionStatusModel transactionStatusModel = getTransactionStatusModel();
        TransactionTypeModel transactionTypeModel = getTransactionTypeModel();
        System.out.println(transactionTypeModel.getName());
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
