package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebTable {

	public static void main(String[] args) throws InterruptedException {

		// https://money.rediff.com/gainers/bsc/daily/groupa

		// Row count: //table[contains(@class,'dataTable')]/tbody/tr

		// Column count: //table[contains(@class,'dataTable')]/tbody/tr[1]/td

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://money.rediff.com/gainers/bsc/daily/groupa");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		List<WebElement> rowNum = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr"));
		System.out.println("Total rows are : " + rowNum.size());

		List<WebElement> columnNum = driver
				.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr[1]/td"));
		System.out.println("Total columns are : " + columnNum.size());

		for (int rows = 1; rows <= rowNum.size(); rows++) {
			for (int cols = 1; cols < columnNum.size(); cols++) {

				// This will run like :
				// Row #1-Column#1, Row #1-Column#2, Row #1-Column#3, Row #1-Column#4, Row
				// #1-Column#5
				// Row #2-Column#1, Row #2-Column#2, Row #2-Column#3,.....................
				System.out.print(driver
						.findElement(By
								.xpath("//table[contains(@class,'dataTable')]/tbody/tr[" + rows + "]/td[" + cols + "]"))
						.getText() + "     ");
			}
			System.out.println();
		}

		Thread.sleep(3000);
		driver.quit();
	}

}
