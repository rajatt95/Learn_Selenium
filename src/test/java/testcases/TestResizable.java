package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestResizable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		listDownTheFramesCount(driver);
		/* driver.switchTo().frame(0); */
		WebElement frame = driver.findElement(By.className("demo-frame"));
		
		driver.switchTo().frame(frame);
		WebElement resizable = driver.findElement(By.xpath("//body/div[@id='resizable']/div[3]"));
		new Actions(driver).dragAndDropBy(resizable, 400, 400).perform();

		System.out.println("Success");
		Thread.sleep(3000);
		driver.quit();
	}

	private static void listDownTheFramesCount(WebDriver driver) {
		// To get all the frames in the Page
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames: " + frames.size());
		for (WebElement frame : frames) {
			System.out.println("IDs of frame: " + frame.getAttribute("id"));
		}
	}

}
