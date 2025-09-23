package learning;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC29_TakeScreenshot 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
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
	public void test_screenshot()
	{
		TakesScreenshot tks = (TakesScreenshot) driver;
		File src = tks.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\screenshots\\ss1.png");
		src.renameTo(trg);
		
		
		WebElement element = driver.findElement(By.xpath("//*[text()='GUI Elements']"));
		File src1 = element.getScreenshotAs(OutputType.FILE);
		File trg1 = new File(".\\screenshots\\element.png");
		src1.renameTo(trg1);
		
		System.out.println("Screenshot captured successfully...");
	}
}
