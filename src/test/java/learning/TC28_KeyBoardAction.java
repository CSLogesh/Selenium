package learning;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC28_KeyBoardAction 
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
	public void test_KeyboardActions()
	{
		WebElement namebox = driver.findElement(By.id("name"));
		WebElement emailbox = driver.findElement(By.id("email"));
		WebElement phonenobox = driver.findElement(By.id("phone"));
		
		Actions act = new Actions(driver);
		
		act.sendKeys(namebox, "Logueswar").perform();
		act.sendKeys(emailbox, "eswarviji95@gmail.com").perform();
		act.sendKeys(phonenobox, "100").perform();
	}
}
