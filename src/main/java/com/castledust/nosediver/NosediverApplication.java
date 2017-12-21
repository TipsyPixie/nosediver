package com.castledust.nosediver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NosediverApplication {

	@SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(NosediverApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(NosediverApplication.class, args);
    }
}
