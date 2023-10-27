package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.BaseTest;
import utilities.ReadXLdata;

public class LaunchApp extends BaseTest 
{
	
	@Test(dataProviderClass = ReadXLdata.class,dataProvider = "LoginsData")
	public static void LoginTest(String username, String password) throws InterruptedException 
	{
		System.out.println("Zoho application launch successfully");
		Thread.sleep(3000);
		driver.findElement(By.xpath(property1.getProperty("login"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(property1.getProperty("email"))).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.xpath(property1.getProperty("email_next"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(property1.getProperty("password"))).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.xpath(property1.getProperty("signin"))).click();
		/*Thread.sleep(3000);
		driver.findElement(By.xpath(property1.getProperty("skip"))).click();*/
	}

}
