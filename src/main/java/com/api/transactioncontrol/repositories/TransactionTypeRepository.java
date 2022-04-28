package com.api.transactioncontrol.repositories;

import com.api.transactioncontrol.models.TransactionTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionTypeRepository extends JpaRepository<TransactionTypeModel, Long> {
    TransactionTypeModel findOneByName(String name);
}
