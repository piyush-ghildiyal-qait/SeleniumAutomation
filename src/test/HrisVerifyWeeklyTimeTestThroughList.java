package test;

import java.util.ArrayList;
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

public class HrisVerifyWeeklyTimeTestThroughList {

	@Test
	public void TestList() {

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

	    password.sendKeys("Piyushghildiyal@123");
		
		driver.findElement(By.id("txtPassword")).click();
		password.submit();

		String totalTime = driver.findElement(By.xpath("//td[@id='tdId_47_']//span")).getText();
		totalTime = totalTime.substring(0, 5);
		

		String[] breaktotaltime = totalTime.split(":");

		
		int totalTimeHH = Integer.parseInt(breaktotaltime[0]);
		
		int totalTimeMM = Integer.parseInt(breaktotaltime[1]);

		driver.findElement(By.xpath("(//div[@id='dv_2019-02-25']//span[@class='ng-binding'])[1]")).getText();

		ArrayList<String> list = new ArrayList<String>();

		for (int i = 25; i <= 28; i++) {
			list.add(driver.findElement(By.xpath("(//div[@id='dv_2019-02-" + i + "']//span[@class='ng-binding'])[1]")).getText());
		}

		ArrayList<Integer> hh = new ArrayList<Integer>();
		ArrayList<Integer> mm = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			list.set(i, list.get(i).substring(0, 5));
			hh.add(Integer.parseInt(list.get(i).substring(0, 2)));
			mm.add(Integer.parseInt(list.get(i).substring(3, 5)));
		}

		String date1 = driver.findElement(By.xpath("(//div[@id='dv_2019-03-01']//span[@class='ng-binding'])[1]")).getText();
		date1 = date1.substring(0, 5);
		String[] breaktimedate1 = date1.split(":");

		int date1hh = Integer.parseInt(breaktimedate1[0]);
		hh.add(date1hh);
		int date1mm = Integer.parseInt(breaktimedate1[1]);
		mm.add(date1mm);

		int totalHours = 0, totalMinutes = 0;

		for (int i = 0; i < hh.size(); i++) {
			totalHours = totalHours + hh.get(i);
			totalMinutes = totalMinutes + mm.get(i);
		}

		int actualTime = totalHours * 60 + totalMinutes;
		int expectedTime = totalTimeHH * 60 + totalTimeMM;
		Assert.assertEquals(actualTime, expectedTime);
        driver.close();
	}

}
