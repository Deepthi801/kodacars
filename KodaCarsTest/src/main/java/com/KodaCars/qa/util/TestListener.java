package com.KodaCars.qa.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import com.KodaCara.qa.base.TestBase;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener extends TestBase implements  ITestListener {
	  public  ExtentReports extent;
	  public  ExtentTest test;
	  public  ExtentSparkReporter sparkReporter;

	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestStart(ITestResult result) {
		TestLogger.info(getTestMethodName(result) + " Log4: Test starting.");
		Reporter.log(getTestMethodName(result) + " Reporter: Test started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		   test = extent.createTest(result.getName());
	        test.pass("Test Passed Successfully:" + result.getName());
	      
	    	System.out.println("Test Successful");
	    	
		TestLogger.info(getTestMethodName(result) + " Test is success.");
		Reporter.log(getTestMethodName(result) + "Reporter: Test is success.");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		TestLogger.info(getTestMethodName(result) + " Test failed.");
		Reporter.log("onTestFailure" + result.getName());
		

		// add screenshot target folder
		System.out.println(" result.getName " + result.getName());
		String screenshot = GetScreenshot(result.getName(), driver);

		// logs for failed test cases
		ChainTestListener.log(result.getName() + " testcase failed "); 
		System.out.println((result.getName() + " testcase failed "));
		System.out.println((result.getName() + " testcase failed "));
		//screenshot
		ChainTestListener.embed(screenshot, "image/png"); 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		TestLogger.info(getTestMethodName(result) + " Test is skipped.");
		Reporter.log(getTestMethodName(result) + "Reporter: Test is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  ExtentTest failedTest = extent.createTest(result.getName());
	        failedTest.fail("Test Failed:" + result.getThrowable());
	       	System.out.println("Test Failed");
	     	
		TestLogger.info("Test failed: " + getTestMethodName(result));
		Reporter.log("Reporter:Test failed within pass percentage " + getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		   // Initialize the ExtentSparkReporter
		 String reportPath = System.getProperty("user.dir") + "/Reports/ExtReport3.html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
       
        // Optional: Add configuration to the reporter
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Execution Report");
        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
        
        // Attach the reporter to ExtentReports
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // Add system or environment details to the report
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Deepthi");

        System.out.println("Report generated at: " + reportPath);
		TestLogger.info(" onStart method " + context.getName());
		// Reporter log for Email Report
		Reporter.log("onStart method " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		   extent.flush();
		TestLogger.info("onFinish method " + context.getName());
		Reporter.log("onFinish method " + context.getName());
	}

	public String GetScreenshot(String testName, WebDriver driver) {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = "test-output/Screenshots/screenshots" + testName + ".png";
		try {
			
			FileUtils.copyFile(screenshot, new File(screenshotPath));
			System.out.println("screensots are saved at :" + screenshotPath);
		} catch (Exception e) {
			System.out.println("No Screenshots were taken");
			e.printStackTrace();
		}
		return screenshotPath;
	}

}


