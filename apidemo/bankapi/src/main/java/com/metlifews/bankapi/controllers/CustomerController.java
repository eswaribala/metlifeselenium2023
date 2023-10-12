package com.metlifews.bankapi.controllers;

import com.metlifews.bankapi.dtos.ResponseWrapper;
import com.metlifews.bankapi.models.Customer;
import com.metlifews.bankapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/v1.0/",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
       Customer customerObj= customerService.addCustomer(customer);
        if(customerObj.getCustomerId()>0)
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerObj);
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer not added");

    }

    @GetMapping(value = "/v1.0/",produces = MediaType.APPLICATION_XML_VALUE)
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
