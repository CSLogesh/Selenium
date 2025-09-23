package learning;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class TC13_BrokenLinks 
{
WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	@SuppressWarnings("deprecation")
	public void test_brokenlinks() throws Exception
	{
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links available in the webpage is "+links.size());
		
		int brokenlink = 0;
		int validlink = 0 ;
		
		for(WebElement link : links)
		{
		
			String hrefvalue = link.getAttribute("href");
			
			if(hrefvalue.isEmpty() || hrefvalue==null)
			{
				System.out.println("Cant validate if its broken link or not as it doesnot have any href value attached to it...");
				continue;
			}
			try
			{
				{
					URL url = new URL(hrefvalue);
					HttpURLConnection connection = (HttpURLConnection) url.openConnection();
					connection.connect();
					
					if(connection.getResponseCode()>=400)
					{
						System.out.println(hrefvalue + " is a broken link ....");
						brokenlink++;
					}
					else
					{
						System.out.println(hrefvalue+ " is a valid link.....");
						validlink++;
					}
				}
			}
			catch(Exception e) 
			{
				
			}
		}
		
		System.out.println("Total number of broken links in the webpage is "+brokenlink);
		System.out.println("Total number of valid links in the webpage is "+validlink);
	}

	
}
