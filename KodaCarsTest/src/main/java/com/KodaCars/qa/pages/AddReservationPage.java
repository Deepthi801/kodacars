package com.KodaCars.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.KodaCara.qa.base.TestBase;

public class AddReservationPage extends TestBase{

	@FindBy(xpath="//span[contains(text(), 'Add Reservation')]")
	@CacheLookup
	WebElement Header;
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	@CacheLookup
	WebElement Firstname;
	@FindBy(xpath="//input[@formcontrolname='lastName']")
	@CacheLookup
	WebElement Lastname;
	@FindBy(xpath="//input[@formcontrolname='email']")
	@CacheLookup
	WebElement email;
	@FindBy(xpath="//input[@formcontrolname='postalCode']")
	@CacheLookup
	WebElement Postcode;
	@FindBy(xpath="//input[@formcontrolname='address']")
	@CacheLookup
	WebElement Address;
	@FindBy(xpath="//input[@formcontrolname='phoneNumber']")
	@CacheLookup
	WebElement Phonenumber;
	@FindBy(xpath="//*[@formcontrolname='location']")
	@CacheLookup
	WebElement Resrv_location;
	
	
	public JavascriptExecutor js = (JavascriptExecutor) driver; 
	public  WebDriverWait wait;
	
	public AddReservationPage() {
		   PageFactory.initElements(driver, this);
		}
		
	public VehicleDetailsP AddCustomerdetails() {
		
		
        Firstname.sendKeys("Priya");
  		Lastname.sendKeys("kala");
  		email.sendKeys("priyak@yopmail.com");
       
		Phonenumber.sendKeys("456567756");
		//Postcode.sendKeys("56780");
		//Address.sendKeys("4567 street rd");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@formcontrolname='location']/div/div/div[3]/input")));
        dropdown.click();

        // Wait for the dropdown options to appear
        WebElement dropdownPanel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-option ng-option-marked ng-star-inserted']")));
        // Find the desired option (e.g., "Damco, Noida") and click it
        WebElement desiredOption = dropdownPanel.findElement(By.xpath("//*[@formcontrolname='location']//ng-dropdown-panel"));
        desiredOption.click();

        
        //select source
        //source (2)
        // Wait for the dropdown options to appear
        
        //select source "AirportParkingReservations";
        WebElement dropdown_source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@formcontrolname='source']/div/div/div[2]/input")));
        dropdown_source.click();
        WebElement dropdown_list = dropdown_source.findElement(By.xpath("//ng-select[@formcontrolname='source']/ng-dropdown-panel/div"));
        dropdown_list.click();
		return new VehicleDetailsP();
	
	}
	}


	


