package com.castledust.nosediver.service.security;

import org.springframework.stereotype.Service;

import com.castledust.nosediver.repository.UserRepository;

@Service
public class SecurityUtilImpl implements SecurityUtil {

	private UserRepository userRepository;
	
	@Override
	public boolean auth(String userName, String password) {
		
		
		return false;
	}
}
