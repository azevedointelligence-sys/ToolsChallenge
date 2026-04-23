package com.irae.toolschallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.dto.response.TransactionResponse;
import com.irae.toolschallenge.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @org.springframework.boot.test.mock.mockito.MockBean
    private TransactionService service;

    @Test
    void shouldProcessPayment() throws Exception {
        PaymentRequest request = new PaymentRequest();
        PaymentResponse response = new PaymentResponse();

        when(service.processPayment(Mockito.any())).thenReturn(response);

        mockMvc.perform(post("/transacoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnBadRequestWhenInvalidInput() throws Exception {
        mockMvc.perform(post("/transacoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturnTransactionById() throws Exception {
        when(service.findTransactionById(any()))
                .thenReturn(new TransactionResponse());

        mockMvc.perform(get("/transacoes/1"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCancelTransaction() throws Exception {
        when(service.cancelTransaction(any()))
                .thenReturn(new PaymentResponse());

        mockMvc.perform(post("/transacoes/1/estorno"))
                .andExpect(status().isOk());
    }
}