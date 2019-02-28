package com.thc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thc.base.TestBase;

public class DoctorHomePage extends TestBase {

	// PageFactory - Object Repository :
	@FindBy(xpath = "//h3[@class='title']//i[@class='icon-info-sign']")
	WebElement doctorDashBoard;
	
	@FindBy(xpath = "//a[@href='#'][contains(text(),'doctor panel ')]")
	WebElement doctorPanel;
	
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?doctor/manage_patient']//i[@class='icon-user']")
	WebElement patient;
	@FindBy(xpath = "//a[@href='#list']")
	WebElement patientName;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?doctor/manage_appointment']//i[@class='icon-exchange']")
	WebElement appointment;
	@FindBy(xpath = "//a[@href='#list']")
	WebElement appointmentList;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?doctor/manage_prescription']//i[@class='icon-stethoscope']")
	WebElement prescription;
	@FindBy(xpath = "//a[@href='#list']")
	WebElement prescriptionList;
	@FindBy(xpath = "//a[@href='#'][@class='dropdown-toggle'][contains(text(),'account ')]")
	WebElement account;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?login/logout'] //i[@class='icon-off']")
	WebElement logout;

	// initializing the Page Objects:
	public DoctorHomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions :
	public String validateDoctorHomePageTitle() {
		return driver.getTitle();
	}

	public boolean doctorDashBoard() {
		return doctorDashBoard.isDisplayed();
	}

	public boolean doctorPanel() {
		return doctorPanel.isDisplayed();
	}

	public boolean patientLink() {
		patient.click();
		return patientName.isDisplayed();

	}

	public boolean appointmentLink() {
		appointment.click();
		return appointmentList.isDisplayed();
	}

	public boolean prescriptionLink() {
		prescription.click();
		return prescriptionList.isDisplayed();
	}

	public void accountLogoutLink() {
		account.click();
		logout.click();
	}

}
