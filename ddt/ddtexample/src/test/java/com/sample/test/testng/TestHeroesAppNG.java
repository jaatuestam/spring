package com.sample.test.testng;

import static org.testng.Assert.assertNotEquals;

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
		return new Object[][] { { "Thor", "Marvel", "El padre de Thor, Od�n, decide que su hijo necesita que le ense�en la humildad y, en consecuencia, coloca a Thor (sin recuerdos de la divinidad) en el cuerpo y los recuerdos de un estudiante de medicina humana existente, parcialmente discapacitado, Donald Blake.Despu�s de convertirse en m�dico y de vacaciones en Noruega, Blake presencia la llegada de una partida de exploraci�n alien�gena. Blake huye de los extraterrestres a una cueva. Despu�s de descubrir el martillo de Thor, Mjolnir (disfrazado como un bast�n) y golpearlo contra una roca, se transforma en el dios del trueno.M�s tarde, en Thor# 159, se revela que Blake siempre ha sido Thor, el hechizo de Odin lo ha llevado a olvidar su historia como El Dios del Trueno y creerse mortal " }, 
			{ "Batman", "DC", "La recopilaci�n de los sucesos que integran la vida del personaje ha sido objeto de varias revisiones y cambios constantes. Los investigadores William Uricchio y Roberta E. Pearson concluyeron: �A diferencia de otros personajes, Batman no est� ubicado en un per�odo determinado, sino que ha prevalecido como �cono en una gran variedad de textos durante m�s de cinco d�cadas�. Para determinar las sucesivas relaciones del h�roe, los escritores han tomado la historia y origen de Batman como �ejes principales�: cuando Bruce era un ni�o peque�o de solo ocho a�os, qued� sumamente traumatizado tras presenciar la muerte de sus padres �el doctor Thomas Wayne y su esposa Martha� perpetrada por el delincuente Joe Chill durante un asalto mal terminado cuando los Wayne se opusieron al robo de sus pertenencias. La impresi�n lo condujo a tomar la decisi�n de convertirse en el �hombre murci�lago� y combatir el delito en su ciudad. En Batman Confidential n�mero catorce, se menciona que el asesinato aconteci� un 26 de junio, fecha que Bruce anualmente conmemora visitando la �escena del crimen�. " } };
	}

	public static class StaticProvider {
		@DataProvider(name = "provider2")
		public static Object[][] staticData() {
			return new Object[][] { { "Flash", "DC", "Bartholomew Henry \"Barry\" Allen es un cient�fico asistente de la Divisi�n de Ciencia Criminal y Forense del Departamento de Polic�a de Ciudad Central en 1956, conocido por ser lento y llegar siempre tarde a su trabajo, lo cual enojaba a su prometida Iris West. Una noche, mientras sal�a del trabajo, un rayo cay� en su laboratorio lleno de qu�micos que ba�aron a Allen, creando un accidente que le otorgar�a una s�per velocidad e incre�bles reflejos (tambi�n la capacidad de viajar en el tiempo y entre dimensiones). Con un traje rojo y el s�mbolo de un rayo (que recuerda al original Capit�n Maravilla de Fawcett Comics), su novia lo nombr� \"Flash\", (ya que cuando era ni�o algo veloz mat� a su madre y Barry dijo que fue como un flash) empezando as� a combatir el crimen en Ciudad Central. Como civil usaba un anillo del cual extra�a su traje, el cual pod�a encoger por medio de un gas. Allen era conocido por en ocasiones bromear contra sus enemigos, y tambi�n una caracter�stica que lo hizo temido cuando regres� de la muerte es tratar a todos sus enemigos por igual, a diferencia de los otros velocistas que trataban a Capit�n Fr�o y a sus secuaces como tontos comparados con Gorilla Grodd y el Profesor Zoom. En su identidad civil, almacena el traje comprimido en un anillo especial mediante el uso de un gas especial que podr�a comprimir fibras de tela a una fracci�n muy peque�a de su tama�o normal." },
					{ "Iron Man", "Marvel", "Anthony Edward \"Tony\" Stark fue un auto-proclamado genio exc�ntrico, multimillonario, playboy, fil�ntropo y anterior Director General de Industrias Stark. Con su gran intelecto, Stark se volvi� un inventor reconocido mundialmente hasta que fue secuestrado por los Diez Anillos. Con su vida en la l�nea, Stark dise�� un traje blindado para escapar de la organizaci�n, regresando a casa y convirti�ndose en el superh�roe conocido como Iron Man, luchando contra los terroristas, as� como contra su ex compa�ero de negocios, Obadiah Stane. Stark disfrut� de la fama que vino con su nueva identidad secreta y decidi� compartirla con el mundo, anunciando p�blicamente que �l era Iron Man. " } };
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
			data = (Object[][]) ArrayUtils.add(data, new Object[] { name, house, bio });
		}
		book.close();
		return data;
	}

	private void test1(String name, String house, String bio) {
		double initial = countRegisters();
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("nombre")).click();
		driver.findElement(By.name("nombre")).sendKeys(name);
		WebElement dropdown = driver.findElement(By.name("casa"));
		dropdown.findElement(By.xpath("//option[. = '" + house + "']")).click();
		driver.findElement(By.name("bio")).click();
		driver.findElement(By.name("bio")).sendKeys(bio);
		driver.findElement(By.cssSelector(".btn-outline-primary")).click();
		// driver.findElement(By.name("button")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double total = countRegisters();
		assertNotEquals(initial, total);
	}

//	@Test(dataProvider = "provider1")
	public void testFromSameClass(String name, String house, String bio) {
		test1(name, house, bio);
	}

//	 @Test(dataProvider = "provider2", dataProviderClass = StaticProvider.class)
	public void testFromAnotherClass(String name, String house, String bio) {
		test1(name, house, bio);
	}

//	 @Test(dataProvider = "file_provider")
	public void testFromFile(String name, String house, String bio) {
		test1(name, house, bio);
	}

//	 @Test(dataProvider = "service_provider")
	public void testFromService(String name, String house, String bio) {
		test1(name, house, bio);
	}

//	 @Test(dataProvider = "db_provider")
	public void testFromDataBase(String name, String house, String bio) {
		test1(name, house, bio);
	}

	 @Test(dataProvider = "excel_provider")
	public void testFromExcel(String name, String house, String bio) throws Exception {
		test1(name, house, bio);
	}

	private double countRegisters() {
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod("https://heroesapp-7328f.firebaseio.com/Heroes.json");
		String result = "";
		try {
			client.executeMethod(method);
			result = method.getResponseBodyAsString();
			method.releaseConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (result == null) {
			return 0;
		}
		long count = result.chars().filter(ch -> ch == ':').count();
		return (count / 4);

	}

}
