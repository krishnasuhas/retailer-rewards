package com.charter.retailerrewards.controller;

import com.charter.retailerrewards.model.Transaction;
import com.charter.retailerrewards.service.TransactionService;
import com.charter.retailerrewards.serviceimpl.TransactionServiceImpl;
import com.charter.retailerrewards.util.WriteCsvToResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class TransactionController {
    private final TransactionServiceImpl transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = (TransactionServiceImpl) transactionService;
    }

    @RequestMapping(value = "/transactions", produces = "text/csv")
    public void findTransactions(HttpServletResponse response) throws IOException {
        List<Transaction> transactions = transactionService.findAll();

        WriteCsvToResponse.writeTransactions(response.getWriter(), transactions);
    }

    @RequestMapping(value = "/transactions/{transactionId}", produces = "text/csv")
    public void findTransaction(@PathVariable Long transactionId, HttpServletResponse response) throws IOException {
        Transaction transaction = transactionService.findById(transactionId);

        WriteCsvToResponse.writeTransaction(response.getWriter(), transaction);
    }
}
