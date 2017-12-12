package com.castledust.nosediver.service.common;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class DigesterImpl implements Digester {

    private MessageDigest messageDigest;

    public DigesterImpl(String algorithm) throws NoSuchAlgorithmException {

        messageDigest = MessageDigest.getInstance(algorithm);
    }

    public String digest(String input) {

        byte[] output = messageDigest.digest(input.getBytes(Charset.defaultCharset()));

        return toHexString(output);
    }

    private String toHexString(byte[] rawBytes) {

        final char[] hexCharacters = "0123456789ABCDEF".toCharArray();

        char[] hexString = new char[rawBytes.length * 2];

        for(int i = 0; i < rawBytes.length; i++) {
            int rawByte = rawBytes[i] & 0xFF;
            hexString[i * 2] = hexCharacters[rawByte >>> 4];
            hexString[i * 2 + 1] = hexCharacters[rawByte & 0x0F];
        }

        return new String(hexString);
    }
}
