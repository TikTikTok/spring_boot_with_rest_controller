package com.spring.Controller;

import com.spring.dao.CustomerDao;
import com.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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

   /* @RequestMapping(value = "/customers", produces = "application/json", method= RequestMethod.GET)
    public List<Customer> getAllCustomers()
    {
        System.out.println(" get all the customers ");
        List<Customer> customers = customerDao.findAllCustomers();

        customers.forEach( customer -> System.out.println(" ID: "+customer.getId()+" Email: "+customer.getEmail() +" Name: "+customer.getName()));
        return customers;
    }*/
}
