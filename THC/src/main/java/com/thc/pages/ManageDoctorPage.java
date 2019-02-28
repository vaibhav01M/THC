package com.thc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.thc.base.TestBase;

public class ManageDoctorPage extends TestBase {

	// PageFactory - Object Repository :
	@FindBy(xpath = "//a[@href='#list']")
	@CacheLookup
	WebElement doctorListLink;
	
	@FindBy(xpath = "//a[@href='#add']")
	@CacheLookup
	WebElement addDoctorLink;
	
	@FindBy(xpath = "//input[@type='text'][@name='name']")
	@CacheLookup
	WebElement nameTxtBx;
	
	@FindBy(xpath = "//input[@type='text'][@name='email']")
	@CacheLookup
	WebElement emailTxtBx;
	
	@FindBy(xpath = "//input[@type='password'][@name='password']")
	@CacheLookup
	WebElement passwordTxtBx;
	
	@FindBy(xpath = "//input[@type='text'][@name='address']")
	@CacheLookup
	WebElement addressTxtBx;
	
	@FindBy(xpath = "//input[@type='text'][@name='phone']")
	@CacheLookup
	WebElement phoneTxtBx;
-
	@FindBy(xpath = "//select[@name='department_id']")
	WebElement departmentDD;
	@FindBy(xpath = "//select[@name='department_id']//option[@value=1]")
	WebElement Anesthesiology;
	// @FindBy(xpath="//select[@name='department_id']//option[@value=2]")WebElement
	// bacteriologicalLaboratory ;
	// @FindBy(xpath="//select[@name='department_id']//option[@value=3]")WebElement
	// physicalTherapy ;
	// @FindBy(xpath="//select[@name='department_id']//option[@value=7]")WebElement
	// neurology ;

	@FindBy(xpath = "//input[@type='text'][@name='profile']")
	WebElement profileTxtBx;
	@FindBy(xpath = "//button[@type='submit'][contains(text(),'add doctor')]")
	WebElement addDoctorBtn;

	// initializing the Page Objects:
	public ManageDoctorPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions :

	public void clickDoctorListLink() {
		doctorListLink.click();
	}

	public void clickAddDoctorLink() {
		addDoctorLink.click();
	}

	public void addDoctorEntry(String name, String email, String password, String address, String phone,
			String department, String profile) {
		nameTxtBx.sendKeys(name);
		emailTxtBx.sendKeys(email);
		passwordTxtBx.sendKeys(password);
		addressTxtBx.sendKeys(address);
		phoneTxtBx.sendKeys(phone);
		Select sel = new Select(departmentDD);
		sel.selectByVisibleText(department);
		profileTxtBx.sendKeys(profile);
		addDoctorBtn.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
