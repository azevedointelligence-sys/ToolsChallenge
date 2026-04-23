package com.irae.toolschallenge.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class TransactionDescription {

    private final String amount;
    private final String dateTime;
    private final String establishment;

    private String nsu;
    private String authorizationCode;
    private TransactionStatusEnum status;

    public TransactionDescription(String amount, String dateTime, String establishment) {
        this.amount = amount;
        this.dateTime = dateTime;
        this.establishment = establishment;
    }

    public void authorize(String nsu, String authorizationCode) {
        this.nsu = nsu;
        this.authorizationCode = authorizationCode;
        this.status = TransactionStatusEnum.AUTORIZADO;
    }

    public void deny() {
        this.status = TransactionStatusEnum.NEGADO;
    }

    public void cancel() {
        this.status = TransactionStatusEnum.CANCELADO;
    }
}