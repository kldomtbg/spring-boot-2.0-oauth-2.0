package com.ywsoftware.oa.authserver.controller;

import com.ywsoftware.oa.authserver.model.Customer;
import com.ywsoftware.oa.authserver.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/secured/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public List<Customer> getAll(@RequestParam(value = "search", required = false) String search) {
        return service.findAll(search);
    }

    @GetMapping(value = "/{customerId}")
    public Customer getOne(@PathVariable Long customerId) {
        return service.findById(customerId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@Validated @RequestBody Customer customer) {
        service.save(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.PUT)
    public void update(@Validated @RequestBody Customer customer, @PathVariable Long customerId) {
        customer.setId(customerId);
        service.save(customer);
    }

    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long customerId) {
        service.deleteById(customerId);
    }
}
