package com.irae.toolschallenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequest {

    @NotNull(message = "Transação é obrigatória")
    @JsonProperty("transacao")
    private TransactionRequest transaction;
}