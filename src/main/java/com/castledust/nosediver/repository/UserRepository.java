package com.castledust.nosediver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castledust.nosediver.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

}
