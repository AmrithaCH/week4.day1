package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlingAssn1 {

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
		driver.get("http://leaftaps.com/opentaps/control/login");
		//login page
		driver.findElement(By.xpath("//input[contains(@id,'user')]")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[contains(@id,'pass')]")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[contains(@class,'Submit')]")).click();
		//CRM/SFA page
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on contacts button
		driver.findElement(By.linkText("Contacts")).click();
		//Click on Merge Contacts
		driver.findElement(By.partialLinkText("Merge Contacts")).click();
		//Click on From widget
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a/img")).click();
		//get window handles
		Set<String> windowsFrom = driver.getWindowHandles();
		List<String> windowsFrom1 = new ArrayList<String>(windowsFrom);
		//move to from widget window
		driver.switchTo().window(windowsFrom1.get(1));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first')]/div/a")).click();
		//come back to Merge contacts
		driver.switchTo().window(windowsFrom1.get(0));
		System.out.println(driver.getTitle());
		//Click on To Widget
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a/img")).click();
		//get window handles
		Set<String> windowsTo = driver.getWindowHandles();
		List<String> windowsTo1 = new ArrayList<String>(windowsTo);
		//move to To widget window
		driver.switchTo().window(windowsTo1.get(1));
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-col x-grid3-cell x-grid3-td-partyId x-grid3-cell-first')]/div/a)[2]")).click();
		//come back to Merge contacts
		driver.switchTo().window(windowsTo1.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("Merge")).click();
		// accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//get title of page
		System.out.println(driver.getTitle());


	}

}
