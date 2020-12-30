package testcases;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHandlingCalendars {

	static int currentDay = 0, currentMonth = 0, currentYear = 0;

	static int targetDay = 0, targetMonth = 0, targetYear = 0;

	static int jumpMonthsBy = 0;

	static boolean increment = true;

	public static void main(String[] args) throws InterruptedException {
		setTargetDate();

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		/* driver.get("http://way2automation.com/way2auto_jquery/datepicker.php"); */
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		// driver.findElement(By.xpath("//button[contains(text(),'Try it')]")).click();

		driver.findElement(By.id("datepicker")).click();

		for (int i = 0; i < jumpMonthsBy; i++) {
			if (increment) {
				driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/a[1]")).click();
				;
			} else {
				driver.findElement(By.xpath("//body/div[@id='ui-datepicker-div']/div[1]/a[1]")).click();
				;
			}
		}

		driver.findElement(By.linkText(Integer.toString(targetDay))).click();

		Thread.sleep(3000);
		driver.quit();

	}

	private static void setTargetDate() {
		String dateToSet = "26/6/2020";

		// Get current date
		getCurrentDateMonthAndYear();
		System.out.println(currentDay + "  " + currentMonth + "  " + currentYear);
		System.out.println("--------");

		// Get target date
		getTargetDateMonthAndYear(dateToSet);
		System.out.println(targetDay + "  " + targetMonth + "  " + targetYear);
		System.out.println("--------");

		// Get jump month
		calculateHomManyMonthsToJump();
		System.out.println(jumpMonthsBy);
		System.out.println(increment);
	}

	public static void calculateHomManyMonthsToJump() {

		if ((targetMonth - currentMonth) > 0) {
			jumpMonthsBy = targetMonth - currentMonth;
		} else {
			jumpMonthsBy = currentMonth - targetMonth;
			increment = false;
		}

	}

	public static void getCurrentDateMonthAndYear() {
		Calendar cal = Calendar.getInstance();
		currentDay = cal.get(Calendar.DAY_OF_MONTH);
		currentMonth = cal.get(Calendar.MONTH) + 1;
		currentYear = cal.get(Calendar.YEAR);

	}

	public static void getTargetDateMonthAndYear(String dateString) {

		int firstIndex = dateString.indexOf("/");
		int lastIndex = dateString.lastIndexOf("/");

		String day = dateString.substring(0, firstIndex);
		targetDay = Integer.parseInt(day);

		String month = dateString.substring(firstIndex + 1, lastIndex);
		targetMonth = Integer.parseInt(month);

		String year = dateString.substring(lastIndex + 1, dateString.length());
		targetYear = Integer.parseInt(year);

	}

}
