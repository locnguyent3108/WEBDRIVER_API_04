package selenium_api;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class Topic_02_XpathCss {
	// Khai bao 1 cai driver
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Firefox <=47 + selenium version 2.x.x
		driver = new FirefoxDriver();
		driver = new FirefoxDriver();

		// Chrome
		// System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
		// driver = new ChromeDriver();

		// IE
		// System.setProperty("webdriver.IE.driver", ".\\driver\\IEDriverServer.exe");
		// driver = new InternetExplorerDriver();

		// wait cho page dc load thanh cong
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);

		// Maximize browser
		driver.manage().window().maximize();

		// Open website
		driver.get("http://live.guru9s.com");
	}
	public enum ErrorMessage {
		ErrorMsg("This is a required field.","Please enter a valid email address. For example johndoe@domain.com.","Please enter 6 or more characters without leading or trailing spaces.");
		private String Invalid_Email;
		private String Blank_field;
		private String Invalid_Pwd;

		private ErrorMessage(String Blank_field, String Invalid_Email, String Invalid_Pwd) {
		        this.Blank_field = Blank_field;
		        this.Invalid_Email = Invalid_Email;
		        this.Invalid_Pwd = Invalid_Pwd;
		}
		 
		 //getter & setter
		public String getBlank_field() {
	        return Blank_field;
	    }
	 
	    public void setBlank_field(String Blank_field) {
	        this.Blank_field = Blank_field;
	    }
	 
	    public String getInvalid_Email() {
	        return Invalid_Email;
	    }
	 
	    public void setInvalid_Email(String Invalid_Email) {
	        this.Invalid_Email = Invalid_Email;
	    }
	 
	    public String getInvalid_Pwd() {
	        return Invalid_Pwd;
	    }
	 
	    public void setInvalid_Pwd(String Invalid_Pwd) {
	        this.Invalid_Pwd = Invalid_Pwd;
	    }

	}
	
	
	@Test 
	public void TC_02_Login_Empty() {
		// get first children
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String linkAccount = "//a[contains(@class,'skip-account')]";
		String menuMyAccount = ".//*[@id='header-account']/div/ul/li[1]";
		driver.findElement(By.xpath(linkAccount)).click();
		driver.findElement(By.xpath(menuMyAccount)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		String emailError = "//input[@id='email']/following-sibling::div[@class='validation-advice']";
		String emailErrorText = driver.findElement(By.xpath(emailError)).getText();
		String pswError = "//input[@id='pass']/following-sibling::div[@class='validation-advice']";
		String pswErrorText = driver.findElement(By.xpath(pswError)).getText();
		Assert.assertEquals(emailErrorText, ErrorMessage.ErrorMsg.getBlank_field());
		Assert.assertEquals(pswErrorText, ErrorMessage.ErrorMsg.getBlank_field());
		driver.quit();
	}
	
	@Test
	public void TC_03_Invalid_Email(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		String linkAccount = "//a[contains(@class,'skip-account')]";
		String menuMyAccount = ".//*[@id='header-account']/div/ul/li[1]";
		driver.findElement(By.xpath(linkAccount)).click();
		driver.findElement(By.xpath(menuMyAccount)).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("23434234@12312.123123");
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		String emailError = driver.findElement(By.xpath("//input[@id='email']/following-sibling::div[@class='validation-advice']")).getText();
		Assert.assertEquals(emailError, ErrorMessage.ErrorMsg.getInvalid_Email());
	}
	
	@Test
	public void TC_04_Invalid_Password(){
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123");
		driver.findElement(By.xpath(".//*[@id='send2']")).click();
		String emailError = driver.findElement(By.xpath("//input[@id='pass']/following-sibling::div[@class='validation-advice']")).getText();
		Assert.assertEquals(emailError, ErrorMessage.ErrorMsg.getInvalid_Pwd());
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
