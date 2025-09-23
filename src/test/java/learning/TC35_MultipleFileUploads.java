package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC35_MultipleFileUploads 
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
	public void test_multiplefileuploads()
	{
		WebElement element = driver.findElement(By.id("multipleFilesInput"));
		element.sendKeys("C:\\Users\\eswar\\OneDrive\\Desktop\\Sample.txt");
		element.sendKeys("C:\\Users\\eswar\\OneDrive\\Desktop\\Demo.txt");
		driver.findElement(By.xpath("//*[text()='Upload Multiple Files']")).click();
		System.out.println("Multipple File upload status --> "+driver.findElement(By.id("multipleFilesStatus")).getText());
		
	}
	
}
