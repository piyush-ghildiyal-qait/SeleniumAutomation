package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import java.util.List;
import java.util.ArrayList;
public class SixthTestCase {
    WebDriver driver;
    String driverpath="/usr/local/share/gecko_driver/geckodriver";

	
    @BeforeTest 
    public void setup() {
        System.setProperty("webdriver.gecko.driver",driverpath);
        driver=new FirefoxDriver();
        driver.get("https://www.google.com");
    }
    @Test(dataProvider="SearchProvider")
    public void testSearch(String searchkey) {
        WebElement inputquery = driver.findElement(By.name("q"));
        inputquery.click();
        inputquery.sendKeys(searchkey);
        inputquery.sendKeys(Keys.ENTER);
        List<WebElement> linklist = new ArrayList<WebElement>();
        linklist=driver.findElements(By.cssSelector("cite.iUh30"));
        System.out.println(linklist.get(0).getText());
        Assert.assertEquals(linklist.get(0).getText(),"https://qainfotech.com/");
        driver.close();
    }
    @DataProvider(name="SearchProvider")
    public Object[][] getDataFromDataprovider(){
    return new Object[][] 
    	{
            { "QAinfotech" }
        };
    }
}
