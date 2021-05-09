package com.crm.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.base.TestBase;

public class TestUtils extends TestBase {

	public static String takeScreenshot() {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String currDir = System.getProperty("user.dir");
		String path = currDir+File.separator+"SCREENSHOTS"+
				File.separator+"IMG_"+System.currentTimeMillis() + ".jpg";
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	public static String takeScreenshotAsBase64() {
		File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String currDir = System.getProperty("user.dir");
		String path = currDir+File.separator+"SCREENSHOTS"+
				File.separator+"IMG_"+System.currentTimeMillis() + ".jpg";
		String image ="";
		try {
			FileUtils.copyFile(scrFile, new File(path));
			byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(path));
			image = Base64.getEncoder().encodeToString(imageBytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return image;
	}
	public static String getBase64Image() {
		//return base64 image without physically storing image
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
	}
	
	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public static void jsClickElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jsExe = (JavascriptExecutor)driver;
		jsExe.executeScript("arguments[0].click();", element);
	}
	public static void jsSendKeys(WebDriver driver, WebElement element, String text) {
		JavascriptExecutor jsExe = (JavascriptExecutor)driver;
		jsExe.executeScript("arguments[0].value='"+text +"';", element);
	}
	JavascriptExecutor jsExe = (JavascriptExecutor)getDriver();
//	jsExe.executeScript("document.DoNotCall_rdo.click");
	
}
