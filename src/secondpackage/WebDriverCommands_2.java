package secondpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCommands_2 {
public static void main(String[] args) {

	//System.setProperty("webdriver.chrome.driver","/usr/local/share/chromedriver/chromedriver");
	System.setProperty("webdriver.chrome.driver","/home/qainfotech/chromedriver");
	WebDriver driver = new ChromeDriver();
driver.get("https://www.udemy.com/");

driver.close();
}
}