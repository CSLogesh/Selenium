package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC25_MouseHover 
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
	public void test_MouseHover()
	{
		WebElement btn = driver.findElement(By.xpath("//*[text()='Point Me']"));
		Actions act = new Actions(driver);
		act.moveToElement(btn).perform();
		List<WebElement> dropdwonlist = driver.findElements(By.xpath("//*[@class='dropdown-content']/a"));
		System.out.println("Total number of dropdown options available after ,ousehover action is "+dropdwonlist.size());
	}

}
