package com.murtll.springdemo.service;

import com.murtll.springdemo.entity.Customer;
import com.murtll.springdemo.repository.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public List<Customer> getCustomers() {

        List<Customer> result;
        try {
            result = customerDAO.getCustomers();
        } catch (Exception e) {
            e.printStackTrace();
            return getCustomers();
        }

        return result;
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {

        try {
            customerDAO.saveCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            saveCustomer(customer);
        }
    }

    @Override
    @Transactional
    public void deleteCustomerById(int id) {

        try {
            customerDAO.deleteCustomerById(id);
        } catch (Exception e) {
            e.printStackTrace();
            deleteCustomerById(id);
        }
    }

    @Override
    @Transactional
    public Customer getCustomerById(int id) {

        Customer result;

        try {
            result = customerDAO.getCustomerById(id);
        } catch (Exception e) {
            return getCustomerById(id);
        }

        return result;
    }

    @Override
    @Transactional
    public List<Customer> getMatchingCustomers(String search) {

        List<Customer> result;

        try {
            result = customerDAO.getMatchingCustomers(search);
        } catch (Exception e) {
            return getMatchingCustomers(search);
        }

        return result;
    }
}
