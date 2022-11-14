package com.charter.retailerrewards.controller;

import com.charter.retailerrewards.model.Summary;
import com.charter.retailerrewards.service.RewardsService;
import com.charter.retailerrewards.service.RewardsServiceImpl;
import com.charter.retailerrewards.util.WriteCsvToResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class RewardController {
    private final RewardsServiceImpl rewardsService;

    public RewardController(RewardsService rewardsService) {
        this.rewardsService = (RewardsServiceImpl) rewardsService;
    }

    @RequestMapping(value = "/monthlySummary", produces = "text/csv")
    public void findMonthlySummary(HttpServletResponse response) throws IOException {
        List<Summary> summaryList = rewardsService.findMonthlySummary();
        WriteCsvToResponse.writeSummaryList(response.getWriter(), summaryList, false);
    }

    @RequestMapping(value = "/totalSummary", produces = "text/csv")
    public void findTotalSummary(HttpServletResponse response) throws IOException {
        List<Summary> summaryList = rewardsService.findTotalSummary();
        WriteCsvToResponse.writeSummaryList(response.getWriter(), summaryList, true);
    }
}
