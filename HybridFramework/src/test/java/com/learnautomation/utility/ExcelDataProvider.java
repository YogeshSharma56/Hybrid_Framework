package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		
		File src = new File("./TestData/TestData.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			
		} catch (IOException e) {
			
			System.out.println("Unable to load Excel due to" + e.getMessage());
			
		}
	}	
	public String getStringData(String sheetName, int row, int col)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
	}
	
	public double getNumericData()
	{
		return wb.getSheet("LoginCredentials").getRow(0).getCell(1).getNumericCellValue();
	}
		
	

}
