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

public class TC27_SliderAction 
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
	public void test_slider()
	{
		WebElement slider_ele = driver.findElement(By.id("slider-range"));
		//System.out.println("Location of Slider through X - axis before performing operations "+slider_ele.getLocation().getX());
		//System.out.println("Location of Slider through Y - axis before performing operations "+slider_ele.getLocation().getY());
		
		WebElement pricerange = driver.findElement(By.id("amount"));
		System.out.println("Value of price range before moving slider is "+pricerange.getAttribute("value"));
		
		WebElement min_slider = driver.findElement(By.xpath("//*[@style='left: 15%;']"));
		WebElement max_slider = driver.findElement(By.xpath("//*[@style='left: 60%;']"));
		
		Actions act = new Actions(driver);
		act.dragAndDropBy(min_slider, 50, 0).perform();
		act.dragAndDropBy(max_slider, -30, 0).perform();
		
		//System.out.println("Location of Slider through X - axis after performing operations "+slider_ele.getLocation().getX());
		//System.out.println("Location of Slider through Y - axis after performing operations "+slider_ele.getLocation().getY());
		
		System.out.println("Value of price range after moving slider is "+pricerange.getAttribute("value"));
		
		
	}
}
