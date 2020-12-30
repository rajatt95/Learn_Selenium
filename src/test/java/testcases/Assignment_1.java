package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("way2automation");
		driver.findElement(By.name("btnK")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Way2Automation')])[1]")).click();
		

		List<WebElement> listOfAnchorTags = driver.findElements(By.tagName("a"));
		for (WebElement link : listOfAnchorTags) {
			System.out.println("Text of Link: " + link.getText() + "------and the URL : " + link.getAttribute("href"));
		}
		System.out.println("Total links count: " + listOfAnchorTags.size());

		// Clicking on the 1st link
		// listOfAnchorTags.get(0).click();
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Current title: " + driver.getTitle());

		Thread.sleep(3000);
		driver.quit();
	}

}
