package com.KodaCars.qa.testcases;

import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.KodaCars.qa.base.TestBase;
import com.KodaCars.qa.pages.AddReservationPage;
import com.KodaCars.qa.pages.DashboardPage;
import com.KodaCars.qa.pages.LoginPage;
import com.KodaCars.qa.pages.VehicleDetailsP;

public class VehicleDetailsTest extends TestBase {
	LoginPage loginpage;
	DashboardPage dashboardpg;
	AddReservationPage addreservationpg;	
	VehicleDetailsP vehicledetailspg;
	
	public VehicleDetailsTest() {
		super();
	}
	

	@BeforeClass
	public void setup() {
		initialization();
		loginpage = new LoginPage();
		dashboardpg = loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		addreservationpg = dashboardpg.clickaddreservation();
		addreservationpg.AddCustomerdetails();
		vehicledetailspg= new VehicleDetailsP();
	}
	
	
 @Test
 public void EnterVehicleDetails() throws InterruptedException {
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	// vehicledetailspg.Click_on_add_velicle_btn();
	 vehicledetailspg.AddVehicledetails();
	 
 }
 
 @AfterClass
	public void tearDown() {
	driver.quit();

	}
	
}