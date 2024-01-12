package ru.javabegin.hibernate.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "movie", name = "film_actor")
public class FilmActor {
}
