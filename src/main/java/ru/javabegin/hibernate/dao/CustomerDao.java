package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Customer;

public class CustomerDao extends GenericDao<Customer> {
    public CustomerDao(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
