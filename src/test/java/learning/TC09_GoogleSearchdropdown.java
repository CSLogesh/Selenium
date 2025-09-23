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

public class TC09_GoogleSearchdropdown 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_autosearchdropdwon()
	{
		try
		{
		driver.findElement(By.name("q")).sendKeys("Eclipse");
		List<WebElement> elements = driver.findElements(By.xpath("//li[@role='presentation' and @data-attrid='AutocompletePrediction']"));
		
		for(WebElement ele : elements)
		{
			//driver.findElement(By.xpath("jijn"))
		}
		
		//boolean displayed = driver.findElement(By.xpath("//*[text()='eclipse download for windows']")).isDisplayed();
		//Assert.assertTrue(displayed);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
