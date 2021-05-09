package com.crm.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.LandingPage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	public static Logger LOG = LogManager.getLogger(LoginPageTest.class);

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		init_driver();
		getDriver().get(prop.getProperty("url"));
		landingPage = new LandingPage();
	}

	@Test
	public void LoginToCRMTest() {
		LOG.info("##################-Executing Test :: LoginToCRMTest-##################");
		loginPage = landingPage.clickLoginButton();
		String EmaiID = prop.getProperty("username");
		String Password = prop.getProperty("password");
		loginPage.doLogin(EmaiID, Password);
	}

	@AfterMethod
	public void tearDown() {
		LOG.info("##################-Quitting Browser-##################");
		getDriver().quit();
	}

}
