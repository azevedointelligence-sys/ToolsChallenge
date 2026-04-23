package com.irae.toolschallenge.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDescriptionRequest {

    @NotBlank(message = "Valor é obrigatório")
    @JsonProperty("valor")
    private String amount;

    @NotBlank(message = "Data/Hora é obrigatória")
    @JsonProperty("dataHora")
    private String dateTime;

    @NotBlank(message = "Estabelecimento é obrigatório")
    @JsonProperty("estabelecimento")
    private String establishment;

}