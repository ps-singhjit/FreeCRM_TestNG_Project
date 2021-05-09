package com.crm.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.base.TestBase;

public class LoginPage extends TestBase {
	public static Logger LOG = LogManager.getLogger(LoginPage.class);

	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}

	// Page Factory
	@FindBy(name = "email")
	private WebElement Email;

	@FindBy(name = "password")
	private WebElement Password;

	@FindBy(xpath = "//div[text()='Login']")
	private WebElement LoginBtn;

	// Action Functions

	public void enterEmailId(String email) {
		wait.until(ExpectedConditions.visibilityOf(Email)); 
		Email.sendKeys(email);
		LOG.info("##################-Entered Email-##################");
	}

	public void enterPassword(String pwd) {
		Password.sendKeys(pwd);
		LOG.info("##################-Entered Password-##################");
	}

	public void clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(LoginBtn));
		LoginBtn.click();
		LOG.info("##################-Clicked on Login button-##################");
	}

	public HomePage doLogin(String email, String pwd) {
		enterEmailId(email);
		enterPassword(pwd);
		clickLoginBtn();
		return new HomePage();
		
	}

}
