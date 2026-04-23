package com.irae.toolschallenge.mapper;

import com.irae.toolschallenge.dto.request.PaymentRequest;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransactionMapperTest {

    private final TransactionMapper mapper =
            Mappers.getMapper(TransactionMapper.class);

    @Test
    void shouldMapRequestToEntity() {
        PaymentRequest request = new PaymentRequest();

        var entity = mapper.toDomain(request);

        assertNotNull(entity);
    }

}