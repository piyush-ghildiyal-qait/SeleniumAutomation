package tatoc;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicsUsingXpathlocator {
	
		WebDriver driver;
		

	
     
	
	 public static void main(String[] args) throws InterruptedException {
	        // declaration and instantiation of objects/variables
	    	System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
			WebDriver driver = new ChromeDriver();
			//comment the above 2 lines and uncomment below 2 lines to use Chrome
			//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
			//WebDriver driver = new ChromeDriver();
	    	
	        String baseUrl = "http://10.0.1.86/tatoc/";
	        driver.get(baseUrl);
	        // get the actual value of the title
            Thread.sleep(1000);
	        driver.manage().window().maximize();
	 
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
	      
	        Thread.sleep(1000);
	      

	        driver.findElement(By.xpath("//div[@class='greenbox']")).click();
	        
	        Thread.sleep(1000);
	        
// ------------------------------------------  Frame ---------------------------------
	        
	        
	        driver.switchTo().frame("main");	        

	        
String cl1 = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");

driver.switchTo().frame(driver.findElement(By.id("child")));

String cl2= driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");

driver.switchTo().defaultContent();

driver.switchTo().frame(driver.findElement(By.id("main")));



while(!cl1.equals(cl2)) {
//	System.out.println("col1="+cl1);
//	System.out.println("col2="+cl2);
//	System.out.println("boolean="+cl1.equals(cl2));
	
	driver.switchTo().defaultContent();
	driver.switchTo().frame(driver.findElement(By.id("main")));

	driver.findElement(By.xpath("//a[text()='Repaint Box 2']")).click();
	
	
	driver.switchTo().frame(driver.findElement(By.id("child")));
	cl2= driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");

	Thread.sleep(1000);
}

driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));

driver.findElement(By.xpath("//a[text()='Proceed']")).click();

//------------------------------------------ Drag Drop -----------------------


WebElement From=driver.findElement(By.xpath("//div[text()='DRAG ME']"));	

//Element on which need to drop.		
WebElement To=driver.findElement(By.xpath("//div[text()='DROPBOX']"));					
		
//Using Action class for drag and drop.		
Actions act=new Actions(driver);




//Dragged and dropped.		
act.dragAndDrop(From, To).build().perform();	

Thread.sleep(1000);
driver.findElement(By.xpath("//a[text()='Proceed']")).click();

// -------------------------   Pop Up windows ---------------------


String winHandleBefore = driver.getWindowHandle();
Thread.sleep(1000);
// Perform the click operation that opens new window
driver.findElement(By.xpath("//a[@onclick='launchwindow();']")).click();

// Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
 driver.switchTo().window(winHandle);
}

// Perform the actions on new window
Thread.sleep(2000);	     
driver.findElement(By.xpath("//input[@id='name']")).sendKeys("piyush ghildiyal");
Thread.sleep(2000);
driver.findElement(By.xpath("//input[@id='submit']")).click();   
// Close the new window, if that window no more required

//    driver.close();
// Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);
     
driver.findElement(By.xpath("//a[text()='Proceed']")).click();


//--------------------------------------  Cookie Handling ---------------------------

driver.findElement(By.xpath("//a[text()='Generate Token']")).click();


String token=driver.findElement(By.xpath("//span[@id='token']")).getText();

String[] tokenNo = token.split(":");

//System.out.println(tokenNo[1].trim());

Cookie ck=new Cookie("Token",tokenNo[1].trim());

driver.manage().addCookie(ck);

Thread.sleep(1000);
driver.findElement(By.xpath("//a[text()='Proceed']")).click();

Thread.sleep(1000);

driver.close();



	    }
}

