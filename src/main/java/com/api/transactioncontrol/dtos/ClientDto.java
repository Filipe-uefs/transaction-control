package com.api.transactioncontrol.dtos;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientDto {

    @NotBlank
    private String fullName;
    @NotBlank
    private String email;
    @NotBlank
    private String cpf;
    @NotNull
    private int ddd;
    @NotNull
    private Long telephone;
}
