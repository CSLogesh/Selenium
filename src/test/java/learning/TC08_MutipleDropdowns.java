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

public class TC08_MutipleDropdowns 
{

	WebDriver driver ;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/html-dropdown-elements-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void multipledopdowns()
	{
		try
		{
		WebElement drp = driver.findElement(By.id("ide"));
		Select select = new Select(drp);
		List<WebElement> options = select.getOptions();
		System.out.println("Number of options available from dropdwon is "+options.size());
		
			for(WebElement option : options)
			{
				if(option.getText().equalsIgnoreCase("IntelliJ IDEA") || option.getText().equalsIgnoreCase("NetBeans"))
				{
					option.click();
				}
			}
			
			System.out.println("TC 08 --> Two options from dropdwon has been clicked successfully...");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}
