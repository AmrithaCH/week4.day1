package week4.day1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFramesAssn {

	public static void main(String[] args) {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//Open browser
		ChromeDriver driver = new ChromeDriver();
		//maximise window
		driver.manage().window().maximize();
		//implicit wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open the exact webpage by providing url
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		//switch to first inner frame and key in input
		driver.switchTo().frame("frame1");
		driver.findElement(By.tagName("input")).sendKeys("Hello");
		
		//switch to nested frame and check the box
		driver.switchTo().frame("frame3");
		boolean a = driver.findElement(By.xpath("//input[@id='a']")).isSelected();
		if(a==true)
		{
			System.out.println("Already selected");
		}
		else 
		{
			driver.findElement(By.xpath("//input[@id='a']")).click();
			System.out.println("Selected now");
		}
		
		//switch out from the nested frames and move to frame containing drop dowm
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		
		WebElement dropdown = driver.findElement(By.id("animals"));
		Select dd = new Select(dropdown);
		
		dd.selectByValue("babycat");
		List<WebElement> options = dd.getAllSelectedOptions();
		
		for(int i=0; i<options.size(); i++)
		{
			System.out.println(options.get(i).getText());
		}
		
		
		driver.switchTo().defaultContent();
	
	}

}
