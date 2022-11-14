package com.charter.retailerrewards.service;

import com.charter.retailerrewards.model.Transaction;

import java.util.List;

public interface TransactionService {
    Transaction findById(Long id);

    List<Transaction> findAll();
}
