
package testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/*import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

*/public class TestScreenshotUsingAshot {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("http:www.way2automation.com/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Here 100 is a scrollTimeOut in milliseconds, For every 100 ms the
		// screen will be scrolled and captured
		/*
		 * Screenshot screenshot = new
		 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
		 * .takeScreenshot(driver);
		 */
		// To save the screenshot in desired location
		/*
		 * ImageIO.write(screenshot.getImage(), "PNG", new
		 * File(System.getProperty("user.dir") +
		 * "\\screenshots_UsingAshot\\fullpagescrn.png"));
		 */
		System.out.println("Success");

		Thread.sleep(3000);
		driver.quit();

	}
}
