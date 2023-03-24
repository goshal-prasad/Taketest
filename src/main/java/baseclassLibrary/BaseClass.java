package baseclassLibrary;
import java.awt.Robot;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	private static WebDriverWait wait;
	public static String projectFolder = System.getProperty("user.dir");
	public static String excelPath="/TestData/TestResult.xlsx";

	@BeforeSuite	
	public void resetDriver() {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get("https://www.cdc.gov/prediabetes/takethetest/");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void closeDriver() {
		try {			
			driver.quit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForElementToLoad(WebElement element, long seconds) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("waited for 30 seconds..");
		}
	}
	
	public void singleKeyPress(int keyEvent) {
		try {
			Robot robot = new Robot();
			robot.keyPress(keyEvent);
			robot.keyRelease(keyEvent);
			robot.delay(200);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
