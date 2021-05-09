package com.crm.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;

public class LandingPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	public static Logger LOG = LogManager.getLogger(LandingPageTest.class);

	public LandingPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init_driver();
		getDriver().get(prop.getProperty("url"));
		landingPage = new LandingPage();

	}

	@Test(priority = 1)
	public void validatePageTitleTest() {
		LOG.info("##################-Executing Test :: validatePageTitleTest-##################");
		System.out.println(landingPage.getPageTitle());
		String expTitle = "#1 Free CRM customer relationship management software cloud";
		Assert.assertEquals(landingPage.getPageTitle(), expTitle,"*************Title does not match**************");
	}

	@Test(priority = 2)
	public void validateLogoTest() {		
		LOG.info("##################-Executing Test :: validateLogoTest-##################");
		boolean flag = landingPage.validateLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void clickOnLoginButtonTest() {
		LOG.info("##################-Executing Test :: clickOnLoginButtonTest-##################");
		loginPage = landingPage.clickLoginButton();
	}
	
	@Test(priority = 4)
	public void getAllNavItemsTest() {
		LOG.info("##################-Executing Test :: getAllNavItemsTest-##################");
		landingPage.findNavigationBarItems();
	}

	@AfterMethod
	public void tearDown() {
		LOG.info("##################-Quitting Browser-##################");
		getDriver().quit();
	}

}
