package com.charter.retailerrewards.generator;

import com.charter.retailerrewards.model.Transaction;
import org.hibernate.Session;
import org.hibernate.tuple.ValueGenerator;

public class RewardsGenerator implements ValueGenerator<Long> {

    @Override
    public Long generateValue(Session session, Object owner) {
        Transaction transaction = (Transaction) owner;
        return findRewards(transaction.getPrice());
    }

    public static Long findRewards(Long price) {
        long aboveFiftyReward = price > 50 ? (price - 50) : 0;
        long aboveHundredReward = price > 100 ? (price - 100) : 0;

        return aboveFiftyReward + aboveHundredReward;
    }
}
