package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC17_ExplicitWaitDemo 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_explicitwaits()
	{
		try
		{
		driver.findElement(By.id("btn1")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt1"))).sendKeys("Hello !!");
		driver.findElement(By.id("btn2")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt2"))).sendKeys("Good Evening...");
		Assert.assertTrue(true);
		}
		catch (Exception e)
		{
			Assert.assertTrue(false);
		}
	}
}
