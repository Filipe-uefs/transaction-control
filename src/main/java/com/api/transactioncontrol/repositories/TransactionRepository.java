package com.api.transactioncontrol.repositories;

import com.api.transactioncontrol.models.ClientModel;
import com.api.transactioncontrol.models.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, UUID> {
    List<TransactionModel> findBySenderClient(ClientModel client);
    List<TransactionModel> findByRecipientClient(ClientModel client);
}
