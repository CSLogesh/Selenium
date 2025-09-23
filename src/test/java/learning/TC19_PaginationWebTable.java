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

public class TC19_PaginationWebTable 
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
	public void test_paginationwebtable()
	{
		List<WebElement> rowsinapage = driver.findElements(By.xpath("//*[@id='productTable']/tbody/tr"));
		System.out.println("Total number of rows available in a page is "+rowsinapage.size());
		
		List<WebElement> columnsinapage = driver.findElements(By.xpath("//*[@id='productTable']/thead/tr/th"));
		System.out.println("Total number of columns available in a page is "+columnsinapage.size());
		
		List<WebElement> noofpages = driver.findElements(By.xpath("//*[@id='pagination']/li/a"));
		System.out.println("Total number of pages available in the table is "+noofpages.size());
		
		for(int p=1;p<=noofpages.size();p++)
		{		
			if(p>1)
			{
				WebElement activepage = driver.findElement(By.xpath("//*[@id='pagination']/li/a[text()='"+p+"']"));
				activepage.click();
			}		
			
			for(int r=1;r<=rowsinapage.size();r++) 
			{
				for(int c=1;c<=columnsinapage.size();c++)
				{
					String tabledata = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr["+r+"]/td["+c+"]")).getText();
					System.out.print(tabledata+" ");		
				}
				
				System.out.println();

			}
						
		}
	}
	

	
}
