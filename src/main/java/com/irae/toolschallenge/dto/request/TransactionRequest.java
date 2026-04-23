package com.irae.toolschallenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRequest {

    private String id;

    @NotBlank(message = "Cartão é obrigatório")
    @JsonProperty("cartao")
    private String cardNumber;

    @Valid
    @NotNull(message = "Descrição é obrigatória")
    @JsonProperty("descricao")
    private TransactionDescriptionRequest description;

    @Valid
    @NotNull(message = "Forma de pagamento é obrigatória")
    @JsonProperty("formaPagamento")
    private PaymentMethodRequest paymentMethod;
}
