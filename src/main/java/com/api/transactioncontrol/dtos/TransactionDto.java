package com.api.transactioncontrol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Setter
public class TransactionDto {

    @NotNull
    private ClientDto senderClient;
    @NotNull
    private ClientDto recipientClient;
    @NotNull
    private TransactionTypeDto transactionType;
    @NotNull
    private TransactionStatusDto transactionStatus;
    @NotNull
    private double value;
}
