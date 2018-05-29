package selenium_api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import pageObjects.Topic04_form_demo;

public class Topic_04_TEXTBOX {
	// Khai bao 1 cai driver
	private static WebDriver driver = null;
	String username, pass, name, dob, address, city, state, pin, mobi, email, password, customerID, newAddress,newCity;
	
	
	@BeforeClass
	public void beforeClass() {
//		//Firefox <=47 + selenium version 2.x.x
		driver = new FirefoxDriver();
		
		
		// wait cho page dc load thanh cong
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
		//Maximize browser
		driver.manage().window().maximize();
		
		//open website
		driver.get("http://daominhdam.890m.com/");
		
	}

	
	@Test 
	public void TC_01_Handle_Dropdown_list() {
		Topic04_form_demo jobRole = new Topic04_form_demo(driver);
		//Kiem tra thuoc tinh job role 01 co multiple ko ?
		Assert.assertFalse(jobRole.jobRole01(driver).isMultiple());
		Select autoVal = jobRole.jobRole01(driver);
		
		//Chọn giá trị Automation Tester trong dropdown bằng phương thức selectVisible
		//Kiểm tra giá trị đã được chọn thành công
		jobRole.selectByVisibleText(autoVal);
		String actual_result = autoVal.getFirstSelectedOption().getText();
		Assert.assertEquals(actual_result,"Automation Tester");
		
		//Chọn giá trị Mobile Tester trong dropdown bằng phương thức selectIndex
		//Kiểm tra giá trị đã được chọn thành công
		jobRole.selectByIndex(autoVal);
		actual_result = autoVal.getFirstSelectedOption().getText();
		Assert.assertEquals(actual_result,"Mobile Tester");
		
		// Chọn giá trị Manual Tester trong dropdown bằng phương thức selectValue
		// Kiểm tra giá trị đã được chọn thành công
		jobRole.selectByValue(autoVal);
		actual_result = autoVal.getFirstSelectedOption().getText();
		Assert.assertEquals(actual_result,"Manual Tester");
		Assert.assertEquals(jobRole.jobRole01(driver).getOptions().size(), 5);
	}
	
	
	
  

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
}	
