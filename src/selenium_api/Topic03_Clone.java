package selenium_api;

import org.testng.annotations.Test;
import pageObjects.Topic03_Ex02;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

public class Topic03_Clone {
	private static WebElement element = null;
	WebDriver driver;
  
  
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
	  driver.get("http://daominhdam.890m.com");
  }
  @Test
  public void f() {
	   IsElementEnabled(Topic03_Ex02.AgeRadio(driver));
	  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  public boolean IsElementEnabled (WebElement myElement){
	 if(myElement.isEnabled()) {
		 System.out.print("here is something special ");
		 return true;
	 }else {
		 System.out.println("there is nothing happen");
		 return false;
	 }
	  
  }

}
