package testngparametersanddataprovider;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestngParameters {

	private static WebDriver driver;
	
	@Test
	@Parameters({"Username","Password"})
	public void Test(String Username,String Password) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		 String url = "https://gmail.com";
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		    WebElement email_phone = driver.findElement(By.xpath("//input[@id='identifierId']"));
		    email_phone.sendKeys(Username);
		    driver.findElement(By.id("identifierNext")).click();
		    WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		    WebDriverWait wait = new WebDriverWait(driver, 20);
		    wait.until(ExpectedConditions.elementToBeClickable(password));
		    System.out.println("\ntest  password");
		
		    password.sendKeys(Password);      
		    
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		    password.sendKeys(Keys.ENTER);
	
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    Thread.sleep(5000);
		    
		    
		    driver.quit();
	}
	
}
