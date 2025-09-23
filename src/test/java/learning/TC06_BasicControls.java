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

public class TC06_BasicControls 
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
	public void verify_basiccontrols()
	{
		try
		{
		WebElement element = driver.findElement(By.id("name"));
		element.sendKeys("Logueswar");
		String text = driver.findElement(By.xpath("//*[text()='GUI Elements']")).getText();
		Assert.assertEquals(text, "GUI Elements");
		String attribute = driver.findElement(By.id("phone")).getAttribute("placeholder");
		Assert.assertEquals(attribute, "Enter Phone");
		element.clear();
		System.out.println("TC 06 --> Input box is empty now....");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
	}
}
