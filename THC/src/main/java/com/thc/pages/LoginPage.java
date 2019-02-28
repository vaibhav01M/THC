package com.thc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thc.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory - Object Repository :
	@FindBy(xpath = "//a[@class='brand']")
	@CacheLookup
	WebElement hospitalLogo;
	
	@FindBy(xpath = "/html/body/div[2]/center")
	@CacheLookup
	WebElement hmsLogoMain;
	
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	@CacheLookup
	WebElement selectLanguageDD;
	
	@FindBy(xpath = "//select[@name='login_type']")
	@CacheLookup
	WebElement accountTypeDD;
	
	@FindBy(xpath = "//select[@name='login_type']//option [@value='admin']")
	@CacheLookup
	WebElement admin;
	
	@FindBy(xpath = "//select[@name='login_type']//option [@value='doctor']")
	@CacheLookup
	WebElement doctor;
	
	@FindBy(xpath = "//select[@name='login_type']//option[@value='patient']")// intentionally xpath made wrong to fail test case
	@CacheLookup
	WebElement patient; 
	
	@FindBy(xpath = "//select[@name='login_type']//option [@value='accountant']")
	@CacheLookup
	WebElement accountant;
	
	@FindBy(xpath = "//input[@type='text']")
	@CacheLookup
	WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	@CacheLookup
	WebElement logInButton;
	
	@FindBy(xpath = "//a[@href='#modal-simple']")
	@CacheLookup
	WebElement forgetPasswordLink;
	
	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'account ')]")
	@CacheLookup
	WebElement account;

	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?login/logout']//i[@class='icon-off']")
	@CacheLookup
	WebElement logout;

	// initializing the Page Objects:
	public LoginPage() { // loginPage constructor
		PageFactory.initElements(driver, this); // Initializing Page Factory elements
	}

	// Actions :
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateHospitalLogo() {
		return hospitalLogo.isDisplayed();
	}

	public boolean validateHmsHeading() {
		return hmsLogoMain.isDisplayed();
	}

	public void logOut() {
		account.click();
		logout.click();
	}

	public AdminHomePage adminLogIn(String un, String pwd) {
		System.out.println("un = " + un + " ,  pwd = " + pwd);
		accountTypeDD.click();
		admin.click();
		System.out.println("Account Type : admin selected");
		username.sendKeys(un);
		password.sendKeys(pwd);
		logInButton.click();
		return new AdminHomePage();
	}

	public DoctorHomePage doctorLogIn(String un, String pwd) {
		System.out.println("username =" + un + ",  password =" + pwd);
		accountTypeDD.click();
		doctor.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		logInButton.click();
		return new DoctorHomePage();
	}

	public PatientHomePage patientLogIn(String un, String pwd) {
		System.out.println("un = " + un + " ,  pwd = " + pwd);
		accountTypeDD.click();
		patient.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		logInButton.click();
		return new PatientHomePage();
	}

}
