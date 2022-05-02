package com.api.transactioncontrol.controllers;

import com.api.transactioncontrol.dtos.TransactionDto;
import com.api.transactioncontrol.models.TransactionModel;
import com.api.transactioncontrol.services.ClientService;
import com.api.transactioncontrol.services.TransactionService;
import com.api.transactioncontrol.services.TransactionStatusService;
import com.api.transactioncontrol.services.TransactionTypeService;
import com.api.transactioncontrol.utils.TransactionFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transactions")
@Api(value = "Transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @Autowired
    TransactionStatusService transactionStatusService;
    @Autowired
    TransactionTypeService transactionTypeService;
    @Autowired
    ClientService clientService;

    @GetMapping
    @ApiOperation(value = "Get transactions")
    public ResponseEntity<Page<TransactionModel>> getAllTransactions(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
                    Pageable pageable) {
            return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactions(pageable));
    }

    @GetMapping("/getTransactionsByCPF")
    @ApiOperation(value = "Get transactions sent or received by cpf")
    public ResponseEntity<List<TransactionModel>> getTransactionsByCPF(
            @NotNull @NotBlank String cpf, @NotNull @NotBlank String type) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionService.getTransactionsByCPF(cpf, type));
    }

    @GetMapping("/getTransactionsByTelephone")
    @ApiOperation(value = "Get transactions sent or received by telephone")
    public ResponseEntity<List<TransactionModel>> getTransactionsByTelephone(
            @NotNull @NotBlank int ddd,
            @NotNull @NotBlank Long telephone,
            @NotNull @NotBlank String type) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(transactionService.getTransactionsByTelephone(ddd, telephone, type));
    }

    @PostMapping
    @ApiOperation(value = "Create Transactions")
    public ResponseEntity<TransactionModel> saveTransaction(@RequestBody @Valid TransactionDto transactionDto) {

        TransactionFactory factory = new TransactionFactory(transactionStatusService,
                transactionTypeService, clientService, transactionService);
        factory.setTransactionDto(transactionDto);
        return ResponseEntity.status(HttpStatus.OK).body(factory.createTransaction());
    }
}
