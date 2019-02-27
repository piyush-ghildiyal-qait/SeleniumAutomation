package secondpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FindElementCommand1 {
public static void main(String[] args) throws InterruptedException {
// Create a new instance of the FireFox driver

	System.setProperty("webdriver.gecko.driver","/usr/local/share/gecko_driver/geckodriver");
	WebDriver driver = new FirefoxDriver();

// Launch the ToolsQA WebSite
driver.get("http://toolsqa.com/Automation-practice-form/");

Thread.sleep(1000);

// Type Name in the FirstName text box      
driver.findElement(By.name("firstname")).sendKeys("Lakshay"); 

Thread.sleep(1000);

//Type LastName in the LastName text box
driver.findElement(By.name("lastname")).sendKeys("Sharma");

// Click on the Submit button
driver.findElement(By.id("submit")).click();
}
}