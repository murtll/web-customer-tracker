package com.murtll.springdemo.service;

import com.murtll.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public void deleteCustomerById(int id);

    Customer getCustomerById(int id);

    List<Customer> getMatchingCustomers(String search);
}
