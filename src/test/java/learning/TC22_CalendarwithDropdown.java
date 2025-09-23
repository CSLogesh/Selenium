package learning;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC22_CalendarwithDropdown 
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
	public void test_calendarwithdropdown()
	{
		Scanner sc = new Scanner(System.in);
		String requiredmonth=sc.next(); // Dec
		String requiredyear=sc.next(); // 2021
		String requireddate=sc.next(); // 4
		
		driver.findElement(By.id("txtDate")).click();
		WebElement monthdrp = driver.findElement(By.xpath("//*[@class='ui-datepicker-month']"));
		Select select = new Select(monthdrp);
		select.selectByVisibleText(requiredmonth);
		
		WebElement yeardrp = driver.findElement(By.xpath("//*[@class='ui-datepicker-year']"));
		Select select2 = new Select(yeardrp);
		select2.selectByVisibleText(requiredyear);
		
		List<WebElement> alldates = driver.findElements(By.xpath("//*[@class='ui-datepicker-calendar']/tbody/tr/td"));
		
		for(WebElement date :alldates)
		{
			if(date.getText().equalsIgnoreCase(requireddate))
			{
				date.click();
				break;
			}
		}
		
		System.out.println("Selected date using selenium is in the format of dd/mm/yyyy --> "+driver.findElement(By.id("txtDate")).getAttribute("value"));
	}
	

}
