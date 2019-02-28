package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicsUsingCssSelector {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://10.0.1.86/tatoc/";
        driver.get(baseUrl);
        
        driver.manage().window().maximize();
        
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".page a[href='/tatoc/basic']")).click();
	
        
        driver.findElement(By.cssSelector(".greenbox[onclick='passthru();']")).click();
        
        Thread.sleep(1000);
        
        
// ------------------------------------------  Green Grid ---------------------------------
        
        
driver.switchTo().frame("main");	        

        
String cl1 = driver.findElement(By.cssSelector("center>#answer")).getAttribute("class");
driver.switchTo().frame(driver.findElement(By.id("child")));

String cl2= driver.findElement(By.cssSelector("body>div[id='answer']")).getAttribute("class");

driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));



while(!cl1.equals(cl2)) {
//System.out.println("col1="+cl1);
//System.out.println("col2="+cl2);
//System.out.println("boolean="+cl1.equals(cl2));

driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));

driver.findElement(By.cssSelector("a[onclick='reloadChildFrame();']")).click();


driver.switchTo().frame(driver.findElement(By.id("child")));
cl2= driver.findElement(By.cssSelector(("body>div[id='answer']"))).getAttribute("class");

Thread.sleep(1000);
}



driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));

driver.findElement(By.cssSelector("a[onclick='gonext();']")).click();
        
        

//------------------------------------------ Drag Drop -----------------------


WebElement From=driver.findElement(By.cssSelector(".ui-draggable"));	

//Element on which need to drop.		
WebElement To=driver.findElement(By.cssSelector("div #dropbox"));					
		
//Using Action class for drag and drop.		
Actions act=new Actions(driver);					

//Dragged and dropped.		
act.dragAndDrop(From, To).build().perform();	

Thread.sleep(1000);
driver.findElement(By.cssSelector("a[onclick='gonext();']")).click();
        
        
//-------------------------------------- Pop Up Windows        
       

//-------------------------   Pop Up windows ---------------------


String winHandleBefore = driver.getWindowHandle();
Thread.sleep(1000);
//Perform the click operation that opens new window
driver.findElement(By.cssSelector("a[onclick='launchwindow();']")).click();

//Switch to new window opened
for(String winHandle : driver.getWindowHandles()){
driver.switchTo().window(winHandle);
}

//Perform the actions on new window
Thread.sleep(2000);	     
driver.findElement(By.cssSelector("#name")).sendKeys("piyush ghildiyal");
Thread.sleep(2000);
driver.findElement(By.cssSelector("#submit")).click();   
//Close the new window, if that window no more required

// driver.close();
//Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);
  
driver.findElement(By.cssSelector("a[onclick='gonext();']")).click();

        

//--------------------------------------  Cookie Handling ------------------------------

driver.findElement(By.cssSelector("a[onclick='generateToken();']")).click();


String token=driver.findElement(By.cssSelector("span[id='token']")).getText();

String[] tokenNo = token.split(":");

//System.out.println(tokenNo[1].trim());

Cookie ck=new Cookie("Token",tokenNo[1].trim());

driver.manage().addCookie(ck);

Thread.sleep(1000);
driver.findElement(By.cssSelector("a[onclick='gonext();']")).click();

Thread.sleep(1000);

driver.close();


  
        
        
        
        
        
        
        
        
        
        
        
        
	}
	
	
}
