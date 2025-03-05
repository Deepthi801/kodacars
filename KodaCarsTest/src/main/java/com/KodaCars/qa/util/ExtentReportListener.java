package com.KodaCars.qa.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {
	 private int m_count = 0;
	 
	 @Override
	  public void onTestStart(ITestResult tr) {
		 System.out.println("Test Started");
	    log("T");
	  }

	 public void onFinish(ITestResult tr) {
		 System.out.println("Test Complete");
	    log("C");
	  }
	  @Override
	  public void onTestFailure(ITestResult tr) {
		  System.out.println("Test Failed");
	    log("F");
	  }

	  @Override
	  public void onTestSkipped(ITestResult tr) {
		  System.out.println("Test Skipped");
	    log("S");
	  }

	  @Override
	  public void onTestSuccess(ITestResult tr) {
	    log(".");
	  }

	  private void log(String string) {
	    System.out.print(string);
	    if (++m_count % 40 == 0) {
	      System.out.println(" ");
	      
	    }
	  }
	}
	
		    
		
