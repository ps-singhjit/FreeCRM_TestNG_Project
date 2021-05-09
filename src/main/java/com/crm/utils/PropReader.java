package com.crm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropReader {
	
	public static String readEncodedProperty(String Key) {
		String decryptedValue ="";
		try {
			Properties prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/com/crm/config/config.properties");
			prop.load(ip);
			String encryptedValue = prop.getProperty(Key);
			decryptedValue = EncryptionUtils.decrypt(encryptedValue);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return decryptedValue;
	}
}
