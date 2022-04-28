package com.api.transactioncontrol.controllers;

import com.api.transactioncontrol.dtos.TransactionDto;
import com.api.transactioncontrol.models.TransactionModel;
import com.api.transactioncontrol.services.ClientService;
import com.api.transactioncontrol.services.TransactionService;
import com.api.transactioncontrol.services.TransactionStatusService;
import com.api.transactioncontrol.services.TransactionTypeService;
import com.api.transactioncontrol.utils.TransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/transaction")
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
    public ResponseEntity<Page<TransactionModel>> getAllTransactions(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC)
                    Pageable pageable) {
            return ResponseEntity.status(HttpStatus.OK).body(transactionService.getAllTransactions(pageable));
    }

    @PostMapping
    public ResponseEntity<TransactionModel> saveTransaction(@RequestBody @Valid TransactionDto transactionDto) {

        TransactionFactory factory = new TransactionFactory(transactionStatusService,
                transactionTypeService, clientService, transactionService);
        factory.setTransactionDto(transactionDto);
        return ResponseEntity.status(HttpStatus.OK).body(factory.createTransaction());
    }
}
