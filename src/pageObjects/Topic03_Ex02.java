package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Topic03_Ex02 {
	private static WebElement element = null;
	 
	public static WebElement emailInput (WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='mail']"));
		return element;
	}
	public static WebElement AgeRadio (WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@id='under_18' and @type='radio']"));
		return element;
	}
}

