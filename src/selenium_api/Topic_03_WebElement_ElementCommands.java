package selenium_api;

import org.testng.annotations.AfterClass;
import java.util.List;
import java.util.*;
import java.util.Iterator;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.jetty.html.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Topic_03_WebElement_ElementCommands {
	// Khai bao 1 cai driver
	WebDriver driver;
	
	
	
	@BeforeClass
	public void beforeClass() {
//		//Firefox <=47 + selenium version 2.x.x
		driver = new FirefoxDriver();
	
		

		// wait cho page dc load thanh cong
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//open website
		driver.get("http://daominhdam.890m.com");


	}
	
	@Test 
	//kiem tra phan tu hien tren trang
	public void TC_01_CheckTitle() {
		WebElement email = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement Age = driver.findElement(By.xpath("//input[@id='under_18' and @type='radio']"));
		WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
		Assert.assertTrue(email.isDisplayed());
		Assert.assertTrue(Age.isDisplayed());
		Assert.assertTrue(Education.isDisplayed());

		
	}
	
	@Test 
	//kiem tra phan tu hien tren trang
	public void TC_02_CheckTitle() {
		WebElement email = driver.findElement(By.xpath("//input[@id='mail']"));
		WebElement Age = driver.findElement(By.xpath("//input[@id='under_18' and @type='radio']"));
		WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
		WebElement job = driver.findElement(By.xpath(".//select[@id='job1']"));
		WebElement interest = driver.findElement(By.xpath(".//input[@id='development']"));
		WebElement slider01 = driver.findElement(By.xpath("//input[@id='slider-1']"));
		WebElement btnEnabled = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		List<WebElement> allAtribute = new ArrayList<WebElement>();
		allAtribute.add(email);
		allAtribute.add(Age);
		allAtribute.add(Education);
		allAtribute.add(job);
		allAtribute.add(interest);
		allAtribute.add(slider01);
		allAtribute.add(btnEnabled);
		for(int i = 0 ; i < allAtribute.size() ; i++)
		{
			WebElement temp = allAtribute.get(i);
			Assert.assertTrue(temp.isEnabled());
			if (i == 7) {
				break;
			}
		}
		
	}
  

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}	
