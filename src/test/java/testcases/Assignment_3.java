package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_3 {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http://timesofindia.indiatimes.com/poll.cms");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String text = driver.findElement(By.id("mathq2")).getText();
		System.out.println("Text: " + text);

		int count = 0;

		// Counts each character except space
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) != ' ')
				count++;
		}

		System.out.println("Total number of characters in a string: " + count);
		String first = text.substring(0, 1);
		String second = text.substring(4, 5);
		String operator = text.substring(2, 3);

		System.out.println("First: " + first);
		System.out.println("Operator: " + operator);
		System.out.println("Second: " + second);

		Thread.sleep(3000);
		driver.quit();
	}

}
