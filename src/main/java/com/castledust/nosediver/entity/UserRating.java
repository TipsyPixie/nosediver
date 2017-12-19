package com.castledust.nosediver.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "user_ratings")
public class UserRating {

    @GeneratedValue
    @Id
    private Long id;

    @OneToOne
    private User user;

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
