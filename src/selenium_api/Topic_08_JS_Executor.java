package selenium_api;
import org.openqa.selenium.Alert;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import utility_function.Js_function;

public class Topic_08_JS_Executor {
  WebDriver driver;
  @BeforeClass
  public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();

  }
  
  @Test (enabled = false)
  public void TC_00() {
	  
  }
  
  @Test 
  public void TC_01() {
	  
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
