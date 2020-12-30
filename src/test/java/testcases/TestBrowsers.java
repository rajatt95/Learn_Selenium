package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBrowsers {

	private static final String DRIVER_PATH = "C:\\Users\\rajat.verma\\Desktop\\Work in Local machine\\new_LearningWorkspace\\Selenium WebDriver Training with Java and Many Live Projects\\SeleniumThree\\Drivers\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* DesiredCapabilities */

		/*
		 * System.setProperty("webdriver.gecko.driver", DRIVER_PATH+"geckodriver.exe");
		 * FirefoxDriver driver = new FirefoxDriver();
		 */

		/*
		 * System.setProperty("webdriver.chrome.driver", DRIVER_PATH +
		 * "chromedriver.exe");
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		/*
		 * System.setProperty("webdriver.edge.driver", DRIVER_PATH +
		 * "msedgedriver.exe");
		 */
		/*
		 * WebDriverManager.edgedriver().setup(); EdgeDriver driver = new EdgeDriver();
		 */

		// Opera works fine on MAC
		/*
		 * System.setProperty("webdriver.opera.driver", DRIVER_PATH +
		 * "operadriver.exe"); OperaDriver driver = new OperaDriver();
		 */
		/*
		 * System.setProperty("webdriver.ie.driver", DRIVER_PATH +
		 * "IEDriverServer.exe"); InternetExplorerDriver driver = new
		 * InternetExplorerDriver();
		 */

		driver.get("http://www.way2automation.com/");
		System.out.println("Page Title: " + driver.getTitle());

		// close - this will close the current window of the browser
		// current browser window
		driver.close();

		// quit - this will quit the entire session
		// current browser window + all related browsers running in the same session
		driver.quit();

	}

}