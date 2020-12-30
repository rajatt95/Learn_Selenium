package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected static WebDriver preSetup() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		/* driver.get("http://www.way2automation.com/way2auto_jquery/index.php"); */
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

}
