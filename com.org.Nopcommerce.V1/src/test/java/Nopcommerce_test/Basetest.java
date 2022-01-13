package Nopcommerce_test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Nopcommerce_pages.Customer_page;
import Nopcommerce_pages.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.Config_Reader_ex;

public class Basetest {

	WebDriver driver;
	Loginpage lp;
	Customer_page cp;
	Config_Reader_ex con;
	Logger log;
	
	  public ExtentReports extent; 
	  public ExtentTest logger; 
	  public ExtentHtmlReporter htmlReporter;
	 
	
	 @Parameters("browser")
	@BeforeClass
	public void lanunchApp(String browser) throws Exception {

	
	   
	     if (browser.equalsIgnoreCase("firefox")) {

	            WebDriverManager.firefoxdriver().setup();
	            driver = new FirefoxDriver();
	        }
	        // Check if parameter passed as 'chrome' from testNG.xml file
	        else if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        }

	        else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        } 
	        else {
	            // If no browser passed throw exception
	            throw new Exception("Browser is not correct");
	        }
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    

		
		log = Logger.getLogger("LT_Logger");
		PropertyConfigurator.configure("./log4j.properties");
		lp = new Loginpage(driver);
		cp = new Customer_page(driver);
		con = new Config_Reader_ex();

		driver.get(con.getAppurl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@BeforeTest
	public void startReport() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/LT1_ExtentReport.html");
		String dateName_number = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		htmlReporter = new ExtentHtmlReporter("./test-output/LT6_NOPComm_ExtentReport" + dateName_number + ".html");
		// Create an object of Extent Reports
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	// This method is to capture the screenshot and return the path of the
	// screenshot.
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src
		// folder
		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			// MarkupHelper is used to display the output in different colors
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
			String screenshotPath = getScreenShot(driver, result.getName());
			// To add it in the extent report
			logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		}
	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	public static String randomestring() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

	@AfterClass
	public void closeApp() throws Exception {
		Thread.sleep(2000);
		driver.quit();

	}
}
