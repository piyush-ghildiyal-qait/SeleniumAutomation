package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class tictactoe {


    int [] rowCounter;
    int [] colCounter;
    int diagLeft;
    int diagRight;
    int n;
	
	public tictactoe(int n) {
		
		rowCounter = new int[n];
		colCounter = new int[n];
		diagLeft=0;
		diagRight=0;
		this.n=n;
	}
	
	
	public int move(int row,int col,int player)
	{
		int move = player == 1?1:-1;
		rowCounter[row]= rowCounter[row]+move;
		colCounter[row]= colCounter[row]+move;
		
		if(row==col)
		{
			diagLeft=diagLeft+move;
		}
		if(row==n-col-1) diagRight+=move;
		if(rowCounter[row]== -n || colCounter[col]== -n || diagLeft == -n || diagRight == -n)
		{	
			System.out.println("1 won");
		return 1;
		
		}else if(rowCounter[row]== -n || colCounter[col]== -n || diagLeft == -n || diagRight == -n)
		{
			System.out.println("2 won");
			return 2;
		}
		else {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {

		tictactoe obj=new tictactoe(3);
		
		obj.move(0,0,1);
		obj.move(0,2,2);
		obj.move(2,2,1);
		obj.move(1,1,2);
		obj.move(2,0,1);
		obj.move(1,0,2);
		obj.move(2,1,1);
		
		/*
		System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
		WebDriver driver = new ChromeDriver();  
	    driver.manage().window().maximize();
	    String url = "http://10.0.1.86/tap_classroom/TicTacToe/";
	    driver.get(url);
	    driver.close();
		
	    */
	    
	    
	    
	    
	}
}
