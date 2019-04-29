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
public class TESTQA {
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
  public void TESTQA() {
    driver.get("http://bdb-qa-authenticator.s3-website-us-east-1.amazonaws.com/?site=10&product=3&uuid=e1ea6de9-d242-4d82-a396-0d58222ccf55&validateOfficeCode=null");
    driver.manage().window().setSize(new Dimension(872, 692));
    driver.findElement(By.id("identityNumber")).click();
    driver.findElement(By.id("identityNumber")).sendKeys("123456780");
    driver.findElement(By.cssSelector("button:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".bdb-button__btn-sunglow--normal")).click();
    driver.findElement(By.cssSelector(".content-safe-data__button--active")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".content-safe-data__button--active"));
      Action builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Action builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("first_name")).click();
    driver.findElement(By.id("first_name")).sendKeys("Test");
    driver.findElement(By.id("second_name")).click();
    driver.findElement(By.id("second_name")).click();
    {
      WebElement element = driver.findElement(By.id("second_name"));
      Actions builder = new Actions(driver);
      builder.doubleClick(element).perform();
    }
    driver.findElement(By.id("second_name")).sendKeys("desde selenium");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("last_name")).click();
    driver.findElement(By.id("last_name")).sendKeys("Selenium");
    driver.findElement(By.id("second_last_name")).click();
    driver.findElement(By.id("second_last_name")).sendKeys("test");
    driver.findElement(By.id("next")).click();
    {
      WebElement element = driver.findElement(By.id("next"));
      Action builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Action builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.id("born_city")).click();
    driver.findElement(By.id("born_city")).sendKeys("bogot");
    driver.findElement(By.cssSelector(".list-item__text:nth-child(1) > .list-item__text--normal")).click();
    driver.findElement(By.id("next")).click();
    driver.findElement(By.cssSelector(".list-radio-button__component:nth-child(3) .radio-button__subtitle--normal")).click();
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 7.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 7.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).click();
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).click();
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 80 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 80 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 80 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 800 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 800 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 800 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 80.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 80.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 80.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 800.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 800.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 800.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 8.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).click();
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 3 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 3 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 3 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 30 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 30 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 30 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 3.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 3.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 3.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 30.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 30.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 30.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 300.000 ");
    driver.findElement(By.cssSelector(".page-form-user-container-button label")).click();
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 700.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 700.000.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).click();
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 5 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 5 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 5 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 50 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 50 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 50 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 5.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 5.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 5.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 50.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 50.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 50.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(1) input")).sendKeys("$ 500.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).click();
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 20.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 20.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 20.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 2.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 2.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 2.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 200 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 20 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 20 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 20 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 2 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 2 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 2 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 0 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 1 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 1 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 1 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 10 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 10 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 10 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 1.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 1.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 1.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 10.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 10.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 10.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100.000 ");
    driver.findElement(By.cssSelector(".container:nth-child(2) input")).sendKeys("$ 100.000 ");
    driver.findElement(By.cssSelector(".page-form-user-container-button label")).click();
    driver.findElement(By.cssSelector(".button-bg:nth-child(1) > .button-bg__text > .button-bg__text--active")).click();
    driver.findElement(By.cssSelector(".button-bg:nth-child(1) > .button-bg__text > .button-bg__text--active")).click();
    driver.findElement(By.cssSelector(".container-button__btn:nth-child(2)")).click();
  }
}
