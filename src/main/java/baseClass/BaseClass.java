package baseClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pom_HomePage.LoginPage;
import utilities.BrowserLib;
import utilities.CaptureScreenshot;
import utilities.ExtentReportManager;
import utilities.ReadPropertyFile;

public class BaseClass {
	// 1. WebDriver-Done
	public static WebDriver driver;
	public static WebDriverWait wait;

	// 2. Properties-Done
	public static String propertyFilePath = System.getProperty("user.dir") + "//src//test//resources//testConfig//";
	public ReadPropertyFile urlPropertyFile = new ReadPropertyFile(propertyFilePath + "URL.properties");


	// 3. ExtentReports-Done
	public ExtentReports reports = ExtentReportManager.getInstance();
	public static ExtentTest test;


	// 4. AjaxElementLocator
	public AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);

	@BeforeSuite
	public void setUp() {
		if (driver == null) {
			Reporter.log("Driver is null. Hence creating driver instance");
			driver = BrowserLib.setDriver(urlPropertyFile.getProp("browser"));
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(urlPropertyFile.getProp("url"));
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
		Reporter.log("All browsers closed!!!");
	}

	@BeforeTest
	public void login() throws InterruptedException {
		try {
			LoginPage page = new LoginPage();
			page.login();
			CaptureScreenshot.captureScreenshot(driver, "Login");
		} catch (Exception e) {
				
		}
	}

	@AfterTest
	public void logout() {
		driver.findElement(By.xpath("//img[@alt='Sign Out']")).click();
		//Unless you flush the reports, no extent report will be generated
		reports.flush();
	}

	
	
	public void click(WebElement ele) {
		ele.click();
		test.info("Clicked on-"+ele);
	}
	
	public void type(WebElement ele, String value) {
		ele.sendKeys(value);
		test.info("Value entered in-"+ele+"-Value="+value);
	}
}
