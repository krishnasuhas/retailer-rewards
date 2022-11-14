package com.charter.retailerrewards.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Summary {
    private Integer month;
    private String customer;
    private long cumulativeRewards;
}
