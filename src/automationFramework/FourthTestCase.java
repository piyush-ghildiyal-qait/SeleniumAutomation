package automationFramework;






import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourthTestCase {
	
	

	  public static void main(String[] args) throws InterruptedException {

		  System.setProperty("webdriver.chrome.driver","/usr/local/share/chromedriver/chromedriver");
			WebDriver driver = new ChromeDriver();  
		    driver.manage().window().maximize();
		    String url = "https://gmail.com";
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		    WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		    email_phone.sendKeys("piyushghildiyal074@gmail.com");
		    driver.findElement(By.id("identifierNext")).click();
		    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.elementToBeClickable(password));
		    System.out.println("\ntest  password");
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		   
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    password.sendKeys("enter your password here");      
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		    password.sendKeys(Keys.ENTER);
	
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    driver.findElement(By.xpath("//div[@id=':jb']/div[@class='z0']/div")).click(); // Compose
	//	    selenium.type("//div[@class='wO nr l1']//textarea[@name='to']",       "vikramn@gmail.com"); // For To 

	//	    selenium.type("//div[@class='aoD az6']//input[@name='subjectbox']", "Wanted to SAY HI"); // For Subject
	//	    selenium.type("//div[@class='Ar Au']/div[@class='Am Al editable LW-avf']", "Hi Vikram");// For Message body
	//	    selenium.click("//div[@class='J-J5-Ji']/div[@class='T-I J-J5-Ji aoO T-I-atl L3']"); //send


}
}

