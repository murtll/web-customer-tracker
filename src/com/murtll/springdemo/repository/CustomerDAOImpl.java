package com.murtll.springdemo.repository;

import com.murtll.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {

        Session session = sessionFactory.getCurrentSession();

        Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

        return query.getResultList();
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();

//        save or update customer
        session.saveOrUpdate(customer);
    }

    @Override
    public void deleteCustomerById(int id) {

        Session session = sessionFactory.getCurrentSession();

        Customer customer = session.get(Customer.class, id);

        session.delete(customer);

    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();

        return session.get(Customer.class, id);
    }

    @Override
    public List<Customer> getMatchingCustomers(String search) {
//        get session
        Session session = sessionFactory.getCurrentSession();

//        create query
        Query<Customer> query = session.createQuery("from Customer where " +
                "lastName like '%" + search + "%' or " +
                "firstName like '%" + search + "%' or " +
                "email like '%" + search + "%'", Customer.class);

//        get and return result list
        return query.getResultList();
    }
}
