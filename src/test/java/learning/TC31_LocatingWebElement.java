package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC31_LocatingWebElement 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/#");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_webelementlocation()
	{
		WebElement element = driver.findElement(By.xpath("//*[text()='For Selenium, Cypress & Playwright']"));
		
		System.out.println("Location of Webelement"+element.getLocation());
		
		System.out.println("X-axis of webelement "+element.getLocation().getX());
		System.out.println("Y-axis of webelement "+element.getLocation().getY());
		
		System.out.println("Height of webelement "+element.getRect().getHeight());
		System.out.println("Width of webelement "+element.getRect().getWidth());
		
		System.out.println("X-axis of webelement "+element.getRect().getX());
		System.out.println("Y-axis of webelement "+element.getRect().getY());
	}
}
