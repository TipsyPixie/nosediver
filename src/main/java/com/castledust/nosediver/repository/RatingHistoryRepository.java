package com.castledust.nosediver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castledust.nosediver.entity.RatingHistory;


public interface RatingHistoryRepository extends JpaRepository<RatingHistory, Long> {

}
