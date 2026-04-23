package com.irae.toolschallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TransactionStatusEnum {

    AUTORIZADO("Autorizado"),
    NEGADO("Negado"),
    CANCELADO("Cancelado");

    private final String description;

}
