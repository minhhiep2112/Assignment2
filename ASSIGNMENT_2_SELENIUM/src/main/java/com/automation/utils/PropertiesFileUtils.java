package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
	
	public static String getProperty(String key) throws IOException {
		
		FileInputStream f = new FileInputStream("./configuration\\configs.properties");
		Properties p = new Properties();
		p.load(f);
		return p.getProperty(key);
		
		
	}
	
}
