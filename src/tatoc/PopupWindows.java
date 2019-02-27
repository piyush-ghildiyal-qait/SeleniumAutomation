package tatoc;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupWindows {
	
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

	        
	        
	        
	        
	        
	        /*
	        
	        
	    
	        String winHandleBefore = driver.getWindowHandle();
Thread.sleep(2000);
	     // Perform the click operation that opens new window
	        driver.findElement(By.xpath("//a[@onclick='launchwindow();']")).click();
	        
	     // Switch to new window opened
	     for(String winHandle : driver.getWindowHandles()){
	         driver.switchTo().window(winHandle);
	     }

	     // Perform the actions on new window
	     Thread.sleep(4000);	     
	        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("piyush ghildiyal");
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//input[@id='submit']")).click();   
	     // Close the new window, if that window no more required
	    
	    //    driver.close();
	     // Switch back to original browser (first window)
		    driver.switchTo().window(winHandleBefore);
		         
	     driver.findElement(By.xpath("//a[text()='Proceed']")).click();
	     
	   
	//    second task totac 
	     
	     driver.findElement(By.xpath("//a[text()='Generate Token']")).click();
	   
	     
	     String token=driver.findElement(By.xpath("//span[@id='token']")).getText();
	     
        String[] tokenNo = token.split(":");
	       
       System.out.println(tokenNo[1].trim());
       
        Cookie ck=new Cookie("cuk",tokenNo[1].trim());
        
driver.manage().addCookie(ck);

        
        */
        
	    }
}
