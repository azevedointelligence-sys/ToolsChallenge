package com.irae.toolschallenge.mapper;

import com.irae.toolschallenge.domain.PaymentTypeEnum;
import com.irae.toolschallenge.dto.request.PaymentMethodRequest;
import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.request.TransactionDescriptionRequest;
import com.irae.toolschallenge.dto.request.TransactionRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionMapperTest {

    private final TransactionMapper mapper =
            Mappers.getMapper(TransactionMapper.class);

    private PaymentRequest request;
    private TransactionRequest transactionRequest;

    @BeforeEach
    void setUp() {
        transactionRequest = new TransactionRequest();
        transactionRequest.setId("9999");
        transactionRequest.setCardNumber("4789478947894789");
        transactionRequest.setDescription(new TransactionDescriptionRequest("1598.09",
                "23-04-2026 10:00", "Cobasi"));
        transactionRequest.setPaymentMethod(new PaymentMethodRequest(PaymentTypeEnum.AVISTA, 1));

        request = new PaymentRequest(transactionRequest);
    }

    @Test
    void shouldMapRequestToEntity() {
        var entity = mapper.toDomain(request);
        assertNotNull(entity);
    }

}