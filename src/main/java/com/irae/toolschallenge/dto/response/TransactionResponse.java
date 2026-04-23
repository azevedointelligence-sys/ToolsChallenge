package com.irae.toolschallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.irae.toolschallenge.domain.PaymentMethod;
import com.irae.toolschallenge.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class TransactionResponse {

    @JsonProperty("cartao")
    private final String cardNumber;

    @JsonProperty("id")
    private final String id;

    @JsonProperty("descricao")
    private final TransactionDescriptionResponse description;

    @JsonProperty("formaPagamento")
    private final PaymentMethod paymentMethod;

    public TransactionResponse(Transaction transaction) {
        this.cardNumber = transaction.getCardNumber();
        this.id = transaction.getId();
        this.description = new TransactionDescriptionResponse(transaction.getDescription());
        this.paymentMethod = transaction.getPaymentMethod();
    }
}