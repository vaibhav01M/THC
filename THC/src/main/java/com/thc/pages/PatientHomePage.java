package com.thc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thc.base.TestBase;

public class PatientHomePage extends TestBase {

	
	@FindBy(xpath="//div[@class='pull-left header']//h3 [@class='title'] ")WebElement patientDashBoard;	
	@FindBy(xpath="//a[@href='#']//i[@class='icon-user']")WebElement patientPanel;
	@FindBy(xpath="//a[@href='http://hms.esy.es/index.php?patient/view_doctor']//i[@class='icon-stethoscope']")WebElement doctor;
	@FindBy(xpath="//a[@href='#list']")WebElement doctorList;
	@FindBy(xpath="//a[@href='http://hms.esy.es/index.php?patient/view_appointment']//i[@class='icon-exchange']")WebElement appointment;
	@FindBy(xpath="//a[@href='#list']")WebElement appointmentList;
	@FindBy(xpath="//a[@href='http://hms.esy.es/index.php?patient/view_prescription']//i[@class='icon-stethoscope']")WebElement prescription;
	@FindBy(xpath="//a[@href='#list']")WebElement prescriptionList;
	@FindBy(xpath="//a [@href='#'][@class='dropdown-toggle'][contains(text(),'account')]")WebElement account;
	@FindBy(xpath="//a[@href='http://hms.esy.es/index.php?login/logout']//i[@class='icon-off']")WebElement logout;
 	
	// initializing the Page Objects:
	public PatientHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions :
	public String validatePatientHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean patientDashBoard(){
		return patientDashBoard.isDisplayed();
	}
	
	public boolean patientPanel(){
		return patientPanel.isDisplayed();
	}
	
	public boolean doctorLink(){
		  doctor.click();
		  return doctorList.isDisplayed();
		  
	}
	
	public boolean appointmentLink(){
		  appointment.click();
		  return appointmentList.isDisplayed();
	}
	
	public boolean prescriptionLink(){
		  prescription.click();
		  return prescriptionList.isDisplayed();
	}
	public void accountLogoutLink(){
		  account.click();
		  logout.click();
	}
}
