package testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSliders {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/slider/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/*
		 * WebElement mainSlider = driver.findElement(By.id("slider")); int width =
		 * mainSlider.getSize().getWidth(); System.out.println("Width of main Slider: "
		 * + width);
		 */
		/*
		 * WebElement slider = driver.findElement( By.xpath(
		 * "//body/div[@id='container']/div[@id='content-wrapper']/div[1]/div[1]/iframe[1]"
		 * ));
		 */

		listDownTheFramesCount(driver);
		/* driver.switchTo().frame(0); */
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		WebElement slider = driver.findElement(By.xpath("//body/div[@id='slider']/span[1]"));
		// 400 - X-Axis, 0 - Y-Axis
		new Actions(driver).dragAndDropBy(slider, 400, 0).perform();

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
