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

public class TC02_ConditionalMethodsDisplayed 
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
	public void verify_conditionalmethods()
	{
		try
		{
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'share')]"));
		boolean displayed = element.isDisplayed();
		Assert.assertTrue(displayed);
		}
		catch (Exception e)
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
