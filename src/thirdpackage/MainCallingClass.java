package thirdpackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class MainCallingClass {

	
	static WebDriver driver=null;
	
	public static void main(String[] args) throws InterruptedException {
	
		DriverLoad dl=new DriverLoad();
         driver=dl.setDriver(driver);
		
         AuthenticateGmail gm=new AuthenticateGmail();
		gm.authenticateGmail(driver);
		
		new Compose().composeMessage(driver);
		driver.close();
	}
	
}
