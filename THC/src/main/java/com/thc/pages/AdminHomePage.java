
package com.thc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thc.base.TestBase;

public class AdminHomePage extends TestBase {

	// PageFactory - Object Repository :
	@FindBy(xpath = "//h3[@class='title']//i[@class='icon-info-sign']")
	WebElement adminDashBoard;
	@FindBy(xpath = "//a[@href='#'][contains(text(),'admin panel ')]")
	WebElement adminPanel;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?admin/manage_doctor']//i[@class='icon-user-md']")
	WebElement doctor;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?admin/manage_patient']//i[@class='icon-user']")
	WebElement patient;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?admin/manage_nurse']//i[@class='icon-plus-sign-alt']")
	WebElement nurse;

	@FindBy(xpath = "//th[@aria-label='doctor name: activate to sort column ascending']//div[contains(text(),'doctor name')]")
	WebElement doctorName;
	@FindBy(xpath = "//th[@aria-label='patient name: activate to sort column ascending']//div[contains(text(),'patient name')]")
	WebElement patientName;
	@FindBy(xpath = "//th[@aria-label='nurse name: activate to sort column ascending']//div[contains(text(),'nurse name')]")
	WebElement nurseName;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/ul[1]/li/a/text()")
	WebElement account;
	@FindBy(xpath = "//a[@href='http://hms.esy.es/index.php?login/logout']//i[@class='icon-off']")
	WebElement logout;

	// initializing the Page Objects:
	public AdminHomePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions :
	public String validateAdminHomePageTitle() {
		return driver.getTitle();
	}

	public boolean adminDashBoard() {
		return adminDashBoard.isDisplayed();
	}

	public boolean adminPanel() {
		return adminPanel.isDisplayed();
	}

	public PatientAddListPage patientLink() {
		patient.click();
		return new PatientAddListPage();
	}

	public ManageNursePage nurseLink() {
		nurse.click();
		return new ManageNursePage();
	}

	public ManageDoctorPage doctorLink() {
		doctor.click();
		return new ManageDoctorPage();
		// return doctorName.isDisplayed();
	}

	public void accountLogoutLink() {
		account.click();
		logout.click();
	}

}
