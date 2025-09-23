package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC10_CheckboxSelection 
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
	public void test_checkboxselection()
	{
		try
		{
		List<WebElement> elements = driver.findElements(By.xpath("//*[@type='checkbox']/parent::div"));
		System.out.println("TC 10 --> Total number of checkboxes in the webpage is "+elements.size());
		
			for(int i=2;i<=elements.size()-3;i++)
			{
				elements.get(i).click();
			}
			
			System.out.println("Checkboxes has been selected successfully...");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
}
