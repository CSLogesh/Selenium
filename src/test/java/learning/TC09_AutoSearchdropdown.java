package learning;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC09_AutoSearchdropdown 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.bing.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_autosearchdropdwon()
	{
		
		driver.findElement(By.id("sb_form_q")).sendKeys("Eclipse");
		List<WebElement> elements = driver.findElements(By.xpath("//li[@role='option']/div[@class='sa_tm']/span"));
		
		for(WebElement ele : elements)
		{
			if(ele.getText().equals("eclipse ide"))
			{
				ele.click();
				break;
			}
		}
		
	
	}
}
