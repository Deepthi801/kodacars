package com.KodaCars.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.KodaCara.qa.base.TestBase;
import com.KodaCars.qa.pages.LoginPage;
import com.KodaCars.qa.pages.DashboardPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	DashboardPage dashboardpg;
	

	@BeforeSuite
	public void setup() {
		initialization();
		loginpage = new LoginPage();
			}

	@AfterMethod
	public void tearDown() {
	driver.close();

	}
	
	@Test(priority=1)
	public void loginPageTileTest() {
		String title= loginpage.validateLoginPagetitle();
		Assert.assertEquals(title, "KodaCars Web Portal");
			}
	@Test(priority=2)
	public void loginPageLogoTest() {
		boolean flag= loginpage.validateKodaCarsLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void logintest() {
		dashboardpg = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
}
