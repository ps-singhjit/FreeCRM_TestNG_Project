package com.crm.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.crm.config.Constants;

public class XLUtils {
	static Workbook workbook;
	static Sheet sheet;

	public static Object[][] getTestData(String SheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.TEST_SHEET_PATH);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet = workbook.getSheet(SheetName);
		int Rows = sheet.getLastRowNum();
		int Cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[Rows][Cols];
		for (int iRow = 0; iRow < Rows; iRow++) {
			for (int iCol = 0; iCol < Cols; iCol++) {
				data[iRow][iCol] = sheet.getRow(iRow + 1).getCell(iCol).toString();
			}
		}

		return data;
	}

	public static Object[][] getXLData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(Constants.TEST_SHEET_PATH);
			System.out.println(Constants.TEST_SHEET_PATH);
//			FileInputStream inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = null;
		try {
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(file);
			sheet = wb.getSheet(sheetName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int Rows = sheet.getLastRowNum();
		int Cols = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[Rows][Cols];
		for (int iRow = 0; iRow < Rows; iRow++) {
			for (int iCol = 0; iCol < Cols; iCol++) {
				data[iRow][iCol] = sheet.getRow(iRow + 1).getCell(iCol).toString();
			}
		}

		return data;
	}

}
