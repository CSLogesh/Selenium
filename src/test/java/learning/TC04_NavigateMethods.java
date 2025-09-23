package learning;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC04_NavigateMethods 
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
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void verify_navigationmethods() throws Exception
	{
		try
		{
		
		String facebooktitle = driver.getTitle();
		Assert.assertEquals(facebooktitle, "Facebook – log in or sign up");
		@SuppressWarnings("deprecation")
		URL url = new URL("https://www.amazon.in/");
		driver.navigate().to(url);
		String amazontitle = driver.getTitle();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		//Assert.assertTrue(true);
		Assert.assertEquals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", amazontitle);
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
		}
	}
	
	
	
}
