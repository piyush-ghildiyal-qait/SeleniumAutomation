package tatoc;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BasicsUsingJsLocator {

	
	
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		String baseUrl = "http://10.0.1.86/tatoc/";
        driver.get(baseUrl);
        
        driver.manage().window().maximize();
        
        Thread.sleep(1000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("document.getElementsByTagName('a')[0].click();");
        
        
        Thread.sleep(1000);
        jse.executeScript("document.getElementsByClassName('greenbox')[0].click();");
        
       
//-------------------------------------- Frame Dungeon ---------------------        
        
driver.switchTo().frame("main");	        

        
String cl1 = (String) jse.executeScript("return document.getElementById('answer').getAttribute('class');");


driver.switchTo().frame(driver.findElement(By.id("child")));



String cl2 = (String) jse.executeScript("return document.getElementById('answer').getAttribute('class');");

driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));



while(!cl1.equals(cl2)) {

driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));

jse.executeScript("document.getElementsByTagName('a')[0].click();");


driver.switchTo().frame(driver.findElement(By.id("child")));
cl2 = (String) jse.executeScript("return document.getElementById('answer').getAttribute('class');");

Thread.sleep(1000);
}



driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));

jse.executeScript("document.getElementsByTagName('a')[1].click();");
        

//------------------------------------------ Drag Drop -----------------------


WebElement From=(WebElement) jse.executeScript("return document.getElementsByClassName('ui-draggable')[0];");

System.out.println(From);
//Element on which need to drop.


WebElement To=(WebElement) jse.executeScript("return document.getElementById('dropbox');");

System.out.println(To);
//Using Action class for drag and drop.		
Actions act=new Actions(driver);					

act.dragAndDrop(From, To).build().perform();	

Thread.sleep(1000);

jse.executeScript("document.getElementsByTagName('a')[0].click();");



//-------------------------   Pop Up windows ---------------------


String winHandleBefore = driver.getWindowHandle();
Thread.sleep(1000);
jse.executeScript("document.getElementsByTagName('a')[0].click();");

for(String winHandle : driver.getWindowHandles()){
driver.switchTo().window(winHandle);
}

Thread.sleep(2000);	     
jse.executeScript("document.getElementById('name').value ='Johnny Bravo';");
Thread.sleep(2000);
jse.executeScript("document.getElementById('submit').click();");

//Switch back to original browser (first window)
driver.switchTo().window(winHandleBefore);

jse.executeScript("document.getElementsByTagName('a')[1].click();");



//--------------------------------------  Cookie Handling ------------------------------

jse.executeScript("document.getElementsByTagName('a')[0].click();");



String token=(String) jse.executeScript("return document.getElementById('token').innerText;");
String[] tokenNo = token.split(":");


Cookie ck=new Cookie("Token",tokenNo[1].trim());

driver.manage().addCookie(ck);

Thread.sleep(1000);

jse.executeScript("document.getElementsByTagName('a')[1].click();");
     
        Thread.sleep(2000);
        driver.close();
	
	}
	
}
