package com.yaelev.sakilagui.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film")
public class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "film_id")
    private int filmId;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "release_year")
    private int releaseYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    @Basic
    @Column(name = "rental_duration")
    private int rentalDuration;

    @Basic
    @Column(name = "rental_rate")
    private BigDecimal rentalRate;
    @Basic
    @Column(name = "length")
    private int length;
    @Basic
    @Column(name = "replacement_cost")
    private BigDecimal replacementCost;
    @Basic
    @Column(name = "rating")
    private String rating;
    @Basic
    @Column(name = "special_features")
    private String specialFeatures;
    @Basic
    @Column(name = "last_update")
    private Timestamp lastUpdate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_actor",
            joinColumns = { @JoinColumn(name = "film_id")},
            inverseJoinColumns = { @JoinColumn(name = "actor_id")})
    private Set<Actor> actorSet;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "film_category",
            joinColumns = { @JoinColumn(name = "film_id")},
            inverseJoinColumns = { @JoinColumn(name = "category_id")})
    private Set<Category> categorySet ;



    public Film() {
        this.actorSet = new HashSet<>();
        this.lastUpdate = Timestamp.from(Instant.now());
    }

    public Film(int filmId, String title, String description,
                int releaseYear, Language languageId, int rentalDuration,
                BigDecimal rentalRate, int length, BigDecimal replacementCost,
                String rating, String specialFeatures)
    {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.language = languageId;
        this.rentalDuration = rentalDuration;
        this.rentalRate = rentalRate;
        this.length = length;
        this.replacementCost = replacementCost;
        this.rating = rating;
        this.specialFeatures = specialFeatures;
        this.lastUpdate = Timestamp.from(Instant.now());
    }

    @Override
    public String toString() {
        return filmId +
                "," + title  +
                ", " +releaseYear +
                ", " +language +
                ", " + length +
                ", " + replacementCost +
                ", " + rating +
                ", " + specialFeatures;


    }

    public Set<Actor> getActorSet() {
        return actorSet;
    }

    public void setActorSet(Set<Actor> actorSet) {
        this.actorSet = actorSet;
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    public void setCategorySet(Set<Category> categorySet) {
        this.categorySet = categorySet;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
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

    public Object getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Object getLanguage() {
        return language;
    }

    public void setLanguage(Language languageId) {
        this.language = languageId;
    }

    public int getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(int rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }



}
