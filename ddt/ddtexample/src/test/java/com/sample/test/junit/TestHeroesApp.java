package com.sample.test.junit;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sample.framework.Configuration;
import com.sample.framework.Driver;

@RunWith(Parameterized.class)
public class TestHeroesApp {

	private WebDriver driver;
	private String name;
	private String house;
	private String bio;

	public TestHeroesApp(String name, String house,String bio) {
		super();
		this.name = name;
		this.house = house;
		this.bio = bio;
	}

	@Before
	public void setUp() throws IOException, Exception {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		Driver.add(Configuration.get("browser"), desiredCapabilities);
		driver = Driver.current();
		driver.get(Configuration.get("url"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Parameters
	public static Collection<Object[]> getParameters(){
		return Arrays.asList(
				new Object[][] {
					
					{"Spiderman", "Marvel","bio de spiderman"},
					{"Superman", "DC", "bio de superman"}
					
				}
		);
				
	}
	
	@Test
	public void heroesapp() {
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("nombre")).click();
		driver.findElement(By.name("nombre")).sendKeys(name);
		WebElement dropdown = driver.findElement(By.name("casa"));
		dropdown.findElement(By.xpath("//option[. = '"+house+"']")).click();
		driver.findElement(By.name("bio")).click();
		driver.findElement(By.name("bio")).sendKeys(bio);
		driver.findElement(By.cssSelector(".btn-outline-primary")).click();
		driver.findElement(By.name("button")).click();
	}
}
