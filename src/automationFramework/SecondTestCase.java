package automationFramework;


import org.openqa.selenium.By; 

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement; 
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondTestCase {

    public static void main(String[] args) throws InterruptedException {

    	System.setProperty("webdriver.gecko.driver","/usr/local/share/gecko_driver/geckodriver");
		WebDriver driver = new FirefoxDriver();
   
         driver.get("http://www.google.com"); 
         WebElement element = driver.findElement(By.name("q"));
         element.sendKeys("Cheese!");
         Thread.sleep(5000);
         element.submit();
Thread.sleep(5000);
         driver.close();
    }



}