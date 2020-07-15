package com.murtll.springdemo.repository;

import com.murtll.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    public void deleteCustomerById(int id);

    public Customer getCustomerById(int id);

    List<Customer> getMatchingCustomers(String search);
}
