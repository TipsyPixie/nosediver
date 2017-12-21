package com.castledust.nosediver.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.castledust.nosediver.entity.User;
import com.castledust.nosediver.repository.UserRepository;

@Service
public class SecurityUtilImpl implements SecurityUtil {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean auth(String userName, String password) {

        User user = userRepository.findTopByUserName(userName);

        return user != null &&
                passwordEncoder.matches(password, user.getEncodedPassword());
    }
}
