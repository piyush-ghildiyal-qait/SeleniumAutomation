package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FifthTestCase {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver","/usr/local/share/gecko_driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		String url = "https://hris.qainfotech.com/login.php";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		WebElement email_phone = driver.findElement(By.xpath("//input[@id='txtUserName']"));
		email_phone.sendKeys("enter your username");
		driver.findElement(By.id("txtUserName")).click();
		WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys("Enter your password here");
		driver.findElement(By.id("txtPassword")).click();
		password.submit();
		
	}
}
