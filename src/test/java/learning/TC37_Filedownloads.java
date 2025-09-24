package learning;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC37_Filedownloads 
{
	WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		String loc = new String(System.getProperty("user.dir")+"\\Downloads");
		ChromeOptions options = new ChromeOptions();
		HashMap<String, String> preferences = new HashMap<String, String>();
		preferences.put("download.default_directory", loc);
		options.setExperimentalOption("prefs", preferences);
		driver = new ChromeDriver(options);
		driver.get("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	@Test
	public void test_filedownload()
	{
		driver.findElement(By.id("downloadButton")).click();
	}
}
