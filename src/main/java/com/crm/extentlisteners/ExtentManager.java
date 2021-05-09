package com.crm.extentlisteners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;
	private static ExtentSparkReporter spark;

	public static ExtentReports createInstance(String fileName) {

		spark = new ExtentSparkReporter(fileName);
		spark.config().setEncoding("utf-8");
		spark.config().setDocumentTitle("CRM Automation Reports");
		spark.config().setReportName("Automated Execution Test Results");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("yyyy-MM-dd HH:mm:ss.SSS");

		extent = new ExtentReports();
		extent.attachReporter(spark);
		String username = System.getProperty("user.name");
		String OS = System.getProperty("os.name");
		String OS_Ver = System.getProperty("os.version");
		String TimeZone = System.getProperty("user.timezone");
		extent.setSystemInfo("Automation Tester", username);
		extent.setSystemInfo("Organization", "Self");
		extent.setSystemInfo("SuiteName", "CRM Test Suite");
		extent.setSystemInfo("Operating System", OS);
		extent.setSystemInfo("Operating System Version", OS_Ver);
		extent.setSystemInfo("Time Zone", TimeZone);

		return extent;
	}

	
}
