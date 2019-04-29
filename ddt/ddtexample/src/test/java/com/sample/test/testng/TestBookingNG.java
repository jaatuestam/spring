package com.sample.test.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBookingNG {

	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://www.booking.com/");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test1() {
		driver.findElement(By.id("ss")).click();
		driver.findElement(By.id("ss")).sendKeys("santa marta");
		driver.findElement(By.cssSelector(".xp__input-group:nth-child(2) .sb-date-field__icon")).click();
		driver.findElement(By.cssSelector(
				".bui-calendar__wrapper:nth-child(1) .bui-calendar__row:nth-child(6) > .bui-calendar__date:nth-child(2)"))
				.click();
		driver.findElement(By.cssSelector(
				".bui-calendar__wrapper:nth-child(2) .bui-calendar__row:nth-child(2) > .bui-calendar__date:nth-child(4)"))
				.click();
		driver.findElement(By.cssSelector(".sb-searchbox__button")).click();
		driver.findElement(By.id("ss")).click();
	}
}
