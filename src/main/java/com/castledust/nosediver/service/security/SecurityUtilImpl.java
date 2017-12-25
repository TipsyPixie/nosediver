package com.castledust.nosediver.service.security;

import com.castledust.nosediver.entity.User;
import com.castledust.nosediver.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityUtilImpl implements SecurityUtil {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUtilImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StringDigesterImpl stringDigester;

    @Override
    public boolean auth(String userName, String password) {

        User user = userRepository.findTopByUserName(userName);

        return user != null &&
                user.getEncodedPassword().equals(stringDigester.encode(password));
    }
}
