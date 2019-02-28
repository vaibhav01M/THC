package com.thc.cases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thc.base.TestBase;
import com.thc.pages.AdminHomePage;
import com.thc.pages.DoctorHomePage;
import com.thc.pages.LoginPage;
import com.thc.pages.PatientHomePage;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class LoginPageTest extends TestBase {

	LoginPage loginPage ;
	AdminHomePage adminHomePage ;
	DoctorHomePage doctorHomePage ;
	PatientHomePage patientHomePage ;
	
	public LoginPageTest(){
	super(); // here it is mandatory to call super class (Parent Class) TestBase class constructor 
	         // It is neccessory to call TestBase class constructor to initialize property also
	         // Because in TestBase class there is a TestBase constructor before initialization method
	}
	
	@BeforeMethod 
	public void setUp(){
		initialization();
		loginPage = new LoginPage();  // object/instance of LoginPage class is required to access its non static method
		adminHomePage = new AdminHomePage ();
		doctorHomePage = new DoctorHomePage ();
		patientHomePage = new PatientHomePage ();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	//@Test(priority=1)
	public void logInPageTitleTest(){
		Assert.assertEquals("login | Company Name",loginPage.validateLoginPageTitle()); // method called using instance of LoginPage Class
	}
	
	//@Test(priority=2)
	public void hospitalLogoTest(){
		boolean flag = loginPage.validateHospitalLogo();
		Assert.assertTrue(flag);
	}
	
	//@Test(priority=3)
	public void hmsHeadingTest(){
		boolean flag = loginPage.validateHmsHeading();
		Assert.assertTrue(flag);
	}
	
	//@Test(priority=4)
	public void adminloginTest(){
		adminHomePage = loginPage.adminLogIn(prop.getProperty("AdminUsername"), prop.getProperty("AdminPassword"));
		boolean flag = adminHomePage.adminPanel();	
		Assert.assertTrue(flag);
		loginPage.logOut();
	}
	
	@Test(priority=5)
	public void doctorloginTest(){
		doctorHomePage = loginPage.doctorLogIn(prop.getProperty("DoctorUsername"), prop.getProperty("DoctorPassword"));
		boolean flag = doctorHomePage.doctorPanel();	
		Assert.assertTrue(flag); 
		loginPage.logOut();
	}	
	
	//@Test(priority=6)
	public void patientloginTest(){
		patientHomePage = loginPage.patientLogIn(prop.getProperty("PatientUsername"), prop.getProperty("PatientPassword"));
		boolean flag = patientHomePage.patientPanel();	
		Assert.assertTrue(flag);
		loginPage.logOut();
	}	
	}
	










