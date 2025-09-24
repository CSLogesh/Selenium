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
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test
	public void test_jsmethods() throws Exception
	{
	
		
		WebElement tabslogo = driver.findElement(By.xpath("//*[text()='Tabs']"));
		WebElement elementslink = driver.findElement(By.xpath("//*[text()='GUI Elements']"));
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		
		js.executeScript("arguments[0].style.border='3px solid red'", tabslogo); // drawborder
		js.executeScript("arguments[0].click();", elementslink); // click using javascriptexecutor
		js.executeScript("history.go(0)"); // refresh page
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)"); // scrolldown
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); // scrollup
		js.executeScript("document.body.style.zoom='150%'"); // pagezoom 
		
		String title = js.executeScript("return document.title").toString(); // gettitle using js
		System.out.println("title of the webpage is -->"+title);
	}
}

