package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestKeyBoardEvents {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		pressEnter(driver);

		driver.findElement(By.id("identifierId")).sendKeys("xyz@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]")).click();

		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "a")).sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();

		/*
		 * new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "a")).perform(); new
		 * Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "c")).perform();
		 */ driver.findElement(By.id("identifierId")).click();
		new Actions(driver).sendKeys(Keys.chord(Keys.CONTROL, "v")).perform();

		System.out.println("Success");
		Thread.sleep(6000);
		driver.quit();
	}

	private static void pressEnter(WebDriver driver) {
		driver.findElement(By.id("identifierId")).sendKeys("xyz@gmail.com");
		/*
		 * driver.findElement(By.id("identifierId")).sendKeys(Keys.ENTER);
		 */

		new Actions(driver).sendKeys(Keys.ENTER).perform();
	}

}
