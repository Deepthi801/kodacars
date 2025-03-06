package com.KodaCars.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.KodaCars.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	@FindBy(xpath ="//input[@formcontrolname='userName']")
	@CacheLookup
	private WebElement Username;
	@FindBy(xpath ="//input[@formcontrolname='password']")
	@CacheLookup
	private WebElement Password;
	@FindBy(xpath ="//button[@type='submit']")
	@CacheLookup
	private WebElement Submit ;
	@FindBy(xpath ="//img[@class=\"anni-img\"]")
	@CacheLookup
	private WebElement Logo ;
	
	
	public LoginPage() {
	   PageFactory.initElements(driver, this);
	}
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}
	public boolean validateKodaCarsLogo() {
		 return Logo.isDisplayed();
	}
	public DashboardPage login(String un, String pwd) {
		Username.sendKeys(un);
		Password.sendKeys(pwd);
		Submit.click();
		return new DashboardPage();
	}
}
