package com.spring.dao;

import com.spring.exception.ResourceNotFoundException;
import com.spring.model.Customer;
import com.spring.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDao {

    @Autowired
    CustomerRepository customerRepository;

    public Customer save(Customer customer)
    {
        return customerRepository.save(customer);
    }

    public List<Customer> findAll()
    {
        return (List<Customer>) customerRepository.findAll();
    }

    public Customer findOne(Long id)
    {
        //Optional<ResourceNotFoundException> optional= new  Optional<ResourceNotFoundException>();
        Customer customer = customerRepository.findOne(id);
        if(null == customer) {
                throw new ResourceNotFoundException(" Customer ", ":id", id);
            }
        return customer;
    }

    public void deleteCustomer(Customer customer)
    {
        customerRepository.delete(customer);
    }
}
