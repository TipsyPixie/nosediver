package com.castledust.nosediver.service.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;


public class PasswordEncoderImpl implements PasswordEncoder {

	private static final Logger logger = LoggerFactory.getLogger(PasswordEncoderImpl.class);
	
	private MessageDigest messageDigest;

    public PasswordEncoderImpl(String algorithm) throws NoSuchAlgorithmException {

        messageDigest = MessageDigest.getInstance(algorithm);
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

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		
		String encodedRawPassword = toHexString(
				messageDigest.digest(rawPassword.toString().getBytes(Charset.defaultCharset()))
				);
		
		return (encodedRawPassword != null && encodedRawPassword.equals(encodedPassword));
	}

	@Override
	public String encode(CharSequence rawPassword) {
		
		byte[] output = messageDigest.digest(rawPassword.toString().getBytes(Charset.defaultCharset()));
		
		return toHexString(output);
	}
	
	
}
