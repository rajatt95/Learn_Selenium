package eventListeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.internal.EventFiringMouse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class move_movement {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver webdriver = new ChromeDriver();

		EventFiringWebDriver driver = new EventFiringWebDriver(webdriver);

		weblisteners listner = new weblisteners();

		driver.register(listner);

		EventFiringMouse mouse = new EventFiringMouse(driver, listner);

		driver.navigate().to("http://google.com");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		Thread.sleep(3000L);

		// Moving to the Gmail using co-ordinates
		Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='gb_23']/span[2]"));

		Coordinates cord = (Coordinates) hoverItem.getCoordinates();

		try {

			mouse.mouseMove(cord);
		} catch (Throwable t) {

		}

		System.out.println("Success");
		Thread.sleep(3000);
		driver.quit();
	}
}
