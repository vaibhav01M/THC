package com.thc.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thc.base.TestBase;
import com.thc.pages.DoctorHomePage;
import com.thc.pages.LoginPage;

public class DoctorHomePageTest extends TestBase{

	DoctorHomePage  doctorHomePage;
	LoginPage loginPage;
	
	public DoctorHomePageTest(){
		super();
	}
	
	@BeforeMethod 
	public void setUp(){
		initialization();
		doctorHomePage = new DoctorHomePage();
		loginPage = new LoginPage();
		loginPage.doctorLogIn(prop.getProperty("DoctorUsername"),prop.getProperty("DoctorPassword"));
	}
	
	@AfterMethod
	public void tearDown(){
		loginPage = new LoginPage();
		loginPage.logOut();
		driver.quit();
	}
	
	@Test(priority=1)
	public void doctorHomePageTest(){
		Assert.assertEquals(doctorHomePage.validateDoctorHomePageTitle(),"Company Name");
	}
	
	@Test(priority=2)
	public void doctorPanelCheckTest(){
		Assert.assertTrue(doctorHomePage.doctorPanel());
	}
	
	@Test(priority=3)
	public void patientLinkTest(){
	 Assert.assertTrue(doctorHomePage.patientLink());
	}
	
	@Test(priority=4)
    public void appointmentLinkTest(){
	Assert.assertTrue(doctorHomePage.appointmentLink());	
	}
    
	@Test(priority=5)
    public void prescriptionLinkTest(){
    	Assert.assertTrue(doctorHomePage.prescriptionLink());	
	}
	
}
