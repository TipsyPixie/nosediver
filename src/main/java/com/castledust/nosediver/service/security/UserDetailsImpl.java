package com.castledust.nosediver.service.security;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.castledust.nosediver.entity.User;

public class UserDetailsImpl implements UserDetails {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);
	
	private String userName;
	private String encryptedPassword;
	private Boolean enabled;
	private String role;
	
	public UserDetailsImpl(User user) {
		
		this.userName = user.getUserName();
		this.encryptedPassword = user.getEncryptedPassword();
		this.enabled = user.getEnabled();
		this.role = user.getRole();
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {

		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new GrantedAuthorityImpl(role));
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return encryptedPassword;
	}

	@Override
	public String getUsername() {
		
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {

		return enabled.booleanValue();
	}
}
