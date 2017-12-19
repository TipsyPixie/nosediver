package com.castledust.nosediver.entity;

import javax.persistence.*;


@Entity
@Table(name = "user_ratings")
public class UserRating {

    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    @Column(unique = true, nullable = false)
    private User user;

    @Column(nullable = false)
    private Float averageRating;

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
        return averageRating;
    }

    public void setRating(Float rating) {
        this.averageRating = rating;
    }
}
