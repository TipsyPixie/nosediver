package com.castledust.nosediver.repository;

import com.castledust.nosediver.entity.UserRating;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRatingRepository extends JpaRepository<UserRating, Long> {
}
