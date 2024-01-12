package ru.javabegin.hibernate.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import ru.javabegin.hibernate.entity.Film;

public class FilmDao extends GenericDao<Film> {
    public FilmDao(SessionFactory sessionFactory) {
        super(Film.class, sessionFactory);
    }

    public Film getFirstAvaliableFilmForRent() {
        Query<Film> query = getCurrentSession().createQuery("select f from Film  f " +
                "where f.filmID not in (select distinct film.id from Inventory )",Film.class);
        query.setMaxResults(1);
        return query.getSingleResult();
    }
}
