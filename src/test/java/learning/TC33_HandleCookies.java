package learning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC33_HandleCookies 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.google.com/?zx=1758611677730&no_sw_cr=1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_handlecookies()
	{
		Set<Cookie> cookies = driver.manage().getCookies();
		ArrayList<Cookie> list = new ArrayList<Cookie>(cookies);
		System.out.println("Total number of cookies available in the webapage is "+list.size());
		for(Cookie ck : list)
		{
			String value = ck.getValue();
			System.out.println("Value of Cookie is "+value);
		}
		
	}
}
