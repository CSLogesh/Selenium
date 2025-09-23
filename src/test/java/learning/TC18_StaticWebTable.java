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

public class TC18_StaticWebTable 
{

WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://vinothqaacademy.com/webtable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

	@Test
	public void test_staticwebtables()
	{
		List<WebElement> rows = driver.findElements(By.xpath("//*[@id='myTable']/tbody/tr"));
		System.out.println("Total number of rows available in the table is "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//*[@id='myTable']/thead/tr/th"));
		System.out.println("Total number of columns available in the webtable is "+columns.size());
		
		// Read all data from the table 
		
		for(int i=1;i<=rows.size();i++)
		{
			for(int j=1;j<=columns.size();j++)
			{
				String tabledata = driver.findElement(By.xpath("//*[@id='myTable']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(tabledata+"  ");
			}
			
			System.out.println();
		}
	}
	
}
