package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC23_CalendarRange 
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
	public void test_rangeofdates()
	{
		driver.findElement(By.id("start-date")).sendKeys("22-09-2025");
		driver.findElement(By.id("end-date")).sendKeys("04-12-2025");
		driver.findElement(By.className("submit-btn")).click();
		
		System.out.println("Difference between selected 2 dates is "+driver.findElement(By.id("result")).getText());
	}

}
