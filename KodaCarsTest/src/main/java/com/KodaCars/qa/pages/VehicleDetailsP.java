package com.KodaCars.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KodaCara.qa.base.TestBase;

public class VehicleDetailsP extends TestBase {
	
	@FindBy(xpath ="//button[contains(text(),'Add Vehicle')]")
	@CacheLookup
	WebElement AddVehicle_btn;
	@FindBy(xpath ="//ng-select[@formcontrolname='carColor']")
	@CacheLookup
	WebElement Carcolor_drp;
	@FindBy(xpath ="//ng-select[@formcontrolname='make']/div/div/div[3]/input")
	@CacheLookup
	WebElement Carmake;
	@FindBy(xpath ="//ng-select[@formcontrolname='model']/div/div/div[3]/input")
	@CacheLookup
	WebElement Carmodel;
	@FindBy(xpath ="//input[@formcontrolname='licenseNo']")
	@CacheLookup
	WebElement Licenceno;
	@FindBy(xpath ="//ng-select[@formcontrolname='state']")
	@CacheLookup
	WebElement Car_State;
	@FindBy(xpath ="//input[@formcontrolname='ticket']")
	@CacheLookup
	WebElement Ticket;
	@FindBy(xpath ="//input[@formcontrolname='tagId']")
	@CacheLookup
	WebElement TagId;
	@FindBy(xpath ="//textarea[@formcontrolname='comment']")
	@CacheLookup
	WebElement Comments;
	@FindBy(xpath ="//p-checkbox[@formcontrolname='isOverSized']")
	@CacheLookup
	WebElement Oversizecar;
	@FindBy(xpath ="//ng-select[@formcontrolname='vehicleOversizeCategoryId']")
	@CacheLookup
	WebElement OversizeVehicleCategory;
	
	  
	 public VehicleDetailsP() {
		   PageFactory.initElements(driver, this);
		  
		}
	 
	// public static JavascriptExecutor js;
	
	 public void Click_on_add_velicle_btn() {
		 AddVehicle_btn.click();
	 }
	 
	 
	 public void AddVehicledetails() {
		
    //select car color
        Carcolor_drp.click();
        
   //car color
    String colour = prop.getProperty("grey");
    driver.findElement(By.xpath("//ng-dropdown-panel/div/div/div["+ colour + "]")).click();
  // select car make
     String carmake= prop.getProperty("Toyota");
     Carmake.click();
     driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div[" + carmake +"]")).click();
     
     // car model
     Carmodel.click();
     String carModelIndex = (prop.getProperty("camry"));
     driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div[" + carModelIndex + "]")).click();
     
     // car licence
     Licenceno.sendKeys("Kjl 00987");
   //car licence state
     Car_State.click();
     String carstate= prop.getProperty("carstate");
     driver.findElement(By.xpath("//div[@class='ng-dropdown-panel-items scroll-host']/div/div[" + carstate + "]")).click();
     
     Ticket.sendKeys(" ");
     TagId.sendKeys("   ");
     Comments.sendKeys("  ");
     
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,3500)");
     
         	    String carSize = prop.getProperty("carsize");
    	    if (carSize == null || carSize.isEmpty()) {
    	        System.out.println("Car is not oversize");
    	    } else {
    	        // Perform actions if car is oversize
    	        try {
    	            Oversizecar.click();  
    	            OversizeVehicleCategory.click();
    	            String OversizeCarsize= prop.getProperty("large");
    	            driver.findElement(By.xpath("//ng-select[@formcontrolname='vehicleOversizeCategoryId']/ng-dropdown-panel/div/div[2]/div[" + OversizeCarsize + "]")).click();
    	        } catch (Exception e) {
    	            System.err.println("Error performing Selenium actions: " + e.getMessage());
    	        }
    	
    	    }
}
}
	
	
	
	
	
	
	
	


