package com.irae.toolschallenge.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.irae.toolschallenge.domain.TransactionDescription;
import com.irae.toolschallenge.domain.TransactionStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
@AllArgsConstructor
public class TransactionDescriptionResponse {

    @JsonProperty("valor")
    private final String amount;

    @JsonProperty("dataHora")
    private final String dateTime;

    @JsonProperty("estabelecimento")
    private final String establishment;

    @JsonProperty("nsu")
    private final String nsu;

    @JsonProperty("codigoAutorizacao")
    private final String authorizationCode;

    @JsonProperty("status")
    private final TransactionStatusEnum status;

    public TransactionDescriptionResponse(TransactionDescription description) {
        this.amount = description.getAmount();
        this.dateTime = description.getDateTime();
        this.establishment = description.getEstablishment();
        this.nsu = description.getNsu();
        this.authorizationCode = description.getAuthorizationCode();
        this.status = description.getStatus();
    }

}
