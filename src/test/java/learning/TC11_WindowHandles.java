package learning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC11_WindowHandles
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
	
	@Test
	public void test_windowhandling()
	{
		try
		{
		driver.findElement(By.xpath("//*[text()='New Tab']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		//String parentwindow = list.get(0);
		String childwindow = list.get(1);
		
		driver.switchTo().window(childwindow);
		String title = driver.getTitle();
		Assert.assertEquals("SDET-QA Blog", title);
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
