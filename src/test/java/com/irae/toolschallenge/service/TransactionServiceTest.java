package com.irae.toolschallenge.service;

import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.exception.TransactionNotFoundException;
import com.irae.toolschallenge.mapper.TransactionMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @InjectMocks
    private TransactionService service;

    @Mock
    private TransactionMapper mapper;

    @Test
    void shouldProcessPaymentSuccessfully() {
        PaymentRequest request = new PaymentRequest();
        PaymentResponse response = service.processPayment(request);

        assertNotNull(response);
    }

    @Test
    void shouldThrowExceptionWhenTransactionNotFound() {
        String id = "123";

        assertThrows(TransactionNotFoundException.class, () -> {
            service.findTransactionById(id);
        });
    }

    @Test
    void shouldCancelTransactionSuccessfully() {
        PaymentRequest request = new PaymentRequest();
        PaymentResponse response = service.processPayment(request);

        assertNotNull(response.getTransaction().getId());

        PaymentResponse canceled = service.cancelTransaction(response.getTransaction().getId());

        assertNotNull(canceled);
    }

    @Test
    void shouldThrowExceptionWhenAvistaHasMoreThanOneInstallment() {
        PaymentRequest request = new PaymentRequest();

        assertThrows(IllegalArgumentException.class, () -> {
            service.processPayment(request);
        });
    }

    @Test
    void shouldGenerateIdWhenProcessingPayment() {
        PaymentRequest request = new PaymentRequest();

        PaymentResponse response = service.processPayment(request);

        assertNotNull(response.getTransaction().getId());
    }

    @Test
    void shouldFindTransactionById() {
        PaymentRequest request = new PaymentRequest();

        PaymentResponse created = service.processPayment(request);

        var result = service.findTransactionById(created.getTransaction().getId());

        assertEquals(created.getTransaction().getId(), result.getId());
    }

    @Test
    void shouldNotAllowCancelAlreadyCanceledTransaction() {
        PaymentRequest request = new PaymentRequest();

        PaymentResponse created = service.processPayment(request);

        service.cancelTransaction(created.getTransaction().getId());

        assertThrows(IllegalStateException.class, () -> {
            service.cancelTransaction(created.getTransaction().getId());
        });
    }
}