package automationFramework;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicTacToe4 {


	boolean isMovesLeft(int [][] a) 
	{ 
	    for (int i = 0; i<3; i++) 
	        for (int j = 0; j<3; j++) 
	            if (a[i][j]==0) 
	                return true; 
	    return false; 
	} 
	
	
	boolean isWin(int[][] a) {
		return ((a[0][0] + a[0][1] + a[0][2] == 3) || (a[1][0] + a[1][1] + a[1][2] == 3)
				|| (a[2][0] + a[2][1] + a[2][2] == 3) || (a[0][0] + a[1][0] + a[2][0] == 3)
				|| (a[0][1] + a[1][1] + a[2][1] == 3) || (a[0][2] + a[1][2] + a[2][2] == 3)
				|| (a[0][0] + a[1][1] + a[2][2] == 3) || (a[2][0] + a[1][1] + a[0][2] == 3)
				|| (a[0][0] + a[0][1] + a[0][2] == -3) || (a[1][0] + a[1][1] + a[1][2] == -3)
				|| (a[2][0] + a[2][1] + a[2][2] == -3) || (a[0][0] + a[1][0] + a[2][0] == -3)
				|| (a[0][1] + a[1][1] + a[2][1] == -3) || (a[0][2] + a[1][2] + a[2][2] == -3)
				|| (a[0][0] + a[1][1] + a[2][2] == -3) || (a[2][0] + a[1][1] + a[0][2] == -3)

		);
	}
	
	
	public static boolean IsTestElementPresent(WebDriver driver,int i,int j)
	{
	    try
	    {
	        driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img"));
	        return true;
	    }
	    catch (NoSuchElementException e)
	    {
	        return false;
	    }
	}
	
	
	
void increment(WebDriver driver,int[][] a) {

for(int i=1;i<=3;i++)
		{
		for(int j=1;j<=3;j++)
		{
			if(IsTestElementPresent(driver, i, j))
			{
	           System.out.println("image is loaded");
	       	
            if(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src").equals("http://10.0.1.86/tap_classroom/TicTacToe/x.png"))
			{
			
				System.out.println("x image");
			  a[i-1][j-1]=a[i-1][j-1]+1;
			}
            if(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src").equals("http://10.0.1.86/tap_classroom/TicTacToe/o.png"))
			{
				System.out.println("o image");
			  a[i-1][j-1]=a[i-1][j-1]-1;
			}
			}
			else
			{
				System.out.println("image is not loaded");
			}
		}
		}
		
	}
	
	public  void printArray(int[][] a)
	{
		for(int i=1;i<=3;i++)
		{
		for(int j=1;j<=3;j++)
		{
			System.out.println("a["+i+"]["+j+"]="+a[i-1][j-1]);			
		}
		}
		
	}

	
	
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://10.0.1.86/tap_classroom/TicTacToe/";
		driver.get(url);

		int[][] a = new int[3][3];
		
		
		for (int i = 1; i <= 3; ++i) {
			for (int j = 1; j <= 3; ++j) {
				a[i - 1][j - 1] = 0; // now values are initialised to zero

				System.out.println("a[" + i + "][" + j + "]=" + a[i - 1][j - 1]);
			}
			System.out.println("\n");
		}

		String human="Human (Player 1)";
		String tap="TAP (Player 2)";
		
		
		while (true) {

			if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals(tap)) {

				List<WebElement> links = driver.findElements(By.xpath("//td"));

				// select a random one
				Random gen = new Random();
				WebElement link = links.get(gen.nextInt(links.size()));
				System.out.println(gen.nextInt(links.size()));
				link.click();
				
			//	WebDriverWait wait = new WebDriverWait(driver, 10);
			//	wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='turn']"), "TAP (Player 2)"));

				TicTacToe4 ttt=new TicTacToe4();
				ttt.increment(driver, a);
				
				
/*
				for(int i=1;i<=3;i++)
				{
				for(int j=1;j<=3;j++)
				{
					if(ttt.IsTestElementPresent(driver, i, j))
					{
					if(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src")=="x.png")
					{
						System.out.println("hello");
		System.out.println(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src"));
					  a[i-1][j-1]=a[i-1][j-1]+1;
					}
					if(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src")=="o.png")
					{
					  a[i-1][j-1]=a[i-1][j-1]-1;
					}
					}
				}
				}
	*/			
				ttt.printArray(a);
/*				
				for(int i=1;i<=3;i++)
				{
				for(int j=1;j<=3;j++)
				{
					System.out.println("a["+i+"]["+j+"]="+a[i-1][j-1]);			
				}
				}
				
*/				

				if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("TAP Won!!")) {
					ttt.printArray(a);
					break;

				}
				if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Its a tie!!")) {
					ttt.printArray(a);
					break;

				}
				if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Human Won!!")) {
					ttt.printArray(a);
					break;
				}
				
				if(ttt.isWin(a))
				{
					break;
				}

			}
		}

			
			
			driver.close();
			
		}
				
		
		
		
	}
