// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class Heroesapp {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new FirefoxDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void heroesapp() {
    driver.get("http://localhost:4200/heroes");
    driver.manage().window().setSize(new Dimension(872, 693));
    driver.findElement(By.name("button")).click();
    driver.findElement(By.name("nombre")).click();
    driver.findElement(By.name("nombre")).sendKeys("Spiderman");
    {
      WebElement element = driver.findElement(By.cssSelector("option:nth-child(1)"));
      Action builder = new Actions(driver);
      builder.moveToElement(element).clickAndHold().perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("option:nth-child(1)"));
      Action builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.cssSelector("option:nth-child(1)"));
      Action builder = new Actions(driver);
      builder.moveToElement(element).release().perform();
    }
    {
      WebElement dropdown = driver.findElement(By.name("casa"));
      dropdown.findElement(By.xpath("//option[. = 'Marvel']")).click();
    }
    driver.findElement(By.name("bio")).click();
    driver.findElement(By.name("bio")).sendKeys("Spider-Man (llamado Hombre Araña en muchas de las traducciones al español) es un superhéroe ficticio creado por los escritores y editores Stan Lee y Steve Ditko. Apareció por primera vez en el cómic de antología Amazing Fantasy # 15 (agosto de 1962) en la Edad de Plata de los cómics.");
    driver.findElement(By.cssSelector(".btn-outline-primary")).click();
    driver.findElement(By.name("button")).click();
  }
}