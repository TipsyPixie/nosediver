package com.castledust.nosediver.entity;

import javax.persistence.*;


@Entity
@Table(name = "user_ratings")
public class UserRating {

    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    private User user;

    private Float rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
