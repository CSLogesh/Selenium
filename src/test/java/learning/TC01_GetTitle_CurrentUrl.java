package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_GetTitle_CurrentUrl 
{
	WebDriver driver;

	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	public void verify_title_url()
	{
		try
		{
		String title = driver.getTitle();
		String currentUrl = driver.getCurrentUrl();
		System.out.println("TC 01 URL --> "+currentUrl);
		Assert.assertEquals(title, "Facebook – log in or sign up");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
}
