package com.practice.Interview.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {
	
	public Properties setProperties(String env) {
		Properties properties = new Properties();
		try {
			System.out.println("San env info == " + env);
			if(env == null)
				env = "Production";
			
			String configFile = env.equals("Production") ? "config-prod.properties" : "config.properties";
			FileInputStream fileDir = new FileInputStream(System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\practice\\Interview\\qa\\config\\" + configFile);
			System.out.println("Path of th directory" + System.getProperty("user.dir")
					+ "\\src\\test\\java\\com\\practice\\Interview\\qa\\config\\" + configFile);
			properties.load(fileDir);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}
	
	// Configure Environment URLs in WebDriverIO
}
