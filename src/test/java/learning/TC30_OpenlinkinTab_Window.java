package learning;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC30_OpenlinkinTab_Window 
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
	public void test_openweblink()
	{
		WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
		newWindow.get("https://www.hyrtutorials.com/p/basic-controls.html");
		Set<String> windowHandles = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(windowHandles);
		String atp = list.get(0);
		String hyr = list.get(1);		
		System.out.println("Current Window  --> "+driver.getTitle());
		driver.switchTo().window(atp);		
		System.out.println("Another Window  --> "+driver.getTitle());
		
		
	}
}
