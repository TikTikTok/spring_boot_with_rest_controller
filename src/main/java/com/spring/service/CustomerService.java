package com.spring.service;

import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> findAllCustomers()
    {
        System.out.println(" get all the customers in service ");
        return (List<Customer>) customerRepository.findAll();
    }
}
