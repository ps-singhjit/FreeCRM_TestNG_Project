package com.crm.pages;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.base.TestBase;

public class LandingPage extends TestBase {
	WebDriver driver = getDriver();
	public static Logger LOG = LogManager.getLogger(LandingPage.class);
	
	public LandingPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Factory
	@FindBy(xpath = "//span[contains(text(),'Log In')]")
	WebElement LoginBtn;

	@FindBy(xpath = "//a[@title='free crm home']")
	WebElement Logo;

	@FindBy(xpath = "//ul[@class='rd-navbar-nav']/li")
	List<WebElement> NavBarItems;

	public LoginPage clickLoginButton() {
		LOG.info("##################-Clicking on Login Button-##################");
		wait.until(ExpectedConditions.visibilityOf(LoginBtn));
		LoginBtn.click();
		return new LoginPage();
	}

	public String getPageTitle() {
		LOG.info("##################-Getting Page Title-##################");
		return driver.getTitle();

	}

	public boolean validateLogo() {
		LOG.info("##################-Validating Logo-##################");
		return Logo.isDisplayed();
	}

	public void findNavigationBarItems() {
		LOG.info("##################-Getting all items from Navigation Bar-##################");
		NavBarItems.forEach( (elem) -> { 
			if(elem.getText() != "") {
				System.out.println(elem.getText().trim()); 
				LOG.info("##################-"+elem.getText().trim()+"-##################");
				}
			} );
				
//		for (WebElement item : NavBarItems) {			
//			if (item.getText() != "") {
//				System.out.println(item.getText());
//			}
//		}

	}
}
