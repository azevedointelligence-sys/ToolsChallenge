package com.irae.toolschallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@AllArgsConstructor
@Builder
public class PaymentResponse {

    @JsonProperty("transacao")
    private TransactionResponse transaction;

}