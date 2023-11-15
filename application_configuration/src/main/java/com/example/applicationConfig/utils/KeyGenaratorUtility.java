package com.example.applicationConfig.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

public class KeyGenaratorUtility {


	public static KeyPair genarateRsaKey() {
		KeyPair keyPair;
		try {
			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			keyPair = keyPairGenerator.generateKeyPair();
			
		}
		
		catch (Exception e) {
			// TODO: handle exception
			throw new IllegalStateException();
		}
		
		return keyPair;
	}
	
	
}
