package com.irae.toolschallenge.mapper;

import com.irae.toolschallenge.domain.PaymentMethod;
import com.irae.toolschallenge.domain.Transaction;
import com.irae.toolschallenge.domain.TransactionDescription;
import com.irae.toolschallenge.dto.request.PaymentRequest;
import com.irae.toolschallenge.dto.response.PaymentResponse;
import com.irae.toolschallenge.dto.response.TransactionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(source = "transaction.cardNumber", target = "cardNumber")
    @Mapping(source = "transaction.description", target = "description")
    @Mapping(source = "transaction.paymentMethod", target = "paymentMethod")
    Transaction toDomain(PaymentRequest request);

    default PaymentResponse toResponse(Transaction transaction) {
        return new PaymentResponse(toTransactionResponse(transaction));
    }

    TransactionResponse toTransactionResponse(Transaction transaction);

    TransactionDescription toDescription(com.irae.toolschallenge.dto.request.TransactionDescriptionRequest request);

    PaymentMethod toPaymentMethod(com.irae.toolschallenge.dto.request.PaymentMethodRequest request);

    com.irae.toolschallenge.dto.response.TransactionDescriptionResponse toDescriptionResponse(TransactionDescription description);
}