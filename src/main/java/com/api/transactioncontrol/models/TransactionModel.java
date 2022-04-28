package com.api.transactioncontrol.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "transaction")
@NoArgsConstructor
public class TransactionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private UUID id;
    @ManyToOne
    @JoinColumn(name = "sender_client_id")
    @Getter @Setter private ClientModel senderClient;
    @ManyToOne
    @JoinColumn(name = "recipient_client_id")
    @Getter @Setter private ClientModel recipientClient;
    @OneToOne
    @JoinColumn(name = "transaction_type_id")
    @Getter @Setter private TransactionTypeModel transactionType;
    @OneToOne
    @JoinColumn(name = "transaction_status_id")
    @Getter @Setter private TransactionStatusModel transactionStatus;
    @Getter @Setter private LocalDateTime createdAt;
}
