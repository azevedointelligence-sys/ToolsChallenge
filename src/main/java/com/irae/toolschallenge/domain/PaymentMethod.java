package com.irae.toolschallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentMethod {

    private PaymentTypeEnum type;
    private int installments;
}
