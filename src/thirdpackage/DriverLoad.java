package thirdpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverLoad {

	
	WebDriver driver;
	
	public WebDriver setDriver(WebDriver driver) {
		System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
	     driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    String url = "https://gmail.com";
	    driver.get(url);
	    
		return driver;
	}
	
	
	
	
}
