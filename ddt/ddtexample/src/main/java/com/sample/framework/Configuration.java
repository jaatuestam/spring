package com.sample.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Configuration {

	private static Properties properties;
	
	public static void load() throws IOException {
		Configuration conf = new Configuration();
		properties = new Properties();
		InputStream is = new FileInputStream(new File("config.properties"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
		try {
			properties.load(reader);
		} finally {
			is.close();
			reader.close();
		}
	}
	
	public static String get(String property) throws IOException {
		if(properties == null) {
			load();
		}
		String value = properties.getProperty(property);
		if(value == null) {
			return "";
		}
		return value;
	}
}
