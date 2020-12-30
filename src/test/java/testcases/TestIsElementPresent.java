package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class TestIsElementPresent extends TestBase {

	static WebDriver driver = TestBase.preSetup();

	// protected static boolean isElementPresent(String locator) {
	protected static boolean isElementPresent(By by) {
		// Logic #1
		/*
		 * try { driver.findElement(By.xpath(locator)); return true; } catch (Exception
		 * exception) { return false; }
		 */

		// Logic #2
		/*
		 * int sizeOfTheList = driver.findElements(By.xpath(locator)).size(); //
		 * sizeOfTheList == 0 - means there is no element in the list if (sizeOfTheList
		 * == 0) { return false; } else { return true; }
		 */

		int sizeOfTheList = driver.findElements(by).size();
		// sizeOfTheList == 0 - means there is no element in the list
		if (sizeOfTheList == 0) {
			return false;
		} else {
			return true;
		}
	}

	public static void main(String[] args) throws InterruptedException {

		/*
		 * System.out.println(isElementPresent("//*[@id='www-wikipedia-org']"));
		 * System.out.println(isElementPresent("dnaskndkasnjdb"));
		 */

		System.out.println(isElementPresent(By.xpath("//*[@id='www-wikipedia-org']")));
		System.out.println(isElementPresent(By.cssSelector("dnaskndkasnjdb")));

		// System.out.println(driver.findElement(By.id("www-wikipedia-org")).isDisplayed());
		// System.out.println(driver.findElement(By.xpath("dakjdfjakfpan")).isDisplayed());

		Thread.sleep(5000);
		driver.quit();
	}

}
