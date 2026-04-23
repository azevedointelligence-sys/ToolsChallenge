package com.irae.toolschallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {

    @JsonProperty("transacao")
    private TransactionResponse transaction;
}