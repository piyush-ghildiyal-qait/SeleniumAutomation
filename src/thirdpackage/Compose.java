package thirdpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Compose {

	
	public void composeMessage(WebDriver driver) throws InterruptedException {
		
		
		MyLocators ml=new MyLocators();
		
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    Thread.sleep(5000);
	
	    driver.findElement(ml.clickOnComposeButtonLocator).click();
	
//	driver.findElement(By.xpath("//textarea[@id=':q0']")).sendKeys("mohdkamran@qainfotech.com");
	    
 driver.findElement(ml.enterReceipentEmailLocator).sendKeys("coolpiyushghildiyal@gmail.com");
	driver.findElement(ml.enterSubjectInSubjectBoxLocator).sendKeys("Auto Generated Mail");
	
	
	Thread.sleep(5000);
	WebElement message=driver.findElement(ml.enterMessageInMessageBox);
	message.click();
	message.sendKeys("Hi Kamran \nThis is an Auto Generated Mail.\n\nThanks and Regards\nPiyush Ghildiyal\nSoftware Engineer Support\nQA Infotech");		
	
	
	driver.findElement(ml.enterSendMessageButtonLocator).click();
	
	driver.findElement(ml.clickOnExpandButtonLocator).click();
	driver.findElement(ml.clickOnSignOutButton).click();
	 Thread.sleep(2000);
	
	
	}
	
	
	
}
