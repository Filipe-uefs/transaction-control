package com.api.transactioncontrol.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transaction_type")
@NoArgsConstructor
public class TransactionTypeModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private Long id;
    @Getter @Setter private String name;
}
