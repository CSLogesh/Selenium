package learning;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC32_JavascriptExecutorMethods 
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
	
	/*
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	*/
	
	@Test
	public void test_jsmethods()
	{
		WebElement ele = driver.findElement(By.xpath("//*[text()='GUI Elements']"));
		WebElement namebox = driver.findElement(By.id("name"));
		WebElement header = driver.findElement(By.xpath("//*[text()='Colors:']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','Logueswar CS')", namebox);
		//js.executeScript("arguments[0].click();", ele);
		//js.executeScript("arguments[0].scrollIntoView();", header);
		js.executeScript("window.scrollBy(0,document.body.scroll.Height)");
		js.executeScript("document.body.style.zoom='40%'");
		
	}
}

