package com.castledust.nosediver.config;


import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.castledust.nosediver.service.security.PasswordEncoderImpl;

@Configuration
@EnableWebSecurity
@PropertySource(value="classpath:constants.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier(value="customUserDetailsService")
	UserDetailsService userDetailsService;
	
    @Value("${encryption.algorithm}")
    private String encryptionAlgorithm;

    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	
    	auth.authenticationProvider(authenticationProvider());
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
    	
//        http.csrf().disable()
//                .authorizeRequests().anyRequest().authenticated()
//                .and().formLogin().loginPage("/login").permitAll()
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logged-out").permitAll()
//                .and().sessionManagement().sessionFixation().newSession();
    	
    	http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll();
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() throws NoSuchAlgorithmException {
        
    	DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        
        return authProvider;
    }
     
    @Bean
    public PasswordEncoder encoder() throws NoSuchAlgorithmException {
    	
        return new PasswordEncoderImpl(encryptionAlgorithm);
    }
}
