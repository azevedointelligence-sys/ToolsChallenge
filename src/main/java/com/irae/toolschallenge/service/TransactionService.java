package com.irae.toolschallenge.service;

import com.irae.toolschallenge.domain.PaymentTypeEnum;
import com.irae.toolschallenge.domain.Transaction;
import com.irae.toolschallenge.domain.TransactionStatusEnum;
import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.dto.response.TransactionResponse;
import com.irae.toolschallenge.exception.TransactionNotFoundException;
import com.irae.toolschallenge.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionMapper mapper;

    private final Map<String, Transaction> database = new ConcurrentHashMap<>();

    public PaymentResponse processPayment(PaymentRequest request) {

        Transaction transaction = mapper.toDomain(request);

        String id = UUID.randomUUID().toString();
        transaction.setId(id);

        validatePayment(transaction);

        transaction.getDescription().setStatus(TransactionStatusEnum.AUTORIZADO);
        transaction.getDescription().setNsu(generateNsu());
        transaction.getDescription().setAuthorizationCode(generateAuthorizationCode());

        database.put(id, transaction);

        return mapper.toResponse(transaction);
    }

    public PaymentResponse cancelTransaction(String id) {

        Transaction transaction = database.get(id);

        if (transaction == null) {
            throw new TransactionNotFoundException(id);
        }

        if (TransactionStatusEnum.CANCELADO.equals(transaction.getDescription().getStatus())) {
            throw new IllegalStateException("Esta transação já está cancelada.");
        }

        transaction.getDescription().cancel();

        return mapper.toResponse(transaction);
    }

    public TransactionResponse findTransactionById(String id) {

        Transaction transaction = database.get(id);

        if (transaction == null) {
            throw new TransactionNotFoundException(id);
        }

        return mapper.toTransactionResponse(transaction);
    }

    public List<TransactionResponse> findAllTransactions() {

        return database.values()
                .stream()
                .map(mapper::toTransactionResponse)
                .toList();
    }

    private void validatePayment(Transaction transaction) {

        var paymentMethod = transaction.getPaymentMethod();

        if (PaymentTypeEnum.AVISTA.equals(paymentMethod.getType())
                && paymentMethod.getInstallments() > 1) {
            throw new IllegalArgumentException("Método de pagamento inválido: Transações à vista não pode ter mais de uma parcela");
        }
    }

    private String generateNsu() {
        return String.valueOf(System.currentTimeMillis());
    }

    private String generateAuthorizationCode() {
        return String.valueOf(new Random().nextInt(9999999));
    }
}