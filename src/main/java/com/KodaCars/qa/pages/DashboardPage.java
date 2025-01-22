package com.KodaCars.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.KodaCara.qa.base.TestBase;

public class DashboardPage extends LoginPage {
	
	
	@FindBy(xpath="//label[@class='clr cursor']")
	@CacheLookup
	private WebElement AddReservationbtn;
	@FindBy(xpath="//span[@class='user-name']")
	@CacheLookup
	private WebElement useremail;

	public DashboardPage () {
		   PageFactory.initElements(driver, this);
		}
	public String validateDashboardPagetitle() {
		return driver.getTitle();
	}
	public String validateuserprofile() {
		String email= useremail.getText();
		Assert.assertEquals(email, prop.getProperty("username"));
		return email;
	}
	public AddReservationPage clickaddreservation() {
		
		AddReservationbtn.click();
		return new AddReservationPage();
	}
}
