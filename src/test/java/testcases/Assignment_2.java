package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://way2automation.com/way2auto_jquery/index.php");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("(//input[contains(@name,'name')])[2]")).sendKeys("Rajat");
		Thread.sleep(3000);
		selectValueFromCountryDropdown(driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[contains(@value,'Submit')])[2]")).click();

		System.out.println("Title : " + driver.getTitle());
		Thread.sleep(3000);
		driver.quit();
	}

	private static void selectValueFromCountryDropdown(WebDriver driver) {
		WebElement dropdown = driver.findElement(By.name("country"));
		Select select = new Select(dropdown);

		select.selectByValue("India");
	}

}
