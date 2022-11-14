package com.charter.retailerrewards.generator;

import org.junit.jupiter.api.Test;

import static com.charter.retailerrewards.generator.RewardsGenerator.findRewards;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RewardsGeneratorTest {

    @Test
    void findRewardsTest() {
        //Below 50
        assertEquals(0, findRewards(10L));
        //Above 50 abd Below 100
        assertEquals(40, findRewards(90L));
        //Above 100
        assertEquals(90, findRewards(120L));
    }
}