package com.charter.retailerrewards.controller;

import com.charter.retailerrewards.model.Customer;
import com.charter.retailerrewards.service.CustomerService;
import com.charter.retailerrewards.serviceimpl.CustomerServiceImpl;
import com.charter.retailerrewards.util.WriteCsvToResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerServiceImpl customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = (CustomerServiceImpl) customerService;
    }

    @RequestMapping(value = "/customers", produces = "text/csv")
    public void findCustomers(HttpServletResponse response) throws IOException {
        List<Customer> customers = customerService.findAll();

        WriteCsvToResponse.writeCustomers(response.getWriter(), customers);
    }

    @RequestMapping(value = "/customers/{customerId}", produces = "text/csv")
    public void findCustomer(@PathVariable Long customerId, HttpServletResponse response) throws IOException {
        Customer customer = customerService.findById(customerId);

        WriteCsvToResponse.writeCustomer(response.getWriter(), customer);
    }
}
