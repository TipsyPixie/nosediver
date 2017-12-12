package com.castledust.nosediver.config;

import com.castledust.nosediver.service.common.Digester;
import com.castledust.nosediver.service.common.DigesterImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.security.NoSuchAlgorithmException;


@Configuration
@PropertySource(value = "classpath:constants.properties")
public class BeanConfig {

    @Value("${digester.algorithm}")
    private String digesterAlgorithm;

    @Bean
    public Digester getDigester() throws NoSuchAlgorithmException {

        return new DigesterImpl(digesterAlgorithm);
    }
}
