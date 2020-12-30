package testcases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshot {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement googleLogo = driver.findElement(By.id("hplogo"));
		captureElementScreenshot(googleLogo);

		/*
		 * WebElement googleSearchButton = driver.findElement(By.name("btnK"));
		 * captureElementScreenshot(googleSearchButton);
		 */
		captureScreenshotOfVisibleScreen();

		System.out.println("Success");

		Thread.sleep(3000);
		driver.quit();

	}

	private static void captureElementScreenshot(WebElement element) throws IOException {
		System.out.println("..............Element image...............");
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println("Element Screenshot name: " + fileName);
		File screenshot = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(".//screenshot/" + "Element_" + fileName));
	}

	public static void main1(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		/* driver.get("https://www.google.com/"); */

		driver.get("http://www.way2automation.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		/* WebElement element = driver.findElement(By.id("hplogo")); */
		WebElement element = driver.findElement(By.xpath("//header/div[2]/div[1]/div[1]/a[1]/img[1]"));

		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		BufferedImage fullImg = ImageIO.read(screenshot);
		Point point = element.getLocation();

		int elementWidth = element.getSize().getWidth();
		int elementHeight = element.getSize().getHeight();

		BufferedImage elementScreenshot = fullImg.getSubimage(point.getX(), point.getY(), elementWidth, elementHeight);

		ImageIO.write(elementScreenshot, "jpg", screenshot);

		File screenshotLocation = new File(".//screenshot/googleLogo.jpg");
		FileUtils.copyFile(screenshot, screenshotLocation);

		captureScreenshotOfVisibleScreen();
		System.out.println("Success");

		Thread.sleep(3000);
		driver.quit();
	}

	private static void captureScreenshotOfVisibleScreen() throws IOException {
		System.out.println("..............Full Page image...............");
		Date date = new Date();
		String fileName = date.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		System.out.println("Screenshot name: " + fileName);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Copying the taken screenshot to specified path - Root folder - .//
		FileUtils.copyFile(screenshot, new File(".//screenshot/" + fileName));

		/*
		 * File screenshot = ((TakesScreenshot)
		 * driver).getScreenshotAs(OutputType.FILE); // Copying the taken screenshot to
		 * specified path - Root folder - .// FileUtils.copyFile(screenshot, new
		 * File(".//screenshot/error.jpg"));
		 */ }

	private static void listDownTheFramesCount(WebDriver driver) {
		// To get all the frames in the Page
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println("Total frames: " + frames.size());
		for (WebElement frame : frames) {
			System.out.println("IDs of frame: " + frame.getAttribute("id"));
		}
	}

}
