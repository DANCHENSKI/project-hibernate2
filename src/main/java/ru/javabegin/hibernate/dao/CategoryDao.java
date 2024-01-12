package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Address;
import ru.javabegin.hibernate.entity.Category;

public class CategoryDao extends GenericDao<Category> {
    public CategoryDao(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
