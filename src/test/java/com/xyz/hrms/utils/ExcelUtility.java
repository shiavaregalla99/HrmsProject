package com.xyz.hrms.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
	
	public static Object[][] excelData(String filepath,String sheetName){
		openExcel(filepath);
		loadSheet(sheetName);
		int totalRows=rowCount();
		int totalColumns=columnCount(0);
		Object[][] data = new Object[totalRows-1][totalColumns];
		//iterating rows
		for(int i=1;i<totalRows;i++) {
		
		//iterating the columns
		for(int j=0;j<totalColumns;j++) {
			data[i-1][j]=getData(i,j);
		}
	}
		return data;
}
}