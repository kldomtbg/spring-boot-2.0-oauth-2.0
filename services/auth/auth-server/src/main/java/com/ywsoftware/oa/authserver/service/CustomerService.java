package com.ywsoftware.oa.authserver.service;

import com.ywsoftware.oa.authserver.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll(String search);

    Customer findById(Long customerId);

    void save(Customer customer);

    void deleteById(Long customerId);
}
