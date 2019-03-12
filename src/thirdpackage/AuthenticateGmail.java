package thirdpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticateGmail {

	
	public void authenticateGmail(WebDriver driver) throws InterruptedException
	{
		MyLocators ml=new MyLocators();
		
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		 WebElement email_phone = driver.findElement(ml.enterEmailLocator);
		    email_phone.sendKeys("piyushghildiyal074@gmail.com");
		    driver.findElement(ml.clickOnEmailNextButtonLocator).click();
		  WebElement password = driver.findElement(ml.enterPasswordLocator);
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.elementToBeClickable(password));
		    
		    password.sendKeys("enter your password");      
	        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		    password.sendKeys(Keys.ENTER);
	
	}
	
	
	
	
}
