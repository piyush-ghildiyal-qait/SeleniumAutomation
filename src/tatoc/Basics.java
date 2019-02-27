package tatoc;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basics {
	
		WebDriver driver;
		

	
     
	
	 public static void main(String[] args) throws InterruptedException {
	        // declaration and instantiation of objects/variables
	    	System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
			WebDriver driver = new ChromeDriver();
			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	    	
	        String baseUrl = "http://10.0.1.86/tatoc/";
	       
	        
	        // launch Fire fox and direct it to the Base URL
	        driver.get(baseUrl);
	        // get the actual value of the title
Thread.sleep(1000);
	        driver.manage().window().maximize();
	 
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
	      
	        Thread.sleep(1000);
	      

	        driver.findElement(By.xpath("//div[@class='greenbox']")).click();
	        
	        Thread.sleep(1000);
	        
	        driver.switchTo().frame("main");
	        
String color1= driver.findElement(By.xpath("//div[text()='Box 1']")).getCssValue("color");
System.out.println(color1);


driver.switchTo().frame("child");

String color2= driver.findElement(By.xpath("//div[text()='Box 2']")).getCssValue("color");
System.out.println(color2);
	    }
}

