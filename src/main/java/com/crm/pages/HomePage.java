package com.crm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;
import com.crm.utils.PropReader;
import com.crm.utils.TestUtils;

public class HomePage extends TestBase {
	public static Logger LOG = LogManager.getLogger(HomePage.class);
	LoginPage loginPage;
//	ContactsPage contactsPage;

	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Page Factory
	@FindBy(css = "span.user-display")
	private WebElement UserName;

	@FindBy(xpath = "//i[@class='calendar icon']")
	private WebElement CalendarIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][2]/button")
	private WebElement CalendarPlusIcon;

	@FindBy(xpath = "//i[@class='users icon']")
	private WebElement ContactsIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][3]/button")
	private WebElement ContactsPlusIcon;

	@FindBy(xpath = "//i[@class='building icon']")
	private WebElement CompaniesIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][4]/button")
	private WebElement CompaniesPlusIcon;

	@FindBy(xpath = "//i[@class='money icon']")
	private WebElement DealsIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][5]/button")
	private WebElement DealsPlusIcon;

	@FindBy(xpath = "//i[@class='tasks icon']")
	private WebElement TasksIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][6]/button")
	private WebElement TasksPlusIcon;

	@FindBy(xpath = "//i[@class='comments icon']")
	private WebElement CasesIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][7]/button")
	private WebElement CasesPlusIcon;

	@FindBy(xpath = "//i[@class='phone icon']")
	private WebElement CallsIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][8]/button")
	private WebElement CallsPlusIcon;

	@FindBy(xpath = "//i[@class='file icon']")
	private WebElement DocumentsIcon;
	@FindBy(xpath = "//div[@class='menu-item-wrapper'][9]/button")
	private WebElement DocumentsPlusIcon;

	@FindBy(xpath = "//i[@class='mail outline icon']")
	private WebElement EmailIcon;

	@FindBy(xpath = "//i[@class='target icon']")
	private WebElement CampaignsIcon;

	@FindBy(xpath = "//i[@class='wpforms icon']")
	private WebElement FormsIcon;

	// Action Functions

	public void loginToCRMApp() {
		LandingPage landingPage = new LandingPage();
		loginPage = landingPage.clickLoginButton();
		String EmaiID = PropReader.readEncodedProperty("encoded_username");
		String Password = PropReader.readEncodedProperty("encoded_password");
//		String EmaiID = prop.getProperty("username");
//		String Password = prop.getProperty("password");
		loginPage.doLogin(EmaiID, Password);
	}

	public String findAccountName() {
		LOG.info("##################-Finding Account Name-##################");
		return UserName.getText();
	}

	public void clickCalendarIcon() {
		CalendarIcon.click();
		LOG.info("##################-Clicked on Calendar Icon-##################");
	}

	public void clickContactsIcon() {
		ContactsIcon.click();
		LOG.info("##################-Clicked on Contacts Icon-##################");
	}

	public void clickCompaniesIcon() {
		CompaniesIcon.click();
		LOG.info("##################-Clicked on Companies Icon-##################");
	}

	public void clickDealsIcon() {
		DealsIcon.click();
		LOG.info("##################-Clicked on Deals Icon-##################");
	}

	public void clickCasesIcon() {
		CasesIcon.click();
		LOG.info("##################-Clicked on Cases Icon-##################");
	}

	public void clickTasksIcon() {
		TasksIcon.click();
		LOG.info("##################-Clicked on Tasks Icon-##################");
	}

	public void clickCallsIcon() {
		CallsIcon.click();
		LOG.info("##################-Clicked on Calls Icon-##################");
	}

	public void clickDocumentsIcon() {
		DocumentsIcon.click();
		LOG.info("##################-Clicked on Documents Icon-##################");
	}

	public void clickEmailIcon() {
		EmailIcon.click();
		LOG.info("##################-Clicked on Email Icon-##################");
	}

	public void clickCampaignsIcon() {
		DealsIcon.click();
		LOG.info("##################-Clicked on Campaigns Icon-##################");
	}

	public void clickFormsIcon() {
		FormsIcon.click();
		LOG.info("##################-Clicked on Forms Icon-##################");
	}

	public ContactsPage clickContactsPlusIcon() {
//		Actions action = new Actions(getDriver());
//		action.moveToElement(ContactsIcon).build().perform();
		TestUtils.moveToElement(getDriver(), ContactsIcon);
		ContactsPlusIcon.click();
		LOG.info("##################-Clicked on Contacts Plus Icon-##################");
		return new ContactsPage();
	}
}
