package ru.javabegin.hibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(schema = "movie",name = "film_text")
public class FilmText {
    @Id
    @Column(nullable = false, name = "film_id")
    private short filmId;

    @Column(nullable = false, name = "title", length = 255)
    private String title;

    @Type(type = "text")
    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "film_id")
    private Film film;

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(short filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }
}
