package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC16_FramesPractice 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_frameshandling()
	{
		try
		{
			driver.findElement(By.id("name")).sendKeys("This is Logueswar....");
			driver.switchTo().frame("frm1");
			WebElement drpdwn = driver.findElement(By.id("selectnav1"));
			Select select = new Select(drpdwn);
			select.selectByVisibleText("- Java");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frm2");
			driver.findElement(By.id("lastName")).sendKeys("CS");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("frm3");
			driver.findElement(By.id("name")).sendKeys("This is Logesh again....");
			driver.switchTo().frame("frm2");
			System.out.println("TC 16 Confirmation message --> Went inside frame2 again which is inside frame3...");
			driver.findElement(By.id("femalerb")).click();
			driver.switchTo().parentFrame();
			System.out.println("TC 16 Confirmation message --> Exited from frame2 ....");
			driver.switchTo().defaultContent();
			Assert.assertEquals("Frames Practice - H Y R Tutorials", driver.getTitle());
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}
