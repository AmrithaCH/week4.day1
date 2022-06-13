package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssn3 {

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
		driver.get("https://www.amazon.in");
		//enter one plus 9 pro in search box
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 9 pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		//get the price of first product
		String price = driver.findElement(By.className("a-price-whole")).getText();
		System.out.println(price);
		//customer ratings 
		Thread.sleep(2000);
		String rating = driver.findElement(By.xpath("//a[contains(@href,'customerReviews')]/span")).getText();
		System.out.println(rating);
		
		// click on the first image link 
		driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']//img")).click();
		
		//get window handles and switch to first link
		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);
		driver.switchTo().window(windowsList.get(1));
		System.out.println(driver.getTitle());
		
		//get price of the mobile
		//String price = driver.findElement(By.xpath("//span[text()='Without Exchange']/following::span[@class='a-color-price']/span[@class='currencyINR']")).getText();
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//check cart subtotal
		Thread.sleep(4000);
		String cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println(cart);
		
		if(cart.contains(price))
		{
			System.out.println("pass");
		
		}
		else
		{
			System.out.println("fail");
		}
		
		
		
		driver.quit();

	}

}
