package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Actor;

public class ActorDao extends GenericDao<Actor> {
    public ActorDao(SessionFactory sessionFactory) {
        super(Actor.class, sessionFactory);
    }
}
