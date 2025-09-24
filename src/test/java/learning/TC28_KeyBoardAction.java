package learning;

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
		driver.get("https://text-compare.com/");
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
		WebElement textbox1 = driver.findElement(By.id("inputText1"));
		WebElement textbox2 = driver.findElement(By.id("inputText2"));
		
		textbox1.sendKeys("Welcome to Selenium Keyboard Actions program.....");
		
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL);
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("c");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		act.sendKeys(Keys.TAB);
		act.perform();
		
		act.keyDown(Keys.CONTROL);
		act.sendKeys("v");
		act.keyUp(Keys.CONTROL);
		act.perform();
		
		if(textbox1.getAttribute("value").equals(textbox2.getAttribute("value")))
		{
			System.out.println("Text has been copied successfully...");
		}
		else
		{
			System.out.println("Text mismatch , copy action using keyboard keys failed...");
		}
		
	}
}
