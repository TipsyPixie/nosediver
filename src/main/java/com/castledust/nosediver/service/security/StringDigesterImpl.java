package com.castledust.nosediver.service.security;

import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class StringDigesterImpl implements StringDigester {

    private static final String defaultAlgorithm = "SHA-256";
    private MessageDigest messageDigest;

    public StringDigesterImpl() throws NoSuchAlgorithmException {

        this.messageDigest = MessageDigest.getInstance(defaultAlgorithm);
    }

    @Override
    public String encode(String rawPassword) {

        return toHexString(messageDigest.digest(rawPassword.getBytes()));
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
