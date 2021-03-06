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
public class Test1 {
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
  public void test1() {
    driver.get("https://www.booking.com/index.es.html?label=gen173nr-1DCAEoggI46AdIM1gEaDKIAQGYAQq4ARfIAQ_YAQPoAQGIAgGoAgO4AuSameYFwAIB;sid=11714a9d9ffdb27faaa9608b29d6372e;keep_landing=1&sb_price_type=total&");
    driver.manage().window().setSize(new Dimension(1198, 718));
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.id("ss")).click();
    driver.findElement(By.id("ss")).sendKeys("santa marta");
    driver.findElement(By.cssSelector(".sb-autocomplete__item-with_photo:nth-child(1) > span")).click();
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".xp__input-group:nth-child(2) .sb-date-field__icon")).click();
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".bui-calendar__wrapper:nth-child(1) .bui-calendar__row:nth-child(6) > .bui-calendar__date:nth-child(2)")).click();
    driver.findElement(By.cssSelector(".bui-calendar__wrapper:nth-child(2) .bui-calendar__row:nth-child(2) > .bui-calendar__date:nth-child(4)")).click();
    driver.findElement(By.cssSelector(".sb-searchbox__button")).click();
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.id("ss")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".sb-searchbox__button > span:nth-child(1)"));
      Action builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Action builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
}
