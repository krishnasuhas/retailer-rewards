package com.charter.retailerrewards.serviceimpl;

import com.charter.retailerrewards.model.Customer;
import com.charter.retailerrewards.repository.CustomerRepository;
import com.charter.retailerrewards.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) repository.findAll();
    }
}
