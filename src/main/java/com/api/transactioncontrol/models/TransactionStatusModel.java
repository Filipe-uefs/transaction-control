package com.api.transactioncontrol.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction_status")
@NoArgsConstructor
public class TransactionStatusModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;
    @Getter @Setter private String name;
}
