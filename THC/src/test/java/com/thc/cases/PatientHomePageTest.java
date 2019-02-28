package com.thc.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thc.base.TestBase;
import com.thc.pages.LoginPage;
import com.thc.pages.PatientHomePage;

public class PatientHomePageTest extends TestBase{
	LoginPage loginPage;
	PatientHomePage patienthomepage ;
	
    public PatientHomePageTest(){
		super();
	}
    
   @BeforeMethod 
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
		loginPage.patientLogIn(prop.getProperty("PatientUsername"),prop.getProperty("PatientPassword"));
		}
    
    @AfterMethod
	public void tearDown(){
    	loginPage = new LoginPage();
		loginPage.logOut();
    	driver.quit();
	}
    
 //   @Test(priority=1)
    public void patientHomePageTest(){
    	Assert.assertEquals(patienthomepage.validatePatientHomePageTitle(),"Company Name");
    }
    
    @Test(priority=2)
    public void doctorLinkTest(){
    	Assert.assertTrue(patienthomepage.doctorLink());
   	}
    
  //  @Test(priority=3)
    public void appointmentLinkTest(){
    	Assert.assertTrue(patienthomepage.appointmentLink());
    }
    
  //  @Test(priority=4)
    public void prescriptionLinkTest(){
    	Assert.assertTrue(patienthomepage.prescriptionLink());
    }
    
}
