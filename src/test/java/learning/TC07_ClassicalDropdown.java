package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC07_ClassicalDropdown 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	}
		
	@Test
	public void verify_dropdown()
	{
		try
		{
		WebElement drpdown = driver.findElement(By.id("searchDropdownBox"));
		drpdown.click();
		
		Select select = new Select(drpdown);
		List<WebElement> options = select.getOptions();
		
		System.out.println("TC 07 --> Total number of options available from dropdown is "+options.size());
		
			for(WebElement option:options)
			{
				if(option.getText().equalsIgnoreCase("Computers & Accessories")) 
				{
					option.click();
					break;
				}
			}
		
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
