package com.charter.retailerrewards.controller;

import com.charter.retailerrewards.model.Summary;
import com.charter.retailerrewards.model.Transaction;
import com.charter.retailerrewards.service.TransactionService;
import com.charter.retailerrewards.serviceimpl.TransactionServiceImpl;
import com.charter.retailerrewards.util.WriteCsvToResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static com.charter.retailerrewards.generator.RewardsGenerator.findRewards;

@RestController
public class RewardController {
    private final TransactionServiceImpl transactionService;

    public RewardController(TransactionService customerService) {
        this.transactionService = (TransactionServiceImpl) customerService;
    }

    private int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH);
    }

    @RequestMapping(value = "/monthlySummary", produces = "text/csv")
    public void findMonthlySummary(HttpServletResponse response) throws IOException {
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

        WriteCsvToResponse.writeSummaryList(response.getWriter(), summaryList, false);
    }

    @RequestMapping(value = "/totalSummary", produces = "text/csv")
    public void findTotalSummary(HttpServletResponse response) throws IOException {
        List<Transaction> transactions = transactionService.findAll();

        Map<String, Summary> totalSummary = new HashMap<>();

        for (Transaction transaction : transactions) {
            String customerName = transaction.getCustomer().getName();
            Summary summary = totalSummary.getOrDefault(customerName, new Summary(null, customerName, 0));
            summary.setCumulativeRewards(summary.getCumulativeRewards() + findRewards(transaction.getPrice()));
            totalSummary.put(customerName, summary);
        }

        List<Summary> summaryList = new ArrayList<>(totalSummary.values());

        WriteCsvToResponse.writeSummaryList(response.getWriter(), summaryList, true);
    }
}
