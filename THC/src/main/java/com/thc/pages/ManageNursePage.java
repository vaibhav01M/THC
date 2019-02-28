package com.thc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.thc.base.TestBase;

public class ManageNursePage extends TestBase {

	// PageFactory - Object Repository :
	@FindBy(xpath = "//a[@href='#list']")
	@CacheLookup
	WebElement nurseListLink;
	
	@FindBy(xpath = "//div[@class='dataTables_filter']//input[@type='text']")
	@CacheLookup
	WebElement nurseSearchTxtbx;	
	
	@FindBy(xpath = "//a[@href='#add']")
	@CacheLookup
	WebElement addNurseLink;
	
	@FindBy(xpath = "//input[@type='text' and @name='name']")
	@CacheLookup
	WebElement nurseNameTxtbx;
	
	@FindBy(xpath = "//input[@type='text' and @name='email']")
	@CacheLookup
	WebElement nurseEmailTxtBx;
	
	@FindBy(xpath = "//input[@type='password' and @name='password']")
	@CacheLookup
	WebElement nursePasswordTxtBx;
	
	@FindBy(xpath = "//input[@type='text' and @name='address']")
	@CacheLookup
	WebElement nurseAddressTxtBx;
	
	@FindBy(xpath = "//input[@type='text' and @name='phone']")
	@CacheLookup
	WebElement nursePhoneTxtBx;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-blue']")
	@CacheLookup
	WebElement addNurseBtn;
	/*
	 * @FindBy(xpath="")WebElement ;
	 * 
	 * @FindBy(xpath="")WebElement ;
	 * 
	 * @FindBy(xpath="")WebElement ;
	 */

	// initialing the Page Objects
	public ManageNursePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions
	public String validateManageNursePageTitle(){
		return driver.getTitle();
	}
	
	public void clickNurseListLink(){
	nurseListLink.click();
	}
	
	public void clickAddNurse(){
		addNurseLink.click();
	}
	
	public void AddNurseEntry(String name, String email, String password, String address, String phone){
	nurseNameTxtbx.sendKeys(name);	
	nurseEmailTxtBx.sendKeys(email);
	nursePasswordTxtBx.sendKeys(password);
	nurseAddressTxtBx.sendKeys(address);
	nursePhoneTxtBx.sendKeys(phone);
	addNurseBtn.click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}	
	
	
}
