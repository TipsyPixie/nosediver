package com.castledust.nosediver.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.castledust.nosediver.entity.User;
import com.castledust.nosediver.repository.UserRepository;

@Service(value="customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(userName);
		if(user == null) {
			throw new UsernameNotFoundException(userName);
		}
		
		return new UserDetailsImpl(user);
	}
}
