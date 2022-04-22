package com.api.transactioncontrol.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "clients")
@NoArgsConstructor
public class ClientModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter private UUID id;
    @Column(nullable = false)
    @Getter @Setter private String fullName;
    @Getter @Setter private LocalDateTime createdAt;
    @Column(nullable = false, unique = true)
    @Getter @Setter private String email;
    @Column(nullable = false, unique = true)
    @Getter @Setter private String cpf;
    @Getter @Setter private int ddd;
    @Column(nullable = false, unique = true)
    @Getter @Setter private Long telephone;

}
