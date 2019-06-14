package com.spring.Controller;

import com.spring.dao.CustomerDao;
import com.spring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/http_customer")
public class HttpEntityCustomerController {

    @Autowired
    private CustomerDao customerDao;

    static final String URL_CREATE_CUSTOMER  = "http://localhost:8080/http_customer/http_customer/";

    @PostMapping(value = "/http_customer", produces = "application/json")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer)
    {
        Customer customer1 = customerDao.save(customer);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("status","CREATED_NEW");
        return new ResponseEntity<Customer>(customer1,httpHeaders, HttpStatus.CREATED);
    }

    @GetMapping(value = "/customers_all", produces = "application/json")
    public List<Customer> getAllCustomers()
    {
        System.out.println(" get all the customers ");
        List<Customer> htt_customers = customerDao.findAll();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("status","CREATED_HTTP_CUSTOMERS");
         return htt_customers;
    }
}
