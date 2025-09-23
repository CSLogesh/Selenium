package learning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC12_Openlink 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
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
	public void test_openlink()
	{
		try
		{
		driver.findElement(By.xpath("//*[text()='Blog']")).sendKeys(Keys.CONTROL,Keys.ENTER);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String childwindow = list.get(1);
		driver.switchTo().window(childwindow);
		Assert.assertEquals(driver.getTitle(), "SDET-QA Blog");
		//System.out.println(driver.getTitle());
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
		
	}

}
