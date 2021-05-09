package com.crm.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.utils.Report;
import com.crm.utils.XLUtils;

public class ContactsPageTest extends TestBase {
	HomePage homePage;
	ContactsPage contactsPage;
	public static Logger LOG = LogManager.getLogger(ContactsPageTest.class);
	

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init_driver();
		getDriver().get(prop.getProperty("url"));
		homePage = new HomePage();
		homePage.loginToCRMApp();
	}
	
	@DataProvider
	public Object[][] getCRMData(){
		Object testData[][] = XLUtils.getXLData("Contacts");
		return testData;
	}

	@Test(dataProvider="getCRMData")
	public void AddContactTest(String FirstName, String	LastName, String Category, String	DoNotCall) {
		Report.logInfo("Executing Test :: AddContactTest");
//		LOG.info("##################-Executing Test :: AddContactTest-##################");
		contactsPage = homePage.clickContactsPlusIcon();
		contactsPage.createNewContact(FirstName, LastName, Category, DoNotCall);
	}

	@AfterMethod
	public void tearDown() {
		Report.logPass("Quitting Browser");
		getDriver().quit();
	}
}
