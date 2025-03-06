package com.KodaCars.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.KodaCars.qa.base.TestBase;
import com.KodaCars.qa.pages.DashboardPage;
import com.KodaCars.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	DashboardPage dashboardpg;
	
	public LoginPageTest() {
		super();
	}
	

	@BeforeClass
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		
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
	
	@AfterClass
	public void tearDown() {
	driver.quit();

	}
	
	
	
}
