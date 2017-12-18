package com.castledust.nosediver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class NosediverApplication {
	
    public static void main(String[] args) {
        SpringApplication.run(NosediverApplication.class, args);
    }
}
