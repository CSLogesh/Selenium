package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC24_DoubleClickUsingActions 
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
	public void test_Doubleclick()
	{
		WebElement box1 = driver.findElement(By.id("field1"));
		box1.clear();
		box1.sendKeys("Good Evening Everyone !!");
		WebElement button = driver.findElement(By.xpath("//*[text()='Copy Text']"));
		Actions act = new Actions(driver);
		act.doubleClick(button).perform();
		System.out.println("Text entered using actions class in box 2 is "+driver.findElement(By.id("field2")).getText());
	}
}
