package com.castledust.nosediver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castledust.nosediver.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{

}
