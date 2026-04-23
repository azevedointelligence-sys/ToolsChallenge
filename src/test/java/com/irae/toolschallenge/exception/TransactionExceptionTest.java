package com.irae.toolschallenge.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class TransactionExceptionTest {

    @Test
    void shouldCreateExceptionWithMessage() {
        String id = "123";

        TransactionNotFoundException ex = new TransactionNotFoundException(id);

        assertTrue(ex.getMessage().contains(id));
    }

}
