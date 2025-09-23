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

public class TC26_DragandDropAction 
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
	public void DargDropAction()
	{
		WebElement draggable_ele = driver.findElement(By.id("draggable"));
		WebElement droppable_ele = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(draggable_ele, droppable_ele).perform();
		System.out.println("After Drag & Drop action completion confirmation message --> "+driver.findElement(By.id("droppable")).getText());
	}
	
}
