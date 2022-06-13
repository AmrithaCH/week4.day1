package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafgroundWindowsAssn2 {

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
		driver.get("http://www.leafground.com/pages/Window.html");
		
		String homePageTitle = driver.getTitle();
		System.out.println("Home page title: "+homePageTitle);
		String homePageWindowHandle = driver.getWindowHandle();

		//click on home page

		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);

		driver.switchTo().window(windowsList.get(1));
		String titleOfNewWindow = driver.getTitle();
		System.out.println("Title of first button click window: "+titleOfNewWindow);
		driver.close();

		driver.switchTo().window(homePageWindowHandle);
		if(driver.getTitle().equals(homePageTitle))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}

		
		//Number of opened windows
		
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> windows1 = driver.getWindowHandles();
		List<String> windowsList1 = new ArrayList<String>(windows1);
		int size = windowsList1.size();
		System.out.println("Number of windows: "+size);
		
		
		//Close all except this window
		
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		Set<String> windows2 = driver.getWindowHandles();
		List<String> windowsList2 = new ArrayList<String>(windows2);
		
		for(int i=1; i<windowsList2.size(); i++)
		{
			driver.switchTo().window(windowsList2.get(i));
			driver.close();
		}
		driver.switchTo().window(windowsList2.get(0));
		
		// Wait for 5 seconds
		
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		Set<String> windows3 = driver.getWindowHandles();
		System.out.println(windows3.size());
		

		//quit browser
		driver.quit();
	}

}

