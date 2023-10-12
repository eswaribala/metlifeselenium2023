package com.metlifews.bankapi.services;

import com.metlifews.bankapi.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customers;
    public CustomerService(){
        customers=new ArrayList<>();
    }

    public Customer addCustomer(Customer customer){
        customers.add(customer);
        return customer;
    }

    public List<Customer> getAllCustomers(){
        return customers;
    }
}
