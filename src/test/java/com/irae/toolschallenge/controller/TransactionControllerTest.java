package com.irae.toolschallenge.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.irae.toolschallenge.domain.PaymentMethod;
import com.irae.toolschallenge.domain.PaymentTypeEnum;
import com.irae.toolschallenge.domain.Transaction;
import com.irae.toolschallenge.domain.TransactionDescription;
import com.irae.toolschallenge.dto.request.PaymentMethodRequest;
import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.request.TransactionDescriptionRequest;
import com.irae.toolschallenge.dto.request.TransactionRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.dto.response.TransactionResponse;
import com.irae.toolschallenge.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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

    @MockBean
    private TransactionService service;

    @Autowired
    private ObjectMapper objectMapper;

    private PaymentRequest buildValidRequest() {
        TransactionRequest transaction = new TransactionRequest();
        transaction.setId("9999");
        transaction.setCardNumber("4789478947894789");

        transaction.setDescription(
                new TransactionDescriptionRequest("1598.09", "23-04-2026 10:00", "Cobasi")
        );

        transaction.setPaymentMethod(
                new PaymentMethodRequest(PaymentTypeEnum.AVISTA, 1)
        );

        return new PaymentRequest(transaction);
    }

    private PaymentResponse buildResponse() {
        Transaction transaction = new Transaction();
        transaction.setId("9999");
        transaction.setCardNumber("4789478947894789");
        transaction.setDescription(
                new TransactionDescription("1598.09", "23-04-2026 10:00", "Cobasi")
        );
        transaction.setPaymentMethod(
                new PaymentMethod(PaymentTypeEnum.AVISTA, 1)
        );

        return new PaymentResponse(new TransactionResponse(transaction));
    }

    @Test
    void shouldProcessPayment() throws Exception {

        when(service.processPayment(any()))
                .thenReturn(buildResponse());

        mockMvc.perform(post("/api/v1/transacoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(buildValidRequest())))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnTransactionById() throws Exception {

        when(service.findTransactionById(any()))
                .thenReturn(buildResponse().getTransaction());

        mockMvc.perform(get("/api/v1/transacoes/9999"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCancelTransaction() throws Exception {

        when(service.cancelTransaction(any()))
                .thenReturn(buildResponse());

        mockMvc.perform(post("/api/v1/transacoes/9999/estorno"))
                .andExpect(status().isOk());
    }
}
