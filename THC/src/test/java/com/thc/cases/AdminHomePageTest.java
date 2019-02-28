package com.thc.cases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thc.base.TestBase;
import com.thc.pages.AdminHomePage;
import com.thc.pages.ManageDoctorPage;
import com.thc.pages.LoginPage;

public class AdminHomePageTest extends TestBase{

   AdminHomePage adminhomepage;
   LoginPage loginPage;
 
   public AdminHomePageTest(){
	   super();
	}
   
   @BeforeMethod 
	public void setUp(){
		initialization();
		adminhomepage = new AdminHomePage();//object/instance of LoginPage class is required to access its non static method 				    			         
		loginPage = new LoginPage();
		loginPage.adminLogIn(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
   } 
   
   @AfterMethod
	public void tearDown(){
	   loginPage.logOut();
	   driver.quit();
	}
   
   @Test
   public void adminHomePageTest(){
	   Assert.assertEquals("Company Name",adminhomepage.validateAdminHomePageTitle());
   }
   
  /* @Test
   public manageDoctorPage doctorLinkTest(){
	  manageDoctorPage flag =  adminhomepage.doctorLink();
	  Assert.assertTrue(flag);
	  return new manageDoctorPage();
   }
   
   @Test
   public managePatientPage patientLinkTest(){
	   boolean flag =  adminhomepage.patientLink();
	   Assert.assertTrue(flag);
	   return new managePatientPage();
   }*/
   
}
