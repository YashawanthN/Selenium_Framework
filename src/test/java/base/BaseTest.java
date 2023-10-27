package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static FileReader freader = null;
	public static FileReader freader1 = null;
	public static Properties property = new Properties();
	public static Properties property1 = new Properties();
	
	@BeforeTest
	public void setup() throws IOException {
		if (driver == null) {
			freader = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			freader1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
			property.load(freader);
			property1.load(freader1);
		}

		if (property.getProperty("browser").equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(property.getProperty("url"));
		} else if (property.getProperty("browser").equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(property.getProperty("url"));
		} else if (property.getProperty("browser").equalsIgnoreCase("edge")) 
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(property.getProperty("url"));
		}
	}

	@AfterTest public void teardown() { driver.close();
	 System.out.println(" Closing browser"); }
	 
}
