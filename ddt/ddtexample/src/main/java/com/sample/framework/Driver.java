package com.sample.framework;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	private static WebDriver driver;
	
	private static final HashMap<String, Class<?>> driverMap = new HashMap<String, Class<?>>(){
		{
			put("chrome", ChromeDriver.class);
			put("firefox", FirefoxDriver.class);
		}
	};
	
	public static void add (String browser, Capabilities capabilities) throws Exception{
		Class<?> driverClass = driverMap.get(browser);
		driver = (WebDriver) driverClass.getConstructor(Capabilities.class).newInstance(capabilities);
	}
	
	public static WebDriver current() {
		return driver;
	}
}
