package com.charter.retailerrewards.service;

import com.charter.retailerrewards.model.Customer;

import java.util.List;

public interface CustomerService {

    Customer findById(Long id);

    List<Customer> findAll();
}
