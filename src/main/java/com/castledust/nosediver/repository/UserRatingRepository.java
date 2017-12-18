package com.castledust.nosediver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castledust.nosediver.entity.UserRating;


public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
}
