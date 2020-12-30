package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestDragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		/*
		 * WebDriverManager.chromedriver().setup(); WebDriver driver = new
		 * ChromeDriver();
		 * driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 * 
		 * WebElement draggable = driver.findElement(By.id("draggable")); WebElement
		 * droppable = driver.findElement(By.id("droppable"));
		 * 
		 * Actions action = new Actions(driver); action.dragAndDrop(draggable,
		 * droppable).perform();
		 */

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		// driver.get("https://jqueryui.com/droppable/");
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// WebElement draggable = driver.findElement(By.id("draggable"));
		
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(draggable, droppable).perform();
		;
		System.out.println("Success");
		Thread.sleep(3000);
		driver.quit();

	}

}
