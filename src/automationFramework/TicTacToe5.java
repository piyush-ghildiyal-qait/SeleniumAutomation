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

public class TicTacToe5 {


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

	
	int[][] b=new int[3][3];

	for(int i=1;i<=3;i++)
	{
	for(int j=1;j<=3;j++)
	{
       b[i-1][j-1]=a[i-1][j-1];			
	}
	}

	
for(int i=1;i<=3;i++)
		{
		for(int j=1;j<=3;j++)
		{
			if(IsTestElementPresent(driver, i, j))
			{
	        //   System.out.println("image is loaded");
	       	
            if(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src").equals("http://10.0.1.86/tap_classroom/TicTacToe/x.png"))
			{
			
			//	System.out.println("x image");
			  b[i-1][j-1]=b[i-1][j-1]+1;
			}
            if(driver.findElement(By.xpath("//td[@id='"+Integer.toString(i)+Integer.toString(j)+"']/img")).getAttribute("src").equals("http://10.0.1.86/tap_classroom/TicTacToe/o.png"))
			{
            //	System.out.println("o image");
			  b[i-1][j-1]=b[i-1][j-1]-1;
			}
			}
			else
			{
			//	System.out.println("image is not loaded");
			}
		}
		}
		
for(int i=1;i<=3;i++)
{
for(int j=1;j<=3;j++)
{
   a[i-1][j-1]=b[i-1][j-1] - a[i-1][j-1];			
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
	
	public void logic(WebDriver driver,int[][] a)
	{
		System.out.println("in logic");
	/*	
          if(a[0][0]!=0 && a[0][1]==0 && a[0][2]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][0]==0 && a[0][1]==0 && a[0][2]!=0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][0]==0 && a[0][1]!=0 && a[0][2]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][0]!=0 && a[1][0]==0 && a[2][0]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][0]==0 && a[1][0]!=0 && a[2][0]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][0]==0 && a[1][0]==0 && a[2][0]!=0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][2]!=0 && a[1][2]==0 && a[2][2]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][2]==0 && a[1][2]!=0 && a[2][2]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[0][2]==0 && a[1][2]==0 && a[2][2]!=0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[2][0]!=0 && a[2][1]==0 && a[2][2]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[2][0]==0 && a[2][1]!=0 && a[2][2]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if(a[2][0]==0 && a[2][1]==0 && a[2][2]!=0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          
          // first row
          else if((a[0][0]==1 && a[0][1]==1 && a[0][2]==0) || (a[0][0]==-1 && a[0][1]==-1 && a[0][2]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='13']")).click();
          }
          else if((a[0][0]==1 && a[0][1]==0 && a[0][2]==1) || (a[0][0]==-1 && a[0][1]==0 && a[0][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='12']")).click();
          }
          else if((a[0][0]==0 && a[0][1]==1 && a[0][2]==1) || (a[0][0]==0 && a[0][1]==-1 && a[0][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='11']")).click();
          }
        
        
          // second row
          else if((a[1][0]==1 && a[1][1]==1 && a[1][2]==0 ) || (a[1][0]==-1 && a[1][1]==-1 && a[1][2]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='23']")).click();
          }
          else if((a[1][0]==1 && a[1][1]==0 && a[1][2]==1 ) || (a[1][0]==-1 && a[1][1]==0 && a[1][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          else if((a[1][0]==0 && a[1][1]==1 && a[1][2]==1) || ( a[1][0]==0 && a[1][1]==-1 && a[1][2]==-1) )
          {
        	  driver.findElement(By.xpath("//td[@id='21']")).click();
          }
         
        
         
       // third row
          else if( (a[2][0]==1 && a[2][1]==1 && a[2][2]==0) || (a[2][0]==-1 && a[2][1]==-1 && a[2][2]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='33']")).click();
          }
          else if((a[2][0]==1 && a[2][1]==0 && a[2][2]==1) || (a[2][0]==-1 && a[2][1]==0 && a[2][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='32']")).click();
          }
          else if((a[2][0]==0 && a[2][1]==1 && a[2][2]==1)  ||  (a[2][0]==0 && a[2][1]==1 && a[2][2]==1))
          {
        	  driver.findElement(By.xpath("//td[@id='31']")).click();
          }
          
          
          
          // first column
          
          else if((a[0][0]==1 && a[1][0]==1 && a[2][0]==0) || (a[0][0]==-1 && a[1][0]==-1 && a[2][0]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='31']")).click();
          }
          else if((a[0][0]==0 && a[1][0]==1 && a[2][0]==1) || (a[0][0]==0 && a[1][0]==-1 && a[2][0]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='11']")).click();
          }
          else if((a[0][0]==1 && a[1][0]==0 && a[2][0]==1) || (a[0][0]==-1 && a[1][0]==0 && a[2][0]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='21']")).click();
          }
          
         
 // second column
          
          else if(a[0][1]!=0 && a[1][1]!=0 && a[2][1]==0)
          {
        	  driver.findElement(By.xpath("//td[@id='32']")).click();
          }
          else if(a[0][1]==0 && a[1][1]!=0 && a[2][1]!=0)
          {
        	  driver.findElement(By.xpath("//td[@id='12']")).click();
          }
          else if(a[0][1]!=0 && a[1][1]==0 && a[2][1]!=0)
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          
 
// third column
          
          else if((a[0][2]==1 && a[1][2]==1 && a[2][2]==0) || (a[0][2]==-1 && a[1][2]==-1 && a[2][2]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='33']")).click();
          }
          else if((a[0][2]==0 && a[1][2]==1 && a[2][2]==1) || (a[0][2]==0 && a[1][2]==-1 && a[2][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='13']")).click();
          }
          else if((a[0][2]==1 && a[1][2]==0 && a[2][2]==1) || (a[0][2]==-1 && a[1][2]==0 && a[2][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='23']")).click();
          }
     
//  first diagonal  \
          
          else if((a[0][0]==1 && a[1][1]==1 && a[2][2]==0) || (a[0][0]==-1 && a[1][1]==-1 && a[2][2]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='33']")).click();
          }
          else if((a[0][0]==0 && a[1][1]==1 && a[2][2]==1) || (a[0][0]==0 && a[1][1]==-1 && a[2][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='11']")).click();
          }
          else if((a[0][0]==1 && a[1][1]==0 && a[2][2]==1) || (a[0][0]==-1 && a[1][1]==0 && a[2][2]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
          
          
//  second diagonal  /
          
          else if((a[0][2]==1 && a[1][1]==1 && a[2][0]==0) || (a[0][2]==-1 && a[1][1]==-1 && a[2][0]==0))
          {
        	  driver.findElement(By.xpath("//td[@id='31']")).click();
          }
          else if((a[0][2]==0 && a[1][1]==1 && a[2][0]==1) || (a[0][2]==0 && a[1][1]==1 && a[2][0]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='13']")).click();
          }
          else if((a[0][2]==1 && a[1][1]==0 && a[2][0]==1)|| (a[0][2]==-1 && a[1][1]==0 && a[2][0]==-1))
          {
        	  driver.findElement(By.xpath("//td[@id='22']")).click();
          }
 
 */              
          
	
        if(a[0][0]!=0 && a[0][1]==0 && a[0][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][0]==0 && a[0][1]==0 && a[0][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][0]==0 && a[0][1]!=0 && a[0][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][0]!=0 && a[1][0]==0 && a[2][0]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][0]==0 && a[1][0]!=0 && a[2][0]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][0]==0 && a[1][0]==0 && a[2][0]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][2]!=0 && a[1][2]==0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][2]==0 && a[1][2]!=0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[0][2]==0 && a[1][2]==0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[2][0]!=0 && a[2][1]==0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[2][0]==0 && a[2][1]!=0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[2][0]==0 && a[2][1]==0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        
        // first row
        if((a[0][0]==1 && a[0][1]==1 && a[0][2]==0) || (a[0][0]==-1 && a[0][1]==-1 && a[0][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if((a[0][0]==1 && a[0][1]==0 && a[0][2]==1) || (a[0][0]==-1 && a[0][1]==0 && a[0][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='12']")).click();
        }
        if((a[0][0]==0 && a[0][1]==1 && a[0][2]==1) || (a[0][0]==0 && a[0][1]==-1 && a[0][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
      
      
   // second row
        if((a[1][0]==1 && a[1][1]==1 && a[1][2]==0 ) || (a[1][0]==-1 && a[1][1]==-1 && a[1][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='23']")).click();
        }
        if((a[1][0]==1 && a[1][1]==0 && a[1][2]==1 ) || (a[1][0]==-1 && a[1][1]==0 && a[1][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if((a[1][0]==0 && a[1][1]==1 && a[1][2]==1) || ( a[1][0]==0 && a[1][1]==-1 && a[1][2]==-1) )
        {
      	  driver.findElement(By.xpath("//td[@id='21']")).click();
        }
       
      
       
     // third row
        if( (a[2][0]==1 && a[2][1]==1 && a[2][2]==0) || (a[2][0]==-1 && a[2][1]==-1 && a[2][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if((a[2][0]==1 && a[2][1]==0 && a[2][2]==1) || (a[2][0]==-1 && a[2][1]==0 && a[2][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='32']")).click();
        }
        if((a[2][0]==0 && a[2][1]==1 && a[2][2]==1)  ||  (a[2][0]==0 && a[2][1]==1 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        
        
        
        // first column
        
        if((a[0][0]==1 && a[1][0]==1 && a[2][0]==0) || (a[0][0]==-1 && a[1][0]==-1 && a[2][0]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        if((a[0][0]==0 && a[1][0]==1 && a[2][0]==1) || (a[0][0]==0 && a[1][0]==-1 && a[2][0]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
        if((a[0][0]==1 && a[1][0]==0 && a[2][0]==1) || (a[0][0]==-1 && a[1][0]==0 && a[2][0]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='21']")).click();
        }
        
       
// second column
        
        if((a[0][1]==1 && a[1][1]==1 && a[2][1]==0) || (a[0][1]==-1 && a[1][1]==-1 && a[2][1]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='32']")).click();
        }
        if((a[0][1]==0 && a[1][1]==1 && a[2][1]==1) || (a[0][1]==0 && a[1][1]==-1 && a[2][1]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='12']")).click();
        }
        if((a[0][1]==1 && a[1][1]==0 && a[2][1]==1) || (a[0][1]==-1 && a[1][1]==0 && a[2][1]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        

//third column
        
        if((a[0][2]==1 && a[1][2]==1 && a[2][2]==0) || (a[0][2]==-1 && a[1][2]==-1 && a[2][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if((a[0][2]==0 && a[1][2]==1 && a[2][2]==1) || (a[0][2]==0 && a[1][2]==-1 && a[2][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if((a[0][2]==1 && a[1][2]==0 && a[2][2]==1) || (a[0][2]==-1 && a[1][2]==0 && a[2][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='23']")).click();
        }
   
//first diagonal  \
        
        if((a[0][0]==1 && a[1][1]==1 && a[2][2]==0) || (a[0][0]==-1 && a[1][1]==-1 && a[2][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if((a[0][0]==0 && a[1][1]==1 && a[2][2]==1) || (a[0][0]==0 && a[1][1]==-1 && a[2][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
        if((a[0][0]==1 && a[1][1]==0 && a[2][2]==1) || (a[0][0]==-1 && a[1][1]==0 && a[2][2]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        
        
//second diagonal  /
        
        if((a[0][2]==1 && a[1][1]==1 && a[2][0]==0) || (a[0][2]==-1 && a[1][1]==-1 && a[2][0]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        if((a[0][2]==0 && a[1][1]==1 && a[2][0]==1) || (a[0][2]==0 && a[1][1]==1 && a[2][0]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if((a[0][2]==1 && a[1][1]==0 && a[2][0]==1)|| (a[0][2]==-1 && a[1][1]==0 && a[2][0]==-1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        
        
        
        
        
      
 /*    
        // first row
        if((a[0][0]==1 && a[0][1]==-1 && a[0][2]==0) || (a[0][0]==-1 && a[0][1]==1 && a[0][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if((a[0][0]==1 && a[0][1]==0 && a[0][2]==-1) || (a[0][0]==-1 && a[0][1]==0 && a[0][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='12']")).click();
        }
        if((a[0][0]==0 && a[0][1]==1 && a[0][2]==-1) || (a[0][0]==0 && a[0][1]==-1 && a[0][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
      
      
        // second row
        if((a[1][0]==1 && a[1][1]==-1 && a[1][2]==0 ) || (a[1][0]==-1 && a[1][1]==1 && a[1][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='23']")).click();
        }
        if((a[1][0]==1 && a[1][1]==0 && a[1][2]==-1 ) || (a[1][0]==-1 && a[1][1]==0 && a[1][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if((a[1][0]==0 && a[1][1]==1 && a[1][2]==-1) || ( a[1][0]==0 && a[1][1]==-1 && a[1][2]==1) )
        {
      	  driver.findElement(By.xpath("//td[@id='21']")).click();
        }
       
      
       
     // third row
        if( (a[2][0]==1 && a[2][1]==-1 && a[2][2]==0) || (a[2][0]==-1 && a[2][1]==1 && a[2][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if((a[2][0]==1 && a[2][1]==0 && a[2][2]==-1) || (a[2][0]==-1 && a[2][1]==0 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='32']")).click();
        }
        if((a[2][0]==0 && a[2][1]==1 && a[2][2]==-1)  ||  (a[2][0]==0 && a[2][1]==-1 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        
        
        
        // first column
        
        if((a[0][0]==1 && a[1][0]==-1 && a[2][0]==0) || (a[0][0]==-1 && a[1][0]==1 && a[2][0]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        if((a[0][0]==0 && a[1][0]==1 && a[2][0]==-1) || (a[0][0]==0 && a[1][0]==-1 && a[2][0]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
        if((a[0][0]==1 && a[1][0]==0 && a[2][0]==-1) || (a[0][0]==-1 && a[1][0]==0 && a[2][0]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='21']")).click();
        }
        
       
// second column
        
        if((a[0][1]==1 && a[1][1]==-1 && a[2][1]==0) || (a[0][1]==-1 && a[1][1]==1 && a[2][1]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='32']")).click();
        }
        if((a[0][1]==0 && a[1][1]==1 && a[2][1]==-1) || (a[0][1]==0 && a[1][1]==-1 && a[2][1]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='12']")).click();
        }
        if((a[0][1]==1 && a[1][1]==0 && a[2][1]==-1) || (a[0][1]==-1 && a[1][1]==0 && a[2][1]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        

//third column
        
        if((a[0][2]==1 && a[1][2]==-1 && a[2][2]==0) || (a[0][2]==-1 && a[1][2]==1 && a[2][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if((a[0][2]==0 && a[1][2]==1 && a[2][2]==-1) || (a[0][2]==0 && a[1][2]==-1 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if((a[0][2]==1 && a[1][2]==0 && a[2][2]==-1) || (a[0][2]==-1 && a[1][2]==0 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='23']")).click();
        }
   
//first diagonal  \
        
        if((a[0][0]==1 && a[1][1]==-1 && a[2][2]==0) || (a[0][0]==-1 && a[1][1]==1 && a[2][2]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if((a[0][0]==0 && a[1][1]==1 && a[2][2]==-1) || (a[0][0]==0 && a[1][1]==-1 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
        if((a[0][0]==1 && a[1][1]==0 && a[2][2]==-1) || (a[0][0]==-1 && a[1][1]==0 && a[2][2]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        
        
//second diagonal  /
        
        if((a[0][2]==1 && a[1][1]==-1 && a[2][0]==0) || (a[0][2]==-1 && a[1][1]==1 && a[2][0]==0))
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        if((a[0][2]==0 && a[1][1]==1 && a[2][0]==-1) || (a[0][2]==0 && a[1][1]==-1 && a[2][0]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if((a[0][2]==1 && a[1][1]==0 && a[2][0]==-1)|| (a[0][2]==-1 && a[1][1]==0 && a[2][0]==1))
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
       
        
        
   */     
        
 /*       
     
        
        
        
 // first row
        
        if(a[0][0]!=0 && a[0][1]!=0 && a[0][2]==0 )
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if(a[0][0]!=0 && a[0][1]==0 && a[0][2]!=0 )
        {
      	  driver.findElement(By.xpath("//td[@id='12']")).click();
        }
        if(a[0][0]==0 && a[0][1]!=0 && a[0][2]!=0 )
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }


         // second row
        if(a[1][0]!=0 && a[1][1]!=0 && a[1][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='23']")).click();
        }
        if(a[1][0]!=0 && a[1][1]==0 && a[1][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        if(a[1][0]==0 && a[1][1]!=0 && a[1][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='21']")).click();
        }



      // third row
        if(a[2][0]!=0 && a[2][1]!=0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if(a[2][0]!=0 && a[2][1]==0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='32']")).click();
        }
        if(a[2][0]==0 && a[2][1]!=0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }



         // first column

         if(a[0][0]!=0 && a[1][0]!=0 && a[2][0]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        if(a[0][0]==0 && a[1][0]!=0 && a[2][0]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
        if(a[0][0]!=0 && a[1][0]==0 && a[2][0]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='21']")).click();
        }


// second column

         if(a[0][1]!=0 && a[1][1]!=0 && a[2][1]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='32']")).click();
        }
        if(a[0][1]==0 && a[1][1]!=0 && a[2][1]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='12']")).click();
        }
        if(a[0][1]!=0 && a[1][1]==0 && a[2][1]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }


// third column

         if(a[0][2]!=0 && a[1][2]!=0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if(a[0][2]==0 && a[1][2]!=0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if(a[0][2]!=0 && a[1][2]==0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='23']")).click();
        }

//  first diagonal  \

         if(a[0][0]!=0 && a[1][1]!=0 && a[2][2]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='33']")).click();
        }
        if(a[0][0]==0 && a[1][1]!=0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='11']")).click();
        }
        if(a[0][0]!=0 && a[1][1]==0 && a[2][2]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }


//  second diagonal  /

         if(a[0][2]!=0 && a[1][1]!=0 && a[2][0]==0)
        {
      	  driver.findElement(By.xpath("//td[@id='31']")).click();
        }
        if(a[0][2]==0 && a[1][1]!=0 && a[2][0]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='13']")).click();
        }
        if(a[0][2]!=0 && a[1][1]==0 && a[2][0]!=0)
        {
      	  driver.findElement(By.xpath("//td[@id='22']")).click();
        }
        */
        
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
		WebDriverWait wait = new WebDriverWait(driver, 10);
		TicTacToe5 ttt1=new TicTacToe5();
		
		while (true) {

			if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals(tap)) {

				
				ttt1.logic(driver, a);
				ttt1.increment(driver, a);	
				ttt1.printArray(a);

				if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("TAP Won!!")) {
					ttt1.printArray(a);
					break;

				}
				if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Its a tie!!")) {
					ttt1.printArray(a);
					break;

				}
				if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Human Won!!")) {
					ttt1.printArray(a);
					break;
				}
			}
			else {
				
		//	       wait.until(ExpectedConditions.textToBe(By.xpath("//span[@id='turn']"),"TAP (Player 2)"));
				wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//span[@id='turn']"),"TAP (Player 2)"));
				ttt1.logic(driver, a);
				   ttt1.increment(driver, a);	
				   ttt1.printArray(a);

					if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("TAP Won!!")) {
						ttt1.printArray(a);
						break;

					}
					if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Its a tie!!")) {
						ttt1.printArray(a);
						break;

					}
					if (driver.findElement(By.xpath("//span[@id='turn']")).getText().equals("Human Won!!")) {
						ttt1.printArray(a);
						break;
					}
				
			}
	         
		}

			driver.close();
			
		}
				
		
		
		
	}