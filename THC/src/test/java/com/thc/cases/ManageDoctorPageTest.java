package com.thc.cases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thc.base.TestBase;
import com.thc.pages.AdminHomePage;
import com.thc.pages.ManageDoctorPage;
import com.thc.pages.LoginPage;
import com.thc.util.TestUtil;

public class ManageDoctorPageTest extends TestBase{
	AdminHomePage adminHomePage;
	LoginPage loginPage ;
	ManageDoctorPage manageDoctorPage ;
	String sheetName = "DoctorDetails";
	String doctorsDataFilePath = "F:\\Java Basic\\THC\\src\\main\\java\\com\\thc\\testdata\\DoctorData.xlsx";
	
	public ManageDoctorPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		adminHomePage = new AdminHomePage();
		loginPage = new LoginPage();
		manageDoctorPage = new ManageDoctorPage();	
		loginPage.adminLogIn(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
	}
	
	@AfterMethod
	public void tearDown(){
		loginPage = new LoginPage();
		loginPage.logOut();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getDoctorTestData(){
		Object data [][] = TestUtil.getTestData(sheetName,doctorsDataFilePath);
	    return data;
	}
	
	@Test(dataProvider="getDoctorTestData")
	public void addDoctorClickingTest(String name,String email,String password,String address, String phone,String department,String profile){
	 	adminHomePage.doctorLink();
		manageDoctorPage.clickAddDoctorLink();
		manageDoctorPage.addDoctorEntry(name, email, password, address, phone, department, profile);
	}
	
}
