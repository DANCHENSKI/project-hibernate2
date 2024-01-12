package ru.javabegin.hibernate.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(schema = "movie", name = "country")
public class Country {
    @Id
    @Column(nullable = false, name = "country_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short countryId;

    @Column(nullable = false,length = 50, name = "country")
    private String country;

    @Column(nullable = false, name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    public Short getCountryId() {
        return countryId;
    }

    public void setCountryId(Short countryId) {
        this.countryId = countryId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
