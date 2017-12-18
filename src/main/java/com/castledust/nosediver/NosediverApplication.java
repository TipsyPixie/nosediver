package com.castledust.nosediver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;

import com.castledust.nosediver.service.security.VaadinSessionSecurityContextHolderStrategy;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NosediverApplication {

	static {
		SecurityContextHolder.setStrategyName(VaadinSessionSecurityContextHolderStrategy.class.getName());
	}
	
    public static void main(String[] args) {
        SpringApplication.run(NosediverApplication.class, args);
    }
}
