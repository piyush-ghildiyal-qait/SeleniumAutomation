package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TicTacToe2 {

	
	public boolean isEmpty = false;
	

	
	
	boolean isMovesLeft(char [][] a) 
	{ 
	    for (int i = 0; i<3; i++) 
	        for (int j = 0; j<3; j++) 
	            if (a[i][j]=='_') 
	                return true; 
	    return false; 
	} 
	
	
	

	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "http://10.0.1.86/tap_classroom/TicTacToe/";
		driver.get(url);

		char[][] a = new char[3][3];
		
		
		for (int i = 1; i <=3; ++i) {
			for (int j = 1; j <=3; ++j) {
				//System.out.println(a[i][j]);
		//		System.out.println(Integer.toString(i)+Integer.toString(j));
//System.out.println(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']")).getAttribute("id"));			
		a[i-1][j-1]='_'; // now values are initialised to zero
				
System.out.println("a["+i+"]["+j+"]="+a[i-1][j-1]);				
	}
			System.out.println("\n");
		}
	
		
		// driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']"));

	//driver.findElement(By.xpath("(//td)[1]")).click();
		
		// driver.findElement(By.xpath("//td[@id='11']")).click();
/*
		int NoOfImage;
		NoOfImage=driver.findElements(By.xpath("//img")).size();
		System.out.println(NoOfImage);
		
		if(NoOfImage%2!=0)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//td[@id='11']")).click();
		}
	
		
		*/
		
		String human="Human (Player 1)";
		String tap="TAP (Player 2)";
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		while(true)
		{
		if(driver.findElement(By.xpath("//span[@id='turn']")).getText().equals(tap)) {
			
			driver.findElement(By.xpath("//td[@id='11']")).click();
			a[0][0]=1;
			 
	
				
		
		}
		else {
			wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='turn']"),"TAP (Player 2)"));		

			driver.findElement(By.xpath("//td[@id='12']")).click();
	a[0][1]=1;

	         wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='turn']"),"TAP (Player 2)"));		
			driver.findElement(By.xpath("//td[@id='21']")).click();
				a[1][0]=1;
			
			
				 wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='turn']"),"TAP (Player 2)"));		
					driver.findElement(By.xpath("//td[@id='22']")).click();
						a[1][1]=1;
					
				
			if(driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("TAP Won!!"))
			{
				break;
			}

			if(driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Human Won!!"))
			{
				break;
			}
	
			
		}
		
		
		
		
		}
		
		driver.close();
		
		
		
	}
}