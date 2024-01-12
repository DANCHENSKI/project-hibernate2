package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.FilmCategory;

public class FilmCategoryDao extends GenericDao<FilmCategory>{
    public FilmCategoryDao(SessionFactory sessionFactory) {
        super(FilmCategory.class, sessionFactory);
    }
}
