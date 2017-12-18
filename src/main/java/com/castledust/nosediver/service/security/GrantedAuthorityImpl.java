package com.castledust.nosediver.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityImpl implements GrantedAuthority {
	
	private static final Logger logger = LoggerFactory.getLogger(GrantedAuthorityImpl.class);

	private String authority;
	
	public GrantedAuthorityImpl(String authority) {
		
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		
		return authority;
	}
}
