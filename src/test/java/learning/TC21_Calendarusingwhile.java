package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC21_Calendarusingwhile 
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
	public void test_calendar()
	{
		driver.findElement(By.id("datepicker")).click();
		
		String requiredmonth="December";
		String requiredyear= "2026";
		String requireddate="4";
		
		while(true)
		{
			String currentmonth = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']")).getText();
			String currentyear = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']")).getText();
			
			if(currentmonth.equalsIgnoreCase(requiredmonth) && currentyear.equalsIgnoreCase(requiredyear))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[text()='Next']")).click();
			}

		}
		
		List<WebElement> alldates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement dt : alldates)
		{
			if(dt.getText().equalsIgnoreCase(requireddate))
			{
				dt.click();
				break;
			}
		}
		
		System.out.println("Selected date is in the format of MM/DD/YYYY --> "+driver.findElement(By.id("datepicker")).getAttribute("value"));
	}
}
