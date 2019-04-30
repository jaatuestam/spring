package com.sample.test.testng;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class TestHeroesAppNG {

	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		driver = new FirefoxDriver();
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
	
	@DataProvider(name = "file_provider")
    public Object[][] getDataFromFile() throws IOException {
        List<String> content = FileUtils.readLines(new File("./src/test/resources/data.csv"), Charset.defaultCharset());
        Object[][] data = new Object[][] {};
        for (String line : content) {
            data = (Object[][]) ArrayUtils.add(data, line.split("\t"));
        }
        return data;
    }
	
	 @DataProvider(name = "service_provider")
	    public Object[][] getDataFromService() {
	        HttpClient client = new HttpClient();

	        //Instantiate a GET HTTP method
	        GetMethod method = new GetMethod("http://localhost:4999/test");
	        String result = "";
	        try {
	            int statusCode = client.executeMethod(method);
	            result = method.getResponseBodyAsString();
	            method.releaseConnection();
	            System.out.println(statusCode);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        String[] content = result.split("\n");
	        Object[][] data = new Object[][] {};
	        for (String line : content) {
	            data = (Object[][]) ArrayUtils.add(data, line.split("\t"));
	        }
	        return data;
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
	
//	@Test(dataProvider = "provider1")
	public void testFromSameClass(String name, String house, String bio) {
		test1(name,house,bio);
	}
	
//	@Test(dataProvider = "provider2", dataProviderClass = StaticProvider.class)
	public void testFromAnotherClass(String name, String house, String bio) {
		test1(name,house,bio);
	}
	
//	@Test(dataProvider = "file_provider")
	public void testFromFile(String name, String house, String bio) {
		test1(name,house,bio);
	}
	
	@Test(dataProvider = "service_provider")
    public void testSampleSearchFromService(String name, String house, String bio) {
		test1(name,house,bio);
    }
	
	
	
}
