package com.api.transactioncontrol.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

    private ClientDto senderClient;
    private ClientDto recipientClient;
    private TransactionTypeDto transactionType;
    private TransactionStatusDto transactionStatus;
}
