package com.thc.cases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thc.base.TestBase;
import com.thc.pages.AdminHomePage;
import com.thc.pages.LoginPage;
import com.thc.pages.ManageNursePage;
import com.thc.util.TestUtil;

public class ManageNursePageTest extends TestBase {
	
	AdminHomePage adminHomePage;
	LoginPage loginPage ;
	ManageNursePage manageNursePage;
    String sheetName = "NurseDetails";
    String nurseDataFilePath ="F:\\Java Basic\\THC\\src\\main\\java\\com\\thc\\testdata\\NurseData.xlsx";
   
    public ManageNursePageTest() {
		super();
	}
    
	@BeforeMethod
	public void setup(){
		initialization();
		adminHomePage = new AdminHomePage();
		loginPage = new LoginPage();
		manageNursePage = new ManageNursePage();
		loginPage.adminLogIn(prop.getProperty("AdminUsername"),prop.getProperty("AdminPassword"));
	}
	
	@AfterMethod
	public void tearDown(){
		loginPage = new LoginPage();
		loginPage.logOut();
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getNurseTestData(){
		Object data [][] = TestUtil.getTestData(sheetName, nurseDataFilePath);
		return data;
	}
	
	@Test(dataProvider="getNurseTestData")
	public void addNurseTest(String name,String email,String password,String address,String phone){
		adminHomePage.nurseLink();
		manageNursePage.clickAddNurse();
		manageNursePage.AddNurseEntry(name, email, password, address, phone);
	}
	
}
