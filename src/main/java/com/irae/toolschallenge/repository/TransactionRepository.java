package com.irae.toolschallenge.repository;

import com.irae.toolschallenge.domain.Transaction;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransactionRepository {

    private final Map<String, Transaction> database = new HashMap<>();

    public Transaction save(Transaction transaction) {
        database.put(transaction.getId(), transaction);
        return transaction;
    }

    public Optional<Transaction> findById(String id) {
        return Optional.ofNullable(database.get(id));
    }

    public List<Transaction> findAll() {
        return new ArrayList<>(database.values());
    }

}