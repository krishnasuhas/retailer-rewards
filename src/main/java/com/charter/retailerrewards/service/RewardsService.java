package com.charter.retailerrewards.service;

import com.charter.retailerrewards.model.Summary;

import java.util.List;

public interface RewardsService {
    List<Summary> findMonthlySummary();

    List<Summary> findTotalSummary();
}
