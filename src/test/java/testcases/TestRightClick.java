package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRightClick {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://deluxe-menu.com/popup-mode-sample.html");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement img = driver.findElement(By.xpath("//tbody/tr[1]/td[3]/p[2]/img[1]"));
		new Actions(driver).contextClick(img).perform();

		driver.findElement(By.xpath("//td[@id='dm2m1i1tdT']")).click();
		/*
		 * driver.findElement(By.xpath("//td[@id='dm2m2i4tdT']")).click();
		 * driver.findElement(By.xpath("//td[@id='dm2m4i0tdT']")).click();
		 */
		System.out.println("Success");
		Thread.sleep(3000);
		driver.quit();
	}

}
