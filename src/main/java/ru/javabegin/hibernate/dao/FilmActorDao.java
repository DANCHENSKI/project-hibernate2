package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.FilmActor;

public class FilmActorDao extends GenericDao<FilmActor> {
    public FilmActorDao(SessionFactory sessionFactory) {
        super(FilmActor.class, sessionFactory);
    }
}
