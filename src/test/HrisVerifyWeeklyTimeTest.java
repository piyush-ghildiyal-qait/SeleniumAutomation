package test;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HrisVerifyWeeklyTimeTest {

	@Test
	public void Test1() {

		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://hris.qainfotech.com/login.php";
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement email_phone = driver.findElement(By.xpath("//input[@id='txtUserName']"));
		email_phone.sendKeys("piyushghildiyal");
		driver.findElement(By.id("txtUserName")).click();
		WebElement password = driver.findElement(By.xpath("//input[@name='txtPassword']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(password));

		password.sendKeys("Enter Your Password Here");
	    
		driver.findElement(By.id("txtPassword")).click();
		password.submit();

		String totalTime = driver.findElement(By.xpath("//td[@id='tdId_47_']//span")).getText();

		totalTime = totalTime.substring(0, 5);
		String[] breaktotaltime = totalTime.split(":");

		int totalTimeHH = Integer.parseInt(breaktotaltime[0]);
		int totalTimeMM = Integer.parseInt(breaktotaltime[1]);

		String date25 = driver.findElement(By.xpath("(//div[@id='dv_2019-02-25']//span[@class='ng-binding'])[1]")).getText();

		date25 = date25.substring(0, 5);
		String[] breaktimedate25 = date25.split(":");
		int date25hh = Integer.parseInt(breaktimedate25[0]);
		int date25mm = Integer.parseInt(breaktimedate25[1]);

		String date26 = driver.findElement(By.xpath("(//div[@id='dv_2019-02-" + 24 + "']//span[@class='ng-binding'])[1]")).getText();
		date26 = date26.substring(0, 5);
		String[] breaktimedate26 = date26.split(":");
		int date26hh = Integer.parseInt(breaktimedate26[0]);
		int date26mm = Integer.parseInt(breaktimedate26[1]);

		String date27 = driver.findElement(By.xpath("(//div[@id='dv_2019-02-27']//span[@class='ng-binding'])[1]")).getText();
		date27 = date27.substring(0, 5);

		String[] breaktimedate27 = date27.split(":");
		int date27hh = Integer.parseInt(breaktimedate27[0]);
		int date27mm = Integer.parseInt(breaktimedate27[1]);

		String date28 = driver.findElement(By.xpath("(//div[@id='dv_2019-02-28']//span[@class='ng-binding'])[1]")).getText();
		date28 = date28.substring(0, 5);

		String[] breaktimedate28 = date28.split(":");
		int date28hh = Integer.parseInt(breaktimedate28[0]);
		int date28mm = Integer.parseInt(breaktimedate28[1]);

		String date1 = driver.findElement(By.xpath("(//div[@id='dv_2019-03-01']//span[@class='ng-binding'])[1]")).getText();

		date1 = date1.substring(0, 5);
		String[] breaktimedate1 = date1.split(":");

		int date1hh = Integer.parseInt(breaktimedate1[0]);
		int date1mm = Integer.parseInt(breaktimedate1[1]);

		int actualTime = date25hh * 60 + date25mm + date26hh * 60 + date26mm + date27hh * 60 + date27mm + date28hh * 60+ date28mm + date1hh * 60 + date1mm;
		int expectedTime = totalTimeHH * 60 + totalTimeMM;
		Assert.assertEquals(actualTime, expectedTime);

		// driver.close();

	}
}
