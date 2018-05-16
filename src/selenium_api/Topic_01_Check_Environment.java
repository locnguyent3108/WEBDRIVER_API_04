package selenium_api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Topic_01_Check_Environment {
	// Khai bao 1 cai driver
	WebDriver driver;
	
	
	
	@BeforeClass
	public void beforeClass() {
//		//Firefox <=47 + selenium version 2.x.x
//		driver = new FirefoxDriver();
		
		//Chrome
		System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		//IE
//		System.setProperty("webdriver.IE.driver", ".\\driver\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
		
		// wait cho page dc load thanh cong
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//open website
		driver.get("http://live.guru99.com");
		
				

		
		

	}
	
	@Test
	public void TC_01_CheckTitle() {
		String homePageTitle = driver.getTitle();
		Assert.assertEquals("Home page", homePageTitle);
	}
	@Test
	public void TC_02_CheckURL() {
		String homePageURL = driver.getCurrentUrl();
		Assert.assertEquals("http://live.guru99.com/", homePageURL);
	}
  

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}	
