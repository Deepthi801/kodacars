package com.KodaCars.qa.testcases;

import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.KodaCara.qa.base.TestBase;
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
		

		@BeforeMethod
		public void setup() {
			initialization();
			loginpage = new LoginPage();
			dashboardpg = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
				}

		
		@AfterMethod
		public void tearDown() {
		driver.close();

		}
		
		public void validateuserprofile() {
			dashboardpg.validateuserprofile();
		}
		public void click_on_Addreservationbtn() {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			addreservationpg= dashboardpg.clickaddreservation();
		}
}
