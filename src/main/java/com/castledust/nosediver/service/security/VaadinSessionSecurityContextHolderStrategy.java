package com.castledust.nosediver.service.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolderStrategy;

public class VaadinSessionSecurityContextHolderStrategy implements SecurityContextHolderStrategy {

	@Override
	public void clearContext() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SecurityContext getContext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setContext(SecurityContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SecurityContext createEmptyContext() {
		// TODO Auto-generated method stub
		return null;
	}
}
