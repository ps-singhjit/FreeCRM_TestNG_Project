package com.crm.utils;

public class EncryptionRun {
	public static void main(String[] args) {
		final String secretKey = "secret123";
		String OriginalString = "Test@123";
		String encryptedString = EncryptionUtils.encrypt(OriginalString,secretKey);
		String decryptedString = EncryptionUtils.decrypt(encryptedString,secretKey);
		System.out.println("encryptedString :: " + encryptedString);
		System.out.println("decryptedString :: " + decryptedString);
		
	}

}
