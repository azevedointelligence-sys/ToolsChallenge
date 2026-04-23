package com.irae.toolschallenge.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException() {
        super("Transação não encontrada");
    }

    public TransactionNotFoundException(String id) {
        super(String.format("Transação %s não encontrada", id));
    }
}
