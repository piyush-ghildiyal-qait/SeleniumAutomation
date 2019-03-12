package thirdpackage;

import org.openqa.selenium.By;

   public class MyLocators {

	By enterEmailLocator=By.xpath("//input[@id='identifierId']");
	By enterPasswordLocator=By.xpath("//input[@name='password']");
	By clickOnEmailNextButtonLocator=By.xpath("//div[@id='identifierNext']");
    By clickOnComposeButtonLocator=By.xpath("//div[@gh='cm']");
    By enterReceipentEmailLocator=By.xpath("//textarea[@id=':q0']");
    By enterSubjectInSubjectBoxLocator=By.xpath("//input[@name='subjectbox']");
    By enterMessageInMessageBox=By.xpath("//div[@id=':qn']");
    By enterSendMessageButtonLocator=By.xpath("//div[@id=':p8']");
    By clickOnExpandButtonLocator=By.xpath("//span[@class='gb_ya gbii']");
    By clickOnSignOutButton=By.xpath("//a[text()='Sign out']");
}
