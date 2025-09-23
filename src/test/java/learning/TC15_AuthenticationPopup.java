package learning;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC15_AuthenticationPopup 
{
	WebDriver driver ; 
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_authentication()
	{
		driver.get("https://admin:password@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Authentication popup executed successfully...");
	}

}
