package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicTacToe2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://10.0.1.86/tap_classroom/TicTacToe/";
		driver.get(url);

		/*
		int[][] a = new int[3][3];
		
		for (int i = 1; i <=a.length; ++i) {
			for (int j = 1; j <=a[i].length; ++j) {
				System.out.println(a[i][j]);
			}
		}
		
		*/
		// driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']"));

	//driver.findElement(By.xpath("(//td)[1]")).click();
		
		// driver.findElement(By.xpath("//td[@id='11']")).click();

		int NoOfImage;
		NoOfImage=driver.findElements(By.xpath("//img")).size();
		System.out.println(NoOfImage);
		
		if(NoOfImage%2!=0)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@id='11']")).click();
		}
		
	}
}