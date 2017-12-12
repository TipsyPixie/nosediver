package com.castledust.nosediver.repository;

import com.castledust.nosediver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
