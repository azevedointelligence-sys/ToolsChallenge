package com.irae.toolschallenge.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Transaction {

    private String id;
    private String cardNumber;
    private TransactionDescription description;
    private PaymentMethod paymentMethod;

    public void authorize(String nsu, String authorizationCode) {
        this.description.authorize(nsu, authorizationCode);
    }

    public void deny() {
        this.description.deny();
    }

    public void cancel() {
        this.description.cancel();
    }
}