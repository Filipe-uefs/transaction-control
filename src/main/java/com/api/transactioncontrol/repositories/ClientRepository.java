package com.api.transactioncontrol.repositories;

import com.api.transactioncontrol.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {
    ClientModel findOneByCpf(String cpf);
    ClientModel findByDddAndTelephone(int ddd, Long telephone);
}