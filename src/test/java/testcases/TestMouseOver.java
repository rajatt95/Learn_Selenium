package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMouseOver {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.name("q")).sendKeys("Way2Automation");
		driver.findElement(By.name("btnK")).click();

		driver.findElement(By.xpath("(//span[contains(text(),'Way2Automation')])[1]")).click();

		WebElement menu = driver.findElement(By.xpath("//a[contains(text(),'Resources')]"));
		new Actions(driver).moveToElement(menu).perform();
		
		driver.findElement(By.xpath("//a[contains(text(),'Practice site 1')]")).click();

		System.out.println("Success");
		Thread.sleep(3000);
		driver.quit();

	}
}
