package test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCasesOfBasicTatoc {

	
	
public String baseUrl = "http://10.0.1.86/tatoc/";
    
    public WebDriver driver ;
    
	
	@BeforeTest
    public void launchBrowser() {
        System.out.println("launching chrome browser"); 
        System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
		driver = new ChromeDriver();
        driver.get("http://10.0.1.86/tatoc/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void verifyWindowTitle() {
        String expectedTitle = "Welcome - T.A.T.O.C";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
   }
    @Test
    public void verifyHomepageTitle() {
    	String expectedTitle = "T.A.T.O.C";
    	String actualTitle = driver.findElement(By.xpath("//div[@class='title']")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void verifySubtextOfTitle() {
    	String expectedTitle = "Test Automation Training Obstacle Course";
    	String actualTitle = driver.findElement(By.xpath("//div[@class='subtext']")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
  
    @Test
    public void verifyHeading() {
    	String expectedTitle = "Test Automation Training Obstacle Course";
    	String actualTitle = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void verifyNumberOfLink() {
    	List<WebElement> links = driver.findElements(By.tagName("a"));
    int actualValue=links.size();
    int expectedValue=4;
    Assert.assertEquals(actualValue, expectedValue);
    }
    @Test
    public void verifyLinkBasic() {
    	
    	driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
    	String expectedTitle = "Grid Gate - Basic Course - T.A.T.O.C";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.navigate().back();
    }
    
    
    
@Test
public void verifyLinkAdvance() {
    	
    	driver.findElement(By.xpath("//a[text()='Advanced Course']")).click();
    	String expectedTitle = "Hover Menu - Advanced Course - T.A.T.O.C";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.navigate().back();
    }

@Test
public void verifyLinkEmail() {

	
	String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
	String expectedEmail1 = "<tap@qainfotech.net>";
    
	
	String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
	String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
    
	
	
    Assert.assertEquals(actualEmail1, expectedEmail1);
    
    Assert.assertEquals(actualEmail2, expectedEmail2);
}



    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
	
}
