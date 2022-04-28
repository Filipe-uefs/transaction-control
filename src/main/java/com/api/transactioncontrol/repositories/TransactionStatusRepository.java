package com.api.transactioncontrol.repositories;

import com.api.transactioncontrol.models.TransactionStatusModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionStatusRepository extends JpaRepository<TransactionStatusModel, Long> {

    TransactionStatusModel findOneByName(String name);
}
