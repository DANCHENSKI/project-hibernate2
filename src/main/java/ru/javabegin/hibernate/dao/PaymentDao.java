package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Payment;

public class PaymentDao extends GenericDao<Payment> {
    public PaymentDao(SessionFactory sessionFactory) {
        super(Payment.class, sessionFactory);
    }
}
