package com.xyz.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	/*
	 * This method will read the properties file
	 * 
	 * @param filePath
	 */
	public static Properties prop;
	public static void readProperties(String filePath) {
		try {
			FileInputStream fis= new FileInputStream(filePath);
		     prop = new Properties();
		     prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
} /*this method will return the value of specified key
	 @param string key
	 @return String value
*/
	public static String getproperty(String key) {
		return prop.getProperty(key);
	}

}
