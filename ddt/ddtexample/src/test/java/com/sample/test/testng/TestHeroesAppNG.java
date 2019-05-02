package com.sample.test.testng;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
	public Object[][] createData() {
		return new Object[][] { { "Spiderman", "Marvel", "bio de spiderman" }, { "Batman", "DC", "bio de batman" } };
	}

	public static class StaticProvider {
		@DataProvider(name = "provider2")
		public static Object[][] staticData() {
			return new Object[][] { { "Green Lantern", "DC", "bio de Green Lantern" },
					{ "Iron Man", "Marvel", "bio de Iron Man" } };
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

		// Instantiate a GET HTTP method
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

	@DataProvider(name = "db_provider")
	public Object[][] getDataFromDB() throws SQLException {
		Object[][] data = new Object[][] {};
		Properties connectionProps = new Properties();
		connectionProps.put("user", "postgres");
		connectionProps.put("password", "docker");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", connectionProps);
			statement = connection.createStatement();
			String query = "SELECT * FROM public.\"heroes\"";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				String name = rs.getString("nombre");
				String house = rs.getString("casa");
				String bio = rs.getString("bio");
				data = (Object[][]) ArrayUtils.add(data, new Object[] { name, house, bio });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
		return data;
	}
	
    @DataProvider(name = "excel_provider")
    public Object[][] getDataFromExcel() throws Exception {
        Object[][] data = new Object[][] {};
        Workbook book = new XSSFWorkbook(new File("./src/test/resources/heroes.xlsx"));
        Sheet sheet = book.getSheet("Heroes");
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            String name = row.getCell(0).getStringCellValue();
            String house = row.getCell(1).getStringCellValue();
            String bio = row.getCell(2).getStringCellValue();
            data = (Object[][]) ArrayUtils.add(data, new Object[] {name, house, bio});
        }
        book.close();
        return data;
    }

	private void test1(String name, String house, String bio) {
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("nombre")).click();
		driver.findElement(By.name("nombre")).sendKeys(name);
		WebElement dropdown = driver.findElement(By.name("casa"));
		dropdown.findElement(By.xpath("//option[. = '" + house + "']")).click();
		driver.findElement(By.name("bio")).click();
		driver.findElement(By.name("bio")).sendKeys(bio);
		driver.findElement(By.cssSelector(".btn-outline-primary")).click();
//		driver.findElement(By.name("button")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// @Test(dataProvider = "provider1")
	public void testFromSameClass(String name, String house, String bio) {
		test1(name, house, bio);
	}

	// @Test(dataProvider = "provider2", dataProviderClass = StaticProvider.class)
	public void testFromAnotherClass(String name, String house, String bio) {
		test1(name, house, bio);
	}

	 @Test(dataProvider = "file_provider")
	public void testFromFile(String name, String house, String bio) {
		test1(name, house, bio);
	}

	// @Test(dataProvider = "service_provider")
	public void testFromService(String name, String house, String bio) {
		test1(name, house, bio);
	}

//	@Test(dataProvider = "db_provider")
	public void testFromDataBase(String name, String house, String bio) {
		test1(name, house, bio);
	}

//	 @Test(dataProvider = "excel_provider")
	public void testFromExcel(String name, String house, String bio) throws Exception {
		test1(name, house, bio);
	}
	

}
