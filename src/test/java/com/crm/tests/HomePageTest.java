package com.crm.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.utils.Report;

public class HomePageTest extends TestBase{
	HomePage homePage;
	public static Logger LOG = LogManager.getLogger(HomePageTest.class);
	
	public HomePageTest() {
		super();
	}	
	
	@BeforeMethod
	public void setUp() {
		init_driver();
		getDriver().get(prop.getProperty("url"));		
		homePage = new HomePage();
		homePage.loginToCRMApp();
	}
	
	@Test
	public void validateAccountNameTest() {
		Report.logInfo("Executing Test :: validateAccountNameTest");
		String name = homePage.findAccountName();
		Assert.assertEquals(name, "Paramjit Singh","****Expected name is not same.****");
		Report.logPass("Page heading is as expected :: " + name);
		
	}
	@Test
	public void validateAccountNameTest1() {
		Report.logInfo("Executing Test :: validateAccountNameTest");
		String name = homePage.findAccountName();
		Report.logFail("Page heading is as expected :: " + name);
		Assert.assertEquals(name, "Paramjit Singh123","****Expected name is not same.****");
		Report.logPass("Page heading is as expected :: " + name);
		
	}
		
	@AfterMethod
	public void tearDown() {
		Report.logPass("Quitting Browser");
		getDriver().quit();
	}
	
}
