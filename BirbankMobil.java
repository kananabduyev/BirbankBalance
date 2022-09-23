import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class BirbankMobilTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void birbank() {
    driver.get("https://birbank.az/");
    driver.manage().window().setSize(new Dimension(1366, 728));
    {
      WebElement element = driver.findElement(By.linkText("Ödənişlər"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    driver.findElement(By.linkText("Ödənişlər")).click();
    driver.findElement(By.linkText("Mobil")).click();
    driver.findElement(By.linkText("Bakcell")).click();
    driver.findElement(By.name("PHONE")).click();
    driver.findElement(By.name("PHONE")).sendKeys("553923353");
    driver.switchTo().frame(0);
    driver.findElement(By.cssSelector(".recaptcha-checkbox-border")).click();
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector(".color-danger")).click();
    {
      WebElement element = driver.findElement(By.cssSelector(".color-danger"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
    driver.findElement(By.name("value")).click();
    driver.findElement(By.name("value")).sendKeys("1");
    driver.findElement(By.name("number")).click();
    driver.findElement(By.name("number")).sendKeys("1111111111111111");
    driver.findElement(By.name("expiration")).sendKeys("11/22");
    driver.findElement(By.name("cvc")).sendKeys("111");
    driver.findElement(By.cssSelector(".color-danger")).click();
    driver.close();
  }
}
