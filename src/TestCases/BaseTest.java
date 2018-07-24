package TestCases;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import globals.Constants;

import globals.Globals;

public class BaseTest extends Globals {

	public static String  directoryPath;
	public static ExtentReports report ;
	public static	ExtentTest logger;
	//ExtentReports report_To_Pass;
	public static	String htmlReportPath;

	@BeforeTest
	@Parameters("browser")
	public void Extent_Report_Setting(String browser) throws Exception {
		try{
			directoryPath = System.getProperty("user.dir");
			//D:\FilesSoftwares\Rashmi\MobileWorkspace\DummyHTMLScript\DummyHTMLScript
			if(browser.equalsIgnoreCase("Chrome")){
				htmlReportPath = directoryPath + "\\test-output\\Desire_CHROME_HTML_Report.html";
			}else if(browser.equalsIgnoreCase("firefox")){
				htmlReportPath = directoryPath + "\\test-output\\Desire_FIREFOX_HTML_Report.html";
			}
			report =   new ExtentReports(htmlReportPath);
			//report.addSystemInfo("Environment","Environment Name")
			report.loadConfig(new File("extent-config.xml")); //Supporting File for report Reporting
			report.addSystemInfo("Environment","QA-Sanity");

			//report_To_Pass = report;




		}catch(Exception e)
		{
			logger.log(LogStatus.INFO , e);
			Globals.ERtakeScreenshot(driver, "CaptureError", "BeforeTest()- ExtentReport_Setting",logger);

		}
	}

	@BeforeClass
	@Parameters("browser")
	public void Browser_URL_SetUP(String browser) throws Exception {
		try{
			logger = report.startTest("BeforeClass - Browser Setting from base class");
			System.setProperty("browser",browser);

			boolean Status =	setUp(report);
			Assert.assertTrue(Status);
		}catch(Exception e)
		{
			logger.log(LogStatus.INFO , e);
			Globals.ERtakeScreenshot(driver, "CaptureError", "BrowserSetting",logger);
			
		}
		browserNav(Constants.Dev_URL);
		logger.log(LogStatus.PASS,"Browser is opened and URL is entered");
	}

	@AfterMethod
	public void getResult(ITestResult result){
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());


		}
		report.endTest(logger);



	}

	/*@AfterClass
	public void DriverClose(){
		driver.close();
	}*/

	@AfterSuite
	public void tearDown()
	{
		report.flush();
	}

}
