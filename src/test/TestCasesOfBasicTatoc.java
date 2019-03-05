package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCasesOfBasicTatoc {

	public String baseUrl = "http://10.0.1.86/tatoc/";

	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void page1VerifyWindowTitle() {
		String expectedTitle = "Welcome - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void page1VerifyHomepageTitle() {
		String expectedTitle = "T.A.T.O.C";
		String actualTitle = driver.findElement(By.xpath("//div[@class='title']")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void page1VerifySubtextOfTitle() {
		String expectedTitle = "Test Automation Training Obstacle Course";
		String actualTitle = driver.findElement(By.xpath("//div[@class='subtext']")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void page1VerifyHeading() {
		String expectedTitle = "Test Automation Training Obstacle Course";
		String actualTitle = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test
	public void page1VerifyNumberOfLink() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int actualValue = links.size();
		int expectedValue = 4;
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test
	public void page1VerifyLinkBasic() {

		driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
		String expectedTitle = "Grid Gate - Basic Course - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
	}

	@Test
	public void page1VerifyLinkAdvance() {

		driver.findElement(By.xpath("//a[text()='Advanced Course']")).click();
		String expectedTitle = "Hover Menu - Advanced Course - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
	}

	@Test
	public void page1VerifyLinkEmail() {

		String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
		String expectedEmail1 = "<tap@qainfotech.net>";

		String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
		String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
		Assert.assertEquals(actualEmail1, expectedEmail1);
		Assert.assertEquals(actualEmail2, expectedEmail2);
	}

//----------------------------------- Grid Gate ------------------------------------------------------------

	@Test(priority = 1)
	public void page2VerifyHeadingGridGate() {

		driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
		String expectedTitle = "Grid Gate";
		String actualTitle = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
//    driver.navigate().back();
	}

	@Test(priority = 2)
	public void page2VerifyNumberOfRedLinkInGridGate() throws InterruptedException {

		List<WebElement> links = driver.findElements(By.xpath("//div[@class='redbox']"));
		int actualValue = links.size();
		int expectedValue = 15;
		Assert.assertEquals(actualValue, expectedValue);

	}

	@Test(priority = 3)
	public void page2VerifyNumberOfGreenLinkInGridGate() throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='greenbox']"));
		int actualValue = links.size();
		int expectedValue = 1;
		Assert.assertEquals(actualValue, expectedValue);
	}

	@Test(priority = 4)
	public void page2VerifyRedLinkInGridGate() throws InterruptedException {

		driver.findElement(By.xpath("//div[@class='redbox']")).click();
		String expectedTitle = "Error - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
	}

	@Test(priority = 5)
	public void page2VerifyGreenLinkInGridGate() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='greenbox']")).click();
		String expectedTitle = "Frame Dungeon - Basic Course - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
	}

	@Test(priority = 6)
	public void page2VerifyLinkEmail() {

		String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
		String expectedEmail1 = "<tap@qainfotech.net>";
		String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
		String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
		Assert.assertEquals(actualEmail1, expectedEmail1);
		Assert.assertEquals(actualEmail2, expectedEmail2);
	}

	@Test(priority = 7)
	public void page3VerifyProceedLink() {

		driver.findElement(By.xpath("//div[@class='greenbox']")).click();
		driver.switchTo().frame("main");
		String cl1 = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
		driver.switchTo().frame(driver.findElement(By.id("child")));
		String cl2 = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.id("main")));

		if (cl1.equals(cl2)) {

			driver.findElement(By.xpath("//a[@onclick='gonext();']")).click();
			String expectedTitle = "Drag - Basic Course - T.A.T.O.C";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			driver.navigate().back();
		} else {
			driver.findElement(By.xpath("//a[@onclick='gonext();']")).click();
			String expectedTitle = "Error - T.A.T.O.C";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle, expectedTitle);
			driver.navigate().back();
		}

		driver.switchTo().defaultContent();
	}

	@Test(priority = 8)
	public void page3VerifyLinkEmail() {

		String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
		String expectedEmail1 = "<tap@qainfotech.net>";
		String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
		String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
		Assert.assertEquals(actualEmail1, expectedEmail1);
		Assert.assertEquals(actualEmail2, expectedEmail2);
	}

//	@Test(priority = 9)
//	public void page4() {
//		driver.switchTo().frame(driver.findElement(By.id("main")));
//		driver.findElement(By.xpath("//a[@onclick='gonext();']")).click();
//		//now you are on drag page.
//		WebElement From=driver.findElement(By.xpath("//div[text()='DRAG ME']"));
//		Point loc1= From.getLocation();
//		System.out.println(loc1);
//		/*
//		 * String expectedTitle = "Error - T.A.T.O.C"; String actualTitle =
//		 * driver.getTitle(); Assert.assertEquals(actualTitle, expectedTitle);
//		 * driver.navigate().back();
//		 */
//	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}

}
