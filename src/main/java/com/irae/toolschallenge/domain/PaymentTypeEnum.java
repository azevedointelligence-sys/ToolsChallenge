package com.irae.toolschallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PaymentTypeEnum {
    AVISTA("À vista"),
    PARCELADO_LOJA("Parcelado pela loja"),
    PARCELADO_EMISSOR("Parcelado pelo emissor");

    private final String description;

}
