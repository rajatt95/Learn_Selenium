package testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class TestCheckBoxes extends TestBase {

	static WebDriver driver = TestBase.preSetup();

	public static void main(String[] args) throws InterruptedException {

		driver.get("http://www.tizag.com/htmlT/htmlcheckboxes.php");

		// clickOnCheckBoxesOneByOne();

		// clickOnCheckBoxesUsingForEachLoop();

		clickOnCheckBoxesUsingList_CheckBoxesInsideParticularBlock();
		System.out.println("End");
		Thread.sleep(5000);
		driver.quit();
	}

	private static void clickOnCheckBoxesUsingList_CheckBoxesInsideParticularBlock() {
		WebElement particularBlock = driver
				.findElement(By.xpath("/html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]"));
		List<WebElement> listOfCheckBoxesInsideBlock = particularBlock.findElements(By.name("sports"));
		System.out.println("Total checkboxes inside Block are: " + listOfCheckBoxesInsideBlock.size());
		for (WebElement checkBox : listOfCheckBoxesInsideBlock) {
			checkBox.click();
		}
	}

	private static void clickOnCheckBoxesUsingForEachLoop() {
		for (int checkBoxCount = 1; checkBoxCount <= 4; checkBoxCount++) {
			driver.findElement(By.xpath("//div[4]/input[" + checkBoxCount + "]")).click();

		}
	}

	private static void clickOnCheckBoxesOneByOne() {
		System.out.println("Click on all checkboxes - 1 line for 1 checbox");
		driver.findElement(By.xpath("//div[4]/input[1]")).click();
		driver.findElement(By.xpath("//div[4]/input[2]")).click();
		driver.findElement(By.xpath("//div[4]/input[3]")).click();
		driver.findElement(By.xpath("//div[4]/input[4]")).click();
	}

}
