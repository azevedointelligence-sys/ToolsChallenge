package com.irae.toolschallenge.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethod {

    private PaymentTypeEnum type;
    private int installments;

}
