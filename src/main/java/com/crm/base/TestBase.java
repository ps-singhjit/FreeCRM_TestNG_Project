package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.config.Constants;
import com.crm.utils.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	public static Properties prop;
	public static String browser;
	public static WebDriverWait wait;
	public static EventFiringWebDriver fire_driver;
	public static WebEventListener eventListener;
	public static Logger LOG = LogManager.getLogger(TestBase.class);
	
	
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/com/crm/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public WebDriver init_driver() {
		browser = prop.getProperty("browser");
		System.out.println("Browser selected for execution :: " + browser);
		LOG.info("##################-Browser selected for execution ::" + browser +"-##################");
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}
		//passing driver thread to EventFire
		fire_driver = new EventFiringWebDriver(getDriver());
		eventListener = new WebEventListener();
		fire_driver.register(eventListener);
		tlDriver.set(fire_driver);
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(getDriver(),Constants.WEBDRIVER_WAIT);
		return getDriver();
	}

	public static synchronized WebDriver getDriver() { // for parallel execution threads have to be synchronized
		return tlDriver.get();
	}

}
