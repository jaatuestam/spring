package com.sample.test.junit;

import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
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
					
					{"Spiderman", "Marvel","En Forest Hills, Queens, Nueva York, el estudiante de la Escuela Midtown High, Peter Benjamin Parker es un cient�fico hu�rfano que vive con su t�o Ben y su t�a May. Como se describe en Amazing Fantasy # 15 (agosto de 1962), es mordido por una ara�a radioactiva (err�neamente clasificada como un insecto en el panel) en una exhibici�n de ciencias y \"adquiere la agilidad y la fuerza proporcional de un ar�cnido \".Junto con la s�per fuerza, Parker gana la capacidad de adherirse a paredes y techos. A trav�s de su habilidad nativa para la ciencia, desarrolla un dispositivo que le permite disparar cintas adhesivas de su propio dise�o a trav�s de peque�os barriles montados en la mu�eca. Inicialmente buscando capitalizar sus nuevas habilidades, Parker se pone un disfraz y, como \"Spider-Man\", se convierte en una estrella de televisi�n novedosa. Sin embargo, \"ignora alegremente la posibilidad de detener a un ladr�n que huye, [y] su indiferencia ir�nicamente lo alcanza cuando el mismo delincuente m�s tarde roba y mata a su t�o Ben\". Spider-Man rastrea y domina al asesino y aprende, en la pen�ltima leyenda de la historia, \"con gran poder tambi�n debe haber una gran responsabilidad\""},
					{"Superman", "DC", "En Action Comics # 1 (1938), Superman nace en un mundo extra�o a una especie tecnol�gicamente avanzada que se parece a los humanos. Poco despu�s de nacer, su planeta se destruye en un cataclismo natural, pero el padre cient�fico de Superman previ� la calamidad y salva a su hijo beb� envi�ndolo a la Tierra en una peque�a nave espacial. Lamentablemente, la nave es demasiado peque�a para llevar a alguien m�s, por lo que los padres de Superman se quedan atr�s y mueren. Las primeras tiras de peri�dicos nombran el planeta \"Krypton\", el beb� \"Kal-L\" y sus padres biol�gicos \"Jor-L\" y \"Lora\";sus nombres fueron cambiados a \"Jor-el\" y \"Lara\" en una novela de 1942 de George Lowther.La nave aterriza en el campo estadounidense, donde los Kents, una pareja de agricultores, descubren al beb�. "}
					
				}
		);
				
	}
	
	@Test
	public void heroesapp() {
		double initial = countRegisters();
		driver.findElement(By.name("button")).click();
		driver.findElement(By.name("nombre")).click();
		driver.findElement(By.name("nombre")).sendKeys(name);
		WebElement dropdown = driver.findElement(By.name("casa"));
		dropdown.findElement(By.xpath("//option[. = '"+house+"']")).click();
		driver.findElement(By.name("bio")).click();
		driver.findElement(By.name("bio")).sendKeys(bio);
		driver.findElement(By.cssSelector(".btn-outline-primary")).click();
//		driver.findElement(By.name("button")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		double total = countRegisters();
		assertNotEquals(initial, total);
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
