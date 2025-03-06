package com.KodaCars.qa.testcases;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.KodaCars.qa.base.TestBase;
import com.KodaCars.qa.pages.AddReservationPage;
import com.KodaCars.qa.pages.DashboardPage;
import com.KodaCars.qa.pages.LoginPage;

public class DashboradPageTest extends TestBase{
	
		LoginPage loginpage;
		DashboardPage dashboardpg;
		AddReservationPage addreservationpg;
		
		public DashboradPageTest() {
			super();
			
		}
		

		@BeforeClass
		public void setup() {
			initialization();
			loginpage = new LoginPage();
			dashboardpg = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
				}

		@AfterClass
		public void tearDown() {
		driver.quit();

		}
		
		public void validateuserprofile() {
			dashboardpg.validateuserprofile();
		}
		public void click_on_Addreservationbtn() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			addreservationpg= dashboardpg.clickaddreservation();
		}
}
