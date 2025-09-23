package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC34_FileUploads
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_fileuploads()
	{
		WebElement ele = driver.findElement(By.id("singleFileInput"));
		ele.sendKeys("C:\\Users\\eswar\\OneDrive\\Desktop\\Sample.txt");
		driver.findElement(By.xpath("//*[text()='Upload Single File']")).click();
		System.out.println("File upload status -->"+driver.findElement(By.id("singleFileStatus")).getText());
		
	}	
	
}
