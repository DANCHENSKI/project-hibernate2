package ru.javabegin.hibernate.dao;

import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Language;

public class LanguageDao extends GenericDao<Language> {
    public LanguageDao(SessionFactory sessionFactory) {
        super(Language.class, sessionFactory);
    }
}
