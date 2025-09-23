package learning;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC14_AlertHandling 
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
	public void testAlerts()
	{
		driver.findElement(By.id("alertBtn")).click();
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println("Simple Alert message --> "+text);
		alert.accept();
		
		driver.findElement(By.id("confirmBtn")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.accept();
		System.out.println("Confirmation Alert message -->"+driver.findElement(By.id("demo")).getText());
		
		driver.findElement(By.id("promptBtn")).click();
		Alert alert3 = driver.switchTo().alert();
		alert3.sendKeys("Logueswar");
		alert3.accept();
		System.out.println("Prompt Alert message -->"+driver.findElement(By.id("demo")).getText());
	}
}
