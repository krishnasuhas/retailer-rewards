package com.charter.retailerrewards.serviceimpl;

import com.charter.retailerrewards.model.Transaction;
import com.charter.retailerrewards.repository.TransactionRepository;
import com.charter.retailerrewards.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;

    public TransactionServiceImpl(TransactionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Transaction findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return (List<Transaction>) repository.findAll();
    }
}
