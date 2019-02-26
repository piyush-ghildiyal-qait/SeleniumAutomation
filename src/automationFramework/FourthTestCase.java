
package automationFramework;






import java.util.concurrent.TimeUnit;
 

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FourthTestCase {
	
	

	  public static void main(String[] args) throws InterruptedException {

		  System.setProperty("webdriver.gecko.driver","/usr/local/share/gecko_driver/geckodriver");
			WebDriver driver = new FirefoxDriver();  
		    driver.manage().window().maximize();
		    String url = "https://accounts.google.com/signin";
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		    WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		    email_phone.sendKeys("enter your email");
		    driver.findElement(By.id("identifierNext")).click();
		    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.elementToBeClickable(password));
		    System.out.println("\ntest  password");
		    password.sendKeys(" enter your password ");                     
		    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		    password.sendKeys(Keys.ENTER);

		    driver.findElement(By.className("WaidBe")).click();
		    System.out.println("Mail page opened");
		    Thread.sleep(3000);
		    driver.findElement(By.className("z0")).click();
		    driver.findElement(By.className("vO")).sendKeys("piyushghildiyal074@gmail.com");
		    driver.findElement(By.className("aoT")).sendKeys("Test email from selenium");
		    driver.findElement(By.className("Am")).sendKeys("Hi");
		    driver.findElement(By.className("aoO")).click();

}
}

