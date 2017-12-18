package com.castledust.nosediver.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.security.core.context.SecurityContextImpl;

import com.vaadin.server.VaadinSession;


public class VaadinSessionSecurityContextHolderStrategy implements SecurityContextHolderStrategy {
	
	private static final Logger logger = LoggerFactory.getLogger(VaadinSessionSecurityContextHolderStrategy.class);

	@Override
	public void clearContext() {
		
		getVaadinSession().setAttribute(SecurityContext.class, null);
	}

	@Override
	public SecurityContext getContext() {
		
		SecurityContext context = getVaadinSession().getAttribute(SecurityContext.class);
		
		if(context == null) {
			setContext(createEmptyContext());
		}
		
		return context;
	}

	@Override
	public void setContext(SecurityContext context) {

		getVaadinSession().setAttribute(SecurityContext.class, context);
	}

	@Override
	public SecurityContext createEmptyContext() {
		
		return new SecurityContextImpl();
	}
	
	private static VaadinSession getVaadinSession() {
		
		VaadinSession vaadinSession = VaadinSession.getCurrent();
		if(vaadinSession == null) {
			throw new IllegalStateException("No VaadinSession bound for current thread");
		}
		
		return vaadinSession;
	}
}
