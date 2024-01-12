package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.javabegin.hibernate.entity.Rental;

public class RentalDao extends GenericDao<Rental> {
    public RentalDao(SessionFactory sessionFactory) {
        super(Rental.class, sessionFactory);
    }

    public Rental getUntouchedRental() {
        Query<Rental> rentalQuery = getCurrentSession().createQuery("select r from Rental r where r.returnDate is null",Rental.class);
        rentalQuery.setMaxResults(1);
        return rentalQuery.getSingleResult();
    }
}
