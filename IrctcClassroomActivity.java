package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IrctcClassroomActivity {

	public static void main(String[] args) throws InterruptedException {
		//Chrome driver setup
		WebDriverManager.chromedriver().setup();
		//Open browser
		ChromeDriver driver = new ChromeDriver();
		//maximise window
		driver.manage().window().maximize();
		//implicit wait for 30 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//open the exact webpage by providing url
		driver.get("https://www.irctc.co.in/nget/train-search");
		//Click OK on the sweet alert
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		//get the current window handle
		String window = driver.getWindowHandle();
		//Click on the menu button on the left top corner
		driver.findElement(By.xpath("//div[@class='h_menu_drop_button hidden-xs']//i")).click();
		//Click on flights
		driver.findElement(By.xpath("//label[text()='FLIGHTS']")).click();
		//opens another window , so get the window handles as a SET
		Set<String> windowHandles = driver.getWindowHandles();
		//convert it to LIST in order to traverse through the windows
		List<String> windows = new ArrayList<String>(windowHandles);
		//switch to flight window
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
		driver.close();
		//switch back to train window with below 2 options		
		//driver.switchTo().window(window);
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getTitle());
		driver.close();

	}

}
