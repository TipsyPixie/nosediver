package com.castledust.nosediver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.castledust.nosediver.repository.UserRepository;

@SpringBootApplication
public class NosediverApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(NosediverApplication.class);
	
    public static void main(String[] args) {
        SpringApplication.run(NosediverApplication.class, args);
    }

}
