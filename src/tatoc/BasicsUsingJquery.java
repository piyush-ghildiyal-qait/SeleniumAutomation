package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicsUsingJquery {

	
	public static void main(String[] args) throws InterruptedException {

		

		System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://10.0.1.86/tatoc/";
        driver.get(baseUrl);
        
        driver.manage().window().maximize();
        
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("$('a:first').get(0).click();");
        
        Thread.sleep(1000);
        jse.executeScript("$('.greenbox').get(0).click();");
        
       
        
//-------------------------------------- Frame Dungeon ---------------------        
              
      driver.switchTo().frame("main");	        

              
      String cl1 = (String) jse.executeScript("return $('#answer').attr('class');");

      driver.switchTo().frame(driver.findElement(By.id("child")));



      String cl2 = (String) jse.executeScript("return $('#answer').attr('class');");

      driver.switchTo().defaultContent();
      driver.switchTo().frame(driver.findElement(By.id("main")));



      while(!cl1.equals(cl2)) {

      driver.switchTo().defaultContent();
      driver.switchTo().frame(driver.findElement(By.id("main")));

      jse.executeScript("$('a:first').click();");


      driver.switchTo().frame(driver.findElement(By.id("child")));
      cl2 = (String) jse.executeScript("return $('#answer').attr('class');");

      Thread.sleep(1000);
      }



      driver.switchTo().defaultContent();
      driver.switchTo().frame(driver.findElement(By.id("main")));

      jse.executeScript("$('a').get(1).click();");
      
      

//------------------------------------------ Drag Drop -----------------------


    WebElement From=(WebElement) jse.executeScript("return $('#dragbox').get(0);");

    //Element on which need to drop.


    WebElement To=(WebElement) jse.executeScript("return $('#dropbox').get(0);");

   
    //Using Action class for drag and drop.		
    Actions act=new Actions(driver);					

    act.dragAndDrop(From, To).build().perform();	

    Thread.sleep(1000);

    jse.executeScript("$('a').get(0).click();");


  //-------------------------   Pop Up windows ---------------------


  String winHandleBefore = driver.getWindowHandle();
  Thread.sleep(1000);
  jse.executeScript("$('a').get(0).click();");

  for(String winHandle : driver.getWindowHandles()){
  driver.switchTo().window(winHandle);
  }

  Thread.sleep(2000);	     
  jse.executeScript("$('#name').attr('value','Piyush Ghildiyal')");
  Thread.sleep(2000);
  jse.executeScript("$('#submit').click();");

  //Switch back to original browser (first window)
  driver.switchTo().window(winHandleBefore);

  jse.executeScript("$('a').get(1).click();");

//--------------------------------------  Cookie Handling ------------------------------

jse.executeScript("$('a').get(0).click();");



String token=(String) jse.executeScript("return $('#token').get(0).innerText");
String[] tokenNo = token.split(":");


Cookie ck=new Cookie("Token",tokenNo[1].trim());

driver.manage().addCookie(ck);

Thread.sleep(1000);

jse.executeScript("$('a').get(1).click();");
     
        Thread.sleep(2000);
        driver.close();

  
      
      
      
 
	}

}
