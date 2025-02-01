package com.KodaCars.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
	@FindBy(xpath="//*[@formcontrolname='mobileCode']/div/div/div[3]/input")
	@CacheLookup
	WebElement Phonecode;
	@FindBy(xpath="//input[@formcontrolname='phoneNumber']")
	@CacheLookup
	WebElement Phonenumber;
	@FindBy(xpath="//*[@formcontrolname='location']")
	@CacheLookup
	WebElement Resrv_location;
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	@CacheLookup
	WebElement Resrv_Startdate;
	@FindBy(xpath="//input[@formcontrolname=\"startTime\"]")
	@CacheLookup
	WebElement Resrv_Starttime;
	@FindBy(xpath="//input[@formcontrolname=\"endDate\"]")
	@CacheLookup
	WebElement Resrv_Enddate;
	@FindBy(xpath="//input[@formcontrolname=\"endTime\"]")
	@CacheLookup
	WebElement Resrv_Endtime;
	
	
	
	
	public JavascriptExecutor js = (JavascriptExecutor) driver; 
	public  WebDriverWait wait;
	
	public AddReservationPage() {
		   PageFactory.initElements(driver, this);
		}
		
	public VehicleDetailsP AddCustomerdetails() {
		
//		driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']/div/span[1]")).click();
//  		driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']/ng-dropdown-panel/div/div[2]/div[1]")).sendKeys("+93");
		Phonenumber.sendKeys("456567756");
        Firstname.sendKeys("Priya");
  		Lastname.sendKeys("kala");
  		email.sendKeys("priyak@yopmail.com");
  		Phonecode.click();
  		
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
        //select source "Walk-in";
        WebElement dropdown_source = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@formcontrolname='source']/div/div/div[2]/input")));
        dropdown_source.click();
        WebElement dropdown_list = dropdown_source.findElement(By.xpath("//ng-select[@formcontrolname='source']/ng-dropdown-panel/div/div/div[5]"));
        dropdown_list.click();
        Resrv_Startdate.sendKeys("02/15/2025");
        Resrv_Starttime.sendKeys("9:00 AM");
        Resrv_Enddate.sendKeys("03/12/2025");
        Resrv_Endtime.sendKeys("6:00 PM");
       	return new VehicleDetailsP();
	
	}
	}


	


