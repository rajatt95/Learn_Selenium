package eventListeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test_listeners {

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

		driver.navigate().to("http://google.com");
		driver.manage().window().maximize();
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"fsr\"]/a[2]")).click();
		Thread.sleep(2000L);
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@id=\"fsettl\"]")).click();
		Thread.sleep(2000L);
		driver.navigate().back();
		Thread.sleep(2000L);
		driver.navigate().forward();

		System.out.println("Success");

		Thread.sleep(3000);
		driver.quit();

	}

}
