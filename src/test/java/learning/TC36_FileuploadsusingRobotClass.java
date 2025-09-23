package learning;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC36_FileuploadsusingRobotClass 
{

	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
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
	public void test_uploadusingrobot() throws Exception
	{
		WebElement element = driver.findElement(By.id("uploadFile"));
		element.click();
		System.out.println("element clicked...");
				
		Robot rb = new Robot();
		rb.delay(2000);
		
		StringSelection ss = new StringSelection("C:\\Users\\eswar\\OneDrive\\Desktop\\Demo.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println(driver.findElement(By.id("uploadFile")).getText());
		//System.out.println("File has been uploaded successfully through robot class...");
		
	}
	
}
