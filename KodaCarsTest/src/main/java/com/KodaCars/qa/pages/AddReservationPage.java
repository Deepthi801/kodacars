package com.KodaCars.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	public AddReservationPage() {
		   PageFactory.initElements(driver, this);
		}
		
	public void AddCustomerdetails() {
		
		Firstname.sendKeys("Priya");
		Lastname.sendKeys("kala");
		email.sendKeys("priyak@yopmail.com");
		// Click dropdown to open it
        WebElement dropdownTrigger = driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']//div[contains(@class, 'ng-select-container')]"));
        dropdownTrigger.click();

        // Wait for options to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dropdownContainer = driver.findElement(By.xpath("//ng-select[@formcontrolname='mobileCode']"));

         // Locate all options and select the desired one
         List<WebElement> options = dropdownContainer.findElements(By.cssSelector(".ng-option.ng-star-inserted"));
         for (WebElement option : options) {
             System.out.println("Option: " + option.getText());
             if (option.getText().equals("+93")) {
                 option.click();
                 break;
             }
            }
        
       
		Phonenumber.sendKeys("456567756");
		Postcode.sendKeys("56780");
		Address.sendKeys("4567 street rd");
		
		
//		WebElement dropdownContainer_state = driver.findElement(By.xpath("//ng-select[@formcontrolname='state']"));
//
//        // Locate all options and select the desired one
//        List<WebElement> states = dropdownContainer_state.findElements(By.cssSelector(".ng-option.ng-star-inserted"));
//        for (WebElement option : states) {
//            System.out.println("Option: " + option.getText());
//            if (option.getText().equals("+93")) {
//                option.click();
//                break;
//            }
//           }
	}

}
