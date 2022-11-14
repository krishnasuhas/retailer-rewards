package com.charter.retailerrewards.model;

import com.charter.retailerrewards.generator.RewardsGenerator;
import lombok.*;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long price;

    private Date date;

    @GeneratorType(type = RewardsGenerator.class, when = GenerationTime.ALWAYS)
    private Long rewards;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
