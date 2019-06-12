package com.spring.Controller;

import com.spring.dao.CustomerDao;
import com.spring.exception.ResourceNotFoundException;
import com.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @PostMapping("/customers")
    public Customer createCustomer(@Valid @RequestBody Customer customer)
    {
        return customerDao.save(customer);
    }

    @GetMapping(value = "/customers_all", produces = "application/json")
    public List<Customer> getAllCustomers()
    {
        System.out.println(" get all the customers ");
        List<Customer> customers = customerDao.findAll();
        customers.forEach( customer -> System.out.println(" ID: "+customer.getId()+" Email: "+customer.getEmail() +" Name: "+customer.getName()));
        return customers;
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable(value = "id") Long id)
    {
        return customerDao.findOne(id);
    }

    @PutMapping("/customer/{id}")
    public Customer updateCustomer(@PathVariable(value = "id") Long id, @Valid  @RequestBody Customer customer)
    {
        Customer customer1 = customerDao.findOne(id);
        if(null == customer1)
        {
            throw new ResourceNotFoundException(" Customer ", "Id", id);
        }
        System.out.println(customer.getEmail());
        System.out.println(customer.getName());
        //customer1.setId(customer.getId());
        customer1.setEmail(customer.getEmail());
        customer1.setName(customer.getName());
        return customerDao.save(customer1);
    }
}
