package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
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
		System.out.println("run=page1VerifyWindowTitle");
	}

	@Test
	public void page1VerifyHomepageTitle() {
		String expectedTitle = "T.A.T.O.C";
		String actualTitle = driver.findElement(By.xpath("//div[@class='title']")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("run=page1VerifyHomepageTitle");
	}

	@Test
	public void page1VerifySubtextOfTitle() {
		String expectedTitle = "Test Automation Training Obstacle Course";
		String actualTitle = driver.findElement(By.xpath("//div[@class='subtext']")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("run=page1VerifySubtextOfTitle");
	}

	@Test
	public void page1VerifyHeading() {
		String expectedTitle = "Test Automation Training Obstacle Course";
		String actualTitle = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("run=page1VerifyHeading");
	}

	@Test
	public void page1VerifyNumberOfLink() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int actualValue = links.size();
		int expectedValue = 4;
		Assert.assertEquals(actualValue, expectedValue);
		System.out.println("run=page1VerifyNumberOfLink");
	}

	@Test
	public void page1VerifyLinkBasic() {

		driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
		String expectedTitle = "Grid Gate - Basic Course - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
		System.out.println("run=page1VerifyLinkBasic");
	}

	@Test
	public void page1VerifyLinkAdvance() {

		driver.findElement(By.xpath("//a[text()='Advanced Course']")).click();
		String expectedTitle = "Hover Menu - Advanced Course - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
		System.out.println("run=page1VerifyLinkAdvance");
	}

	@Test
	public void page1VerifyLinkEmail() {

		String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
		String expectedEmail1 = "<tap@qainfotech.net>";

		String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
		String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
		Assert.assertEquals(actualEmail1, expectedEmail1);
		Assert.assertEquals(actualEmail2, expectedEmail2);
		System.out.println("run=page1VerifyLinkEmail");
	}

//----------------------------------- Grid Gate ------------------------------------------------------------

	@Test(priority = 1)
	public void page2VerifyHeadingGridGate() {

		driver.findElement(By.xpath("//a[text()='Basic Course']")).click();
		String expectedTitle = "Grid Gate";
		String actualTitle = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertEquals(actualTitle, expectedTitle);
//    driver.navigate().back();
		System.out.println("run=page2VerifyHeadingGridGate");
	}

	@Test(priority = 2)
	public void page2VerifyNumberOfRedLinkInGridGate()  {

		List<WebElement> links = driver.findElements(By.xpath("//div[@class='redbox']"));
		int actualValue = links.size();
		int expectedValue = 15;
		Assert.assertEquals(actualValue, expectedValue);
		System.out.println("run=page2VerifyNumberOfRedLinkInGridGate");
	}

	@Test(priority = 3)
	public void page2VerifyNumberOfGreenLinkInGridGate()  {

	//	Thread.sleep(2000);
		List<WebElement> links = driver.findElements(By.xpath("//div[@class='greenbox']"));
		int actualValue = links.size();
		int expectedValue = 1;
		Assert.assertEquals(actualValue, expectedValue);
	
		System.out.println("run=page2VerifyNumberOfGreenLinkInGridGate");
	}

	@Test(priority = 4)
	public void page2VerifyRedLinkInGridGate() {

		driver.findElement(By.xpath("//div[@class='redbox']")).click();
		String expectedTitle = "Error - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
		
		System.out.println("run=page2VerifyRedLinkInGridGate");
	}

	@Test(priority = 5)
	public void page2VerifyGreenLinkInGridGate() {
		driver.findElement(By.xpath("//div[@class='greenbox']")).click();
		String expectedTitle = "Frame Dungeon - Basic Course - T.A.T.O.C";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		driver.navigate().back();
		
		System.out.println("run=page2VerifyGreenLinkInGridGate");
	}

	@Test(priority = 6)
	public void page2VerifyLinkEmail() {

		String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
		String expectedEmail1 = "<tap@qainfotech.net>";
		String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
		String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
		Assert.assertEquals(actualEmail1, expectedEmail1);
		Assert.assertEquals(actualEmail2, expectedEmail2);
		
		System.out.println("run=page2VerifyLinkEmail");
		System.out.println("p6 "+driver.getTitle());
	}
// yha par ruk rha hai. page is not reloading because it is navigating back.
	@Test(priority = 7)
	public void page3VerifyProceedLink() {
		System.out.println("p6 "+driver.getTitle());
		driver.findElement(By.xpath("//div[@class='greenbox']")).click();
		System.out.println("p6 "+driver.getTitle());
		driver.switchTo().frame("main");
		String cl1 = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
		System.out.println("Printing the color of box 1 "+cl1);
		driver.switchTo().frame(driver.findElement(By.id("child")));
		String cl2 = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
		System.out.println("Printing the color of box 2 "+cl2);
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
			System.out.println("Navigated back");
		}

		driver.switchTo().defaultContent();
		System.out.println("run=page3VerifyProceedLink");
	}

	@Test(priority = 8)
	public void page3VerifyLinkEmail() {

		String actualEmail1 = driver.findElement(By.xpath("//a[text()='<tap@qainfotech.net>']")).getText();
		String expectedEmail1 = "<tap@qainfotech.net>";
		String actualEmail2 = driver.findElement(By.xpath("//a[text()='<ramandeepsingh@qainfotech.net>']")).getText();
		String expectedEmail2 = "<ramandeepsingh@qainfotech.net>";
		Assert.assertEquals(actualEmail1, expectedEmail1);
		Assert.assertEquals(actualEmail2, expectedEmail2);
		System.out.println(driver.getTitle());
		System.out.println("mail id is correct");
		System.out.println("run=page3VerifyLinkEmail");
	}

@Test(priority = 9)
public void page4VerifyProceedButtonInFalseCondition() throws InterruptedException {

		/* Now You are on drag drop page */
driver.switchTo().frame("main");
String cl1 = driver.findElement(By.xpath("//div[text()='Box 1']")).getAttribute("class");
driver.switchTo().frame(driver.findElement(By.id("child")));
String cl2 = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));
while (!cl1.equals(cl2)) {
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));
driver.findElement(By.xpath("//a[text()='Repaint Box 2']")).click();
driver.switchTo().frame(driver.findElement(By.id("child")));
cl2 = driver.findElement(By.xpath("//div[text()='Box 2']")).getAttribute("class");
Thread.sleep(1000);
}
driver.switchTo().defaultContent();
driver.switchTo().frame(driver.findElement(By.id("main")));
driver.findElement(By.xpath("//a[text()='Proceed']")).click();
System.out.println(driver.getTitle());
		
driver.findElement(By.xpath("//a[text()='Proceed']")).click();

String expectedTitle = "Error - T.A.T.O.C";
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle);
driver.navigate().back();


System.out.println("run=page4VerifyProceedButtonInFalseCondition");

}

	
@Test(priority = 10)
public void page4VerifyProceedButtonInTrueCondition() throws InterruptedException {

/*   Now write your logic to test button in drag drop page */


WebElement From = driver.findElement(By.xpath("//div[text()='DRAG ME']"));

//Element on which need to drop.		
WebElement To = driver.findElement(By.xpath("//div[text()='DROPBOX']"));

//Using Action class for drag and drop.		
Actions act = new Actions(driver);

//Dragged and dropped.		
act.dragAndDrop(From, To).build().perform();

Thread.sleep(1000);
driver.findElement(By.xpath("//a[text()='Proceed']")).click();


String expectedTitle = "Windows - Basic Course - T.A.T.O.C";
String actualTitle = driver.getTitle();
Assert.assertEquals(actualTitle, expectedTitle);
driver.navigate().back();


System.out.println("run=page4VerifyProceedButtonInTrueCondition");
}
	
@Test(priority =11)
public void page4VerifyIfBoxMovable() throws InterruptedException {
	
	String expectedmes;
	  System.out.println("p11: now you are on "+ driver.getTitle()+"  page");
		
	WebElement From = driver.findElement(By.xpath("//div[text()='DRAG ME']"));
	String locationBeforeMove=From.getLocation().toString();
	System.out.println(locationBeforeMove);
	//Element on which need to drop.		
	WebElement To = driver.findElement(By.xpath("//div[text()='DROPBOX']"));
	
	Actions act = new Actions(driver);
	act.dragAndDrop(From, To).build().perform();
	Thread.sleep(1000);
	  System.out.println("p11: now you are on "+ driver.getTitle()+"  page");
	
String locationAfterMove=From.getLocation().toString();
System.out.println(locationAfterMove);
	if(locationAfterMove!=locationBeforeMove) {
		expectedmes="movable";
	}
	else
	{
		expectedmes="unmovable";
	}

	Assert.assertEquals("movable", expectedmes);
	
	System.out.println("run page4VerifyIfBoxMovable");
	// now you are on window popup page
	
	
	driver.findElement(By.xpath("//a[text()='Proceed']")).click();

}

//now you are on window popup page

	
	  @Test(priority = 12)
	  public void page5verifyLaunchPopupWindowButton() throws InterruptedException {
	  
	 
	  //Perform the click operation that opens new window
	  
	  
	  System.out.println("p12 now you are on "+ driver.getTitle()+"  page");
	  
	  
	 
	  driver.findElement(By.xpath("//a[@onclick='launchwindow();']")).click();
	  
	//  String winHandleBefore = driver.getWindowHandle();
	  Thread.sleep(2000); 
	  //Switch to new window opened 
	  
	  for (String winHandle :driver.getWindowHandles())
	  { driver.switchTo().window(winHandle); }
	  String expectedTitle = "Popup - Basic Course - T.A.T.O.C";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
//	  driver.navigate().back();
	  Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='submit']")).click();
		System.out.println("out of p12");
	  }

	  @Test(priority = 13)
	  public void page5verifyProceedButton() throws InterruptedException {
	
		  System.out.println("p13"+driver.getTitle());
		  driver.findElement(By.xpath("//a[@onclick='launchwindow();']")).click();
			System.out.println("p13 now you have clicked launch button");
			
		  String winHandleBefore = driver.getWindowHandle();
		  Thread.sleep(1000);
		  //Switch to new window opened 
		  for (String winHandle :driver.getWindowHandles())
		  { driver.switchTo().window(winHandle); }
			System.out.println("p13 now you have switched button");  
		  
		  
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("piyush ghildiyal");
			System.out.println("now you have entered value in text box");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@id='submit']")).click();
			System.out.println("now you have clicked submit button");
	// Switch back to original browser (first window)
			driver.switchTo().window(winHandleBefore);

			driver.findElement(By.xpath("//a[text()='Proceed']")).click();
			System.out.println("p13 now you have clicked submit button");
			System.out.println("p13:"+driver.getTitle());

			
	  }
	  
	  
	  
	@AfterTest
	public void terminateBrowser() {
		System.out.println("close");
		driver.close();
	}

}


