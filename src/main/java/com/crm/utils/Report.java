package com.crm.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.crm.extentlisteners.ExtentListeners;

public class Report {
	public static Logger LOG = LogManager.getLogger(Report.class);

	public static void logInfo(String message) {
		ExtentListeners.testReport.get().info(message);
		LOG.info("##########:: " + message + " ::##########");
	}

	public static void logFail(String message) {
		Markup m = MarkupHelper.createLabel(message, ExtentColor.RED);
		ExtentListeners.testReport.get().fail(m);
		LOG.error("##########:: " + message + " ::##########");
	}

	public static void logPass(String message) {
		LOG.info("##########:: " + message + " ::##########");
		message = "<fornt color='PaleGreen'>" + message + "</font>";
		ExtentListeners.testReport.get().pass(message);

	}

	public static void logHighlight(String message) {
		LOG.info("##########:: " + message + " ::##########");
		message = "<fornt color='Aqua'>" + message + "</font>";
		ExtentListeners.testReport.get().info(message);

	}

	public static void logSkip(String message) {
		LOG.info("##########:: " + message + " ::##########");
		ExtentListeners.testReport.get().skip(message);

	}

	public static void logWarning(String message) {
		LOG.warn("##########:: " + message + " ::##########");
		message = "<fornt color='Gold'>" + message + "</font>";
		ExtentListeners.testReport.get().warning(message);
	}

	public static void logJsonInfo(String message) {
		ExtentListeners.testReport.get().info(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
	}

	public static void logJsonPass(String message) {
		ExtentListeners.testReport.get().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.JSON));
	}

	public static void logXMLInfo(String message) {
		ExtentListeners.testReport.get().info(MarkupHelper.createCodeBlock(message, CodeLanguage.XML));
	}

	public static void logCodeInfo(String message) {
		ExtentListeners.testReport.get().info(MarkupHelper.createCodeBlock(message, CodeLanguage.values().toString()));
	}

	public static void logCodeFail(String message) {
		ExtentListeners.testReport.get().fail(MarkupHelper.createCodeBlock(message, CodeLanguage.values().toString()));
	}

	public static void logCodePass(String message) {
		ExtentListeners.testReport.get().pass(MarkupHelper.createCodeBlock(message, CodeLanguage.values().toString()));
	}

}
