package com.charter.retailerrewards.service;

import com.charter.retailerrewards.model.Summary;
import com.charter.retailerrewards.model.Transaction;
import com.charter.retailerrewards.serviceimpl.TransactionServiceImpl;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.charter.retailerrewards.generator.RewardsGenerator.findRewards;

@Service
public class RewardsServiceImpl implements RewardsService {
    private final TransactionServiceImpl transactionService;

    public RewardsServiceImpl(TransactionService customerService) {
        this.transactionService = (TransactionServiceImpl) customerService;
    }

    private int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    @Override
    public List<Summary> findMonthlySummary() {
        List<Transaction> transactions = transactionService.findAll();
        Map<String, Map<Integer, Summary>> totalSummary = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerName = transaction.getCustomer().getName();
            Map<Integer, Summary> monthlySummary = totalSummary.getOrDefault(customerName, new HashMap<>());
            int month = getMonth(transaction.getDate());
            Summary summary = monthlySummary.getOrDefault(month, new Summary(month, customerName, 0));
            summary.setCumulativeRewards(summary.getCumulativeRewards() + findRewards(transaction.getPrice()));
            monthlySummary.put(month, summary);
            totalSummary.put(customerName, monthlySummary);
        }

        List<Summary> summaryList = new ArrayList<>();
        for (Map.Entry<String, Map<Integer, Summary>> entry : totalSummary.entrySet()) {
            summaryList.addAll(entry.getValue().values());
        }

        return summaryList;
    }

    @Override
    public List<Summary> findTotalSummary() {
        List<Transaction> transactions = transactionService.findAll();

        Map<String, Summary> totalSummary = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerName = transaction.getCustomer().getName();
            Summary summary = totalSummary.getOrDefault(customerName, new Summary(null, customerName, 0));
            summary.setCumulativeRewards(summary.getCumulativeRewards() + findRewards(transaction.getPrice()));
            totalSummary.put(customerName, summary);
        }

        return new ArrayList<>(totalSummary.values());
    }
}
