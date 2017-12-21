package com.castledust.nosediver.service.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class DigestingEncoder implements PasswordEncoder {

	private MessageDigest messageDigest;
    private static final String defaultAlgorithm = "SHA-256";

    @Override
    public String encode(CharSequence rawPassword) {
    	
    	String rawPasswordString = rawPassword.toString();

    	return toHexString(messageDigest.digest(rawPasswordString.getBytes()));
    }
    
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
    	
    	return encodedPassword != null &&
    			rawPassword != null &&
    			encodedPassword.equals(encode(rawPassword));
    }
    
    public DigestingEncoder() throws NoSuchAlgorithmException {

        this.messageDigest = MessageDigest.getInstance(defaultAlgorithm);
    }
    
    private String toHexString(byte[] input) {

        final char[] hexCharacters = "0123456789ABCDEF".toCharArray();

        char[] output = new char[input.length * 2];
        for (int i = 0; i < input.length; i++) {
            int rawByte = input[i] & 0xFF;
            output[i << 1] = hexCharacters[rawByte >>> 4];
            output[i << 1 + 1] = hexCharacters[rawByte & 0x0F];
        }

        return new String(output);
    }
}
