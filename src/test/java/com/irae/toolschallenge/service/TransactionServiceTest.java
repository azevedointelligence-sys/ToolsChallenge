package com.irae.toolschallenge.service;

import com.irae.toolschallenge.domain.Transaction;
import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.request.TransactionRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @InjectMocks
    private TransactionService service;

    @Mock
    private TransactionRepository repository;

    @Test
    void shouldThrowExceptionWhenTransactionIsNull() {

        PaymentRequest request = new PaymentRequest();

        assertThrows(Exception.class, () -> {
            service.processPayment(request);
        });
    }
}
