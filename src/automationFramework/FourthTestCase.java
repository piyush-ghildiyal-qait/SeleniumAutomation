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

			System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
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
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		   
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    password.sendKeys("enter your password");      
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS); 
		    password.sendKeys(Keys.ENTER);
	
		    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		    Thread.sleep(5000);
		
		    driver.findElement(By.xpath("//div[@gh='cm']")).click();
		
	//	driver.findElement(By.xpath("//textarea[@id=':q0']")).sendKeys("mohdkamran@qainfotech.com");
		    
        driver.findElement(By.xpath("//textarea[@id=':q0']")).sendKeys("coolpiyushghildiyal@gmail.com");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Auto Generated Mail");
		
		
		Thread.sleep(5000);
		WebElement message=driver.findElement(By.xpath("//div[@id=':qn']"));
		message.click();
		message.sendKeys("Hi Kamran \nThis is an Auto Generated Mail.\n\nThanks and Regards\nPiyush Ghildiyal\nSoftware Engineer Support\nQA Infotech");		
		
		
		driver.findElement(By.xpath("//div[@id=':p8']")).click();
		
		driver.findElement(By.xpath("//span[@class='gb_ya gbii']")).click();
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
		 Thread.sleep(2000);
		
		
		driver.close();


}
}

