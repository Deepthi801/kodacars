
package com.KodaCars.qa.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.awt.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.KodaCars.qa.base.TestBase;
import com.aventstack.chaintest.plugins.ChainTestListener;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestListener extends TestBase implements  ITestListener {
	  public  ExtentReports extent;
	  public  ExtentTest test;
	  public  ExtentSparkReporter sparkReporter;
	  private TestLogger testLogger = new TestLogger();
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Override
	public void onTestStart(ITestResult result) {
		
		testLogger.info(getTestMethodName(result) + " Log4: Test starting.");
		Reporter.log(getTestMethodName(result) + " Reporter: Test started.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		   test = extent.createTest(result.getName());
	        test.pass("Test Passed Successfully:" + result.getName());
	      
	    	System.out.println("Test Successful");
	    	
		testLogger.info(getTestMethodName(result) + " Test is success.");
		Reporter.log(getTestMethodName(result) + "Reporter: Test is success.");
		String screenshotPath = GetScreenshot(result.getName(), driver, "Passed");
		ChainTestListener.log(result.getName() + " Test Passed "); 
		System.out.println((result.getName() + " Test Passed "));
		System.out.println(" Test Passes ");
		//screenshot
		ChainTestListener.embed(screenshotPath, "/passed/image/png"); 
	}

	@Override
	public void onTestFailure(ITestResult result) {
		testLogger.info(getTestMethodName(result) + " Test Failed.");
		Reporter.log("onTestFailure" + result.getName());
		

		// add screenshot target folder
		System.out.println(" result.getName " + result.getName());
		String screenshotPath = GetScreenshot(result.getName(), driver, "FAILED");

		// logs for failed test cases
		ChainTestListener.log(result.getName() + " Test Failed "); 
		System.out.println((result.getName() + " Test Failed "));
		System.out.println(" Test failed ");
		//screenshot
		ChainTestListener.embed(screenshotPath, "Failed/image/png"); 
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		testLogger.info(getTestMethodName(result) + " Test is Skipped.");
		Reporter.log(getTestMethodName(result) + "Reporter: Test is Skipped.");
		String screenshotPath = GetScreenshot(result.getName(), driver, "FAILED");

		// logs for failed test cases
		ChainTestListener.log(result.getName() + " Test Skipped"); 
		System.out.println((result.getName() + " Test Skipped"));
		System.out.println(" Test Skipped ");
		//screenshot
		ChainTestListener.embed(screenshotPath, "Skipped/image/png"); 
	}
	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		  ExtentTest failedTest = extent.createTest(result.getName());
	        failedTest.fail("Test Failed:" + result.getThrowable());
	       	System.out.println("Test Failed");
	     	
		testLogger.info("Test Failed: " + getTestMethodName(result));
		Reporter.log("Reporter:Test Failed within pass percentage " + getTestMethodName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		   // Initialize the ExtentSparkReporter
		 String reportPath = System.getProperty("user.dir") + "/Reports/ExtReport.html";

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
		testLogger.info(" onStart method " + context.getName());
		// Reporter log for Email Report
		Reporter.log("onStart method " + context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		   extent.flush();
		testLogger.info("onFinish method " + context.getName());
		Reporter.log("onFinish method " + context.getName());
	}

 public String GetScreenshot(String testName, WebDriver driver, String status) {
	 TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);

	    // Generate timestamp
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    // Define screenshot folder and file path
	    String screenshotDir = "test-output/Screenshots/";
	    String screenshotPath = screenshotDir + testName + "_" + status.toLowerCase() + "_" + timestamp + ".png";

	    try {
	        // Ensure screenshot directory exists
	        File dir = new File(screenshotDir);
	        if (!dir.exists()) {
	            dir.mkdirs();
	        }

	        // Delete old screenshots before saving new ones
	        for (File file : dir.listFiles()) {
	            if (file.isFile() && file.getName().startsWith(testName)) {
	                file.delete();
	            }
	        }

	        // Read the screenshot file into a BufferedImage
	        BufferedImage image = ImageIO.read(screenshot);

	        // Determine text color based on status
	        Color textColor;
	        if ("FAILED".equalsIgnoreCase(status)) {
	            textColor = Color.RED;
	        } else if ("PASSED".equalsIgnoreCase(status)) {
	            textColor = Color.GREEN;
	        } else { // SKIPPED
	            textColor = Color.ORANGE;
	        }

	        // Draw status text and timestamp on the screenshot
	        Graphics2D g2d = image.createGraphics();
	        g2d.setFont(new Font("Arial", Font.BOLD, 30));
	        g2d.setColor(textColor);
	        g2d.drawString(status + " TEST: " + testName, 50, 50);
	        g2d.drawString("Timestamp: " + timestamp, 50, 90);
	        g2d.dispose();

	        // Save the modified image with overlay text
	        File outputFile = new File(screenshotPath);
	        ImageIO.write(image, "png", outputFile);

	        System.out.println("Screenshot saved at: " + screenshotPath);
	    } catch (Exception e) {
	        System.out.println("No screenshot was taken.");
	        e.printStackTrace();
	    }

	    return screenshotPath;
	}

}
