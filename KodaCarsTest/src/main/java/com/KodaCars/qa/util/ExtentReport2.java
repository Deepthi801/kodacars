package com.KodaCars.qa.util;


import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport2 implements ITestListener {
	    public  ExtentReports extent;
	    public  ExtentTest test;
	    public  ExtentSparkReporter sparkReporter;
	    //TestPractice3 testpractice3;
//	    private TestUtility testutility;
	    
//
	    public ExtentReport2() {
	     //   this.testpractice3 = new TestPractice3();  // Initialize in constructor
	    }

	    public void onStart(ITestContext context) {
	        // Set the output location for the report
	       String reportPath = System.getProperty("user.dir") + "/Reports/ExtReport2.html";
	      
	     

	        // Initialize the ExtentSparkReporter
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
	    }
	    @Override
	    public void onTestStart(ITestResult result) {
	    	test = extent.createTest(result.getName());
	    	System.out.println("Test Started");
	    
	}
	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test = extent.createTest(result.getName());
	        test.pass("Test Passed Successfully:" + result.getName());
	      // testpractice3.takeScreenshot("ConfirmationNo"); 
	    	System.out.println("Test Successful");
	    	
}	
	    @Override
	    public void onTestFailure(ITestResult result){
	   
	        ExtentTest failedTest = extent.createTest(result.getName());
	        failedTest.fail("Test Failed:" + result.getThrowable());
	       // testpractice3.takeScreenshot("Failedshot"); 
	     	System.out.println("Test Failed");
	     	
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	ExtentTest skippedTest = extent.createTest(result.getName());
	    	skippedTest.skip("Test Skipped:" + result.getName());
	    	System.out.println("Test Skipped");
	    	
}   
	    public void onFinish(ITestContext context){
	        extent.flush();
	    
		System.out.println("Test Completed");
	    
	    }
	    public String GetScreenshot(String testName, WebDriver driver) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
			String screenshotPath = "test-output/Screenshots" + testName + ".png";
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