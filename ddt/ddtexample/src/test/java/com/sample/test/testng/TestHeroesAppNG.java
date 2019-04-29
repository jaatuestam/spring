package com.sample.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestHeroesAppNG {

	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/heroes");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name = "provider1")
	public Object[][] createData(){
		return new Object[][] {
			{"Spiderman", "Marvel","bio de spiderman"},
			{"Batman", "DC", "bio de batman"}
		};
	}
	
	public static class StaticProvider{
		@DataProvider(name = "provider2")
		public static Object[][] staticData(){
			return new Object[][] {
				{"Green Lantern","DC","bio de Green Lantern"},
				{"Iron Man", "Marvel", "bio de Iron Man"}
			};
		}
	}

	private void test1(String name, String house, String bio) {
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
	
	@Test(dataProvider = "provider1")
	public void testFromSameClass(String name, String house, String bio) {
		test1(name,house,bio);
	}
	
	@Test(dataProvider = "provider2", dataProviderClass = StaticProvider.class)
	public void testFromAnotherClass(String name, String house, String bio) {
		test1(name,house,bio);
	}
	
	
}
