package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC38_ChromeOptions 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		//options.addArguments("--headless=new");

		driver = new ChromeDriver(options);
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_chromeoptions()
	{
		System.out.println(driver.getTitle());
	}
}
