package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_ConditionalMethodsSelected 
{
	WebDriver driver ; 

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
	public void verify_selected()
	{
		try
		{
		WebElement element = driver.findElement(By.id("male"));
		System.out.println("TC 03 --> Is Webelement enabled ? "+ element.isEnabled());
		element.click();
		boolean selected = element.isSelected();
		Assert.assertTrue(selected);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
}
