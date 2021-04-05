package com.xyz.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static Workbook book;
	public static Sheet sheet;
	public static void openExcel(String filepath) {
		try {
			FileInputStream fis= new FileInputStream(filepath);
			book= new XSSFWorkbook(fis); //xlsx format
		 //   Workbook wb1= new HSSFWorkbook(fis); //xls format
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadSheet(String sheetName) {
		sheet= book.getSheet(sheetName);
	}
	
	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	public static int columnCount(int rowNumber) {
		return sheet.getRow(rowNumber).getLastCellNum();
	}
	
	public static String getData(int rowIndex,int columIndex) {
		return sheet.getRow(rowIndex).getCell(columIndex).toString();
	}
}
