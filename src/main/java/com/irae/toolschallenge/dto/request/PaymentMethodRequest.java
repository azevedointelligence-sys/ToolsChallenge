package com.irae.toolschallenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.irae.toolschallenge.domain.PaymentTypeEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentMethodRequest {

    @NotBlank(message = "Tipo é obrigatório")
    @JsonProperty("tipo")
    private PaymentTypeEnum type;

    @NotBlank(message = "Parcelas é obrigatório")
    @JsonProperty("parcelas")
    private int installments;
}