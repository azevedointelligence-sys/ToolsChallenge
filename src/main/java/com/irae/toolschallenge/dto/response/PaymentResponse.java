package com.irae.toolschallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponse {

    @JsonProperty("transacao")
    private TransactionResponse transaction;

}