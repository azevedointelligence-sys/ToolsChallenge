package com.irae.toolschallenge.controller;

import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.dto.response.TransactionResponse;
import com.irae.toolschallenge.service.TransactionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/transacoes")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;

    @PostMapping
    public ResponseEntity<PaymentResponse> processPayment(
            @RequestBody @Valid PaymentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.processPayment(request));

    }

    @PostMapping("/{id}/estornar")
    public ResponseEntity<PaymentResponse> cancelTransaction(@PathVariable @NotBlank String id) {
        return ResponseEntity.ok(service.cancelTransaction(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionResponse> findById(@PathVariable @NotBlank String id) {
        return ResponseEntity.ok(service.findTransactionById(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionResponse>> findAll() {
        return ResponseEntity.ok(service.findAllTransactions());
    }
}