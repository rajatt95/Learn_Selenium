package testcases;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestFindingElements {

	public static void main(String[] args) {
		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver();
		 */

		WebDriverManager.operadriver().setup();
		WebDriver driver = new OperaDriver();

		driver.get("https://www.gmail.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Explicit wait
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 5);
		 * wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(
		 * "identifierId")));
		 */

		// Fluent wait
		/*
		 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30,
		 * TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS).
		 * withMessage("UserDefined message: Timed out after 30 seconds")
		 * .ignoring(NoSuchElementException.class);
		 */
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("UserDefined message: Timed out after 30 seconds")
				.ignoring(NoSuchElementException.class);
		
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("identifierId")));
		driver.findElement(By.id("identifierId")).sendKeys("raj85@gmail.com");
		driver.findElement(By.className("VfPpkd-RLmnJb")).click();
		driver.findElement(By.name("password")).sendKeys("some password");

		driver.quit();

	}

}