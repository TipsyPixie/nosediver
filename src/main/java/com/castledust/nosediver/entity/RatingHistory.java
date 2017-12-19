package com.castledust.nosediver.entity;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "rating_histories")
public class RatingHistory {

    @Id
    @GeneratedValue
    private Long id;

    private Time occurrenceTime;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User rater;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.ALL)
    private User ratee;

    private Float rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getOccurrenceTime() {
        return occurrenceTime;
    }

    public void setOccurrenceTime(Time occurrenceTime) {
        this.occurrenceTime = occurrenceTime;
    }

    public User getRater() {
		return rater;
	}

	public void setRater(User rater) {
		this.rater = rater;
	}

	public User getRatee() {
		return ratee;
	}

	public void setRatee(User ratee) {
		this.ratee = ratee;
	}

	public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
