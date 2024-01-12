package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.javabegin.hibernate.entity.City;


public class CityDao extends GenericDao<City> {
    public CityDao(SessionFactory sessionFactory) {
        super(City.class, sessionFactory);
    }

        public City getByName(String name) {
            Query<City> query = getCurrentSession().createQuery("select c from City c where c.city = :Name", City.class);
            query.setParameter("Name", name);
            query.setMaxResults(1);
            return query.getSingleResult();
    }

    }

