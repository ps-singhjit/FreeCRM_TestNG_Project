package com.crm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xml.security.encryption.DocumentSerializer;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;
import com.crm.utils.TestUtils;

public class ContactsPage extends TestBase {

	public static Logger LOG = LogManager.getLogger(HomePage.class);
	LoginPage loginPage;
//	ContactsPage contactsPage;

	public ContactsPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Page Factory
	@FindBy(xpath = "//*[@id='dashboard-toolbar']/div[1]")
	private WebElement PageHeading;
	
	@FindBy(name = "first_name")
	private WebElement FirstName;
	
	@FindBy(name = "last_name")
	private WebElement LastName;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement CancelBtn;
	
	@FindBy(name = "category")
	private WebElement Category_drpdown;
	
	@FindBy(xpath = "//div[@role='option']/span[text()='Lead']")
	private WebElement Option_Lead;
	
	@FindBy(xpath = "//input[@name='do_not_call']")
	private WebElement DoNotCall_rdo;
	
	
	// Action Functions		
	private void enterFirstName(String FName) {
		LOG.info("##################-Entering First Name :: "+FName+"-##################");
		FirstName.sendKeys(FName);				
	}
	
	private void enterLastName(String LName) {
		LOG.info("##################-Entering Last Name :: "+LName+"-##################");
		TestUtils.moveToElement(getDriver(), LastName);
		LastName.sendKeys(LName);				
	}
	
	private void selectCategoryOption(String Option) {
		LOG.info("##################-Selecting " + Option + " in Category-##################");
		Category_drpdown.click();
		getDriver().findElement(By.xpath("//div[@role='option']/span[text()='" + Option + "']")).click();		
	}

	private void clickDoNotCallRadioBtn(String Status) {
		LOG.info("##################-Clicking Do Not Call Radio Button-##################");
		if(Status.toUpperCase().contentEquals("ON")) {
			try {
				DoNotCall_rdo.click();
			} catch (Exception e) {
				TestUtils.jsClickElement(getDriver(), DoNotCall_rdo);
			}
		}
	}
	
	public void createNewContact(String FName, String LName, String Option, String Status) {
		enterFirstName(FName);
		enterLastName(LName);
		selectCategoryOption(Option);
		clickDoNotCallRadioBtn(Status);
		SaveBtn.click();		
	}
	
	
	
	
	
	
	
}
