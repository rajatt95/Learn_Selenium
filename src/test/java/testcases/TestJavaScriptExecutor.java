package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestJavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// iframeResult - ID of the Frame; we can ID/name/index
		driver.switchTo().frame("iframeResult");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("myFunction()");
		js.executeScript("arguments[0].style.border='3px solid red'", driver.findElement(By.id("mySubmit")));

		System.out.println("Success");

		Thread.sleep(6000);
		driver.quit();
	}

}
