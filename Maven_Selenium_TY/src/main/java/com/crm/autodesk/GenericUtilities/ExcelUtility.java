package com.crm.autodesk.GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable, Throwable {
		
		FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet= workbook.getSheet(sheetName);
		DataFormatter format= new DataFormatter(); 
		Row row=sheet.getRow(rownum);
		Cell cell =row.getCell(cellnum);
		String value = format.formatCellValue(cell);
		
		
		return value;
	}
	

	
	
	
	
	
	public Object[][] getExcelData(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(IPathConstants.excelFilePath);
		Workbook workbook =WorkbookFactory.create(fis);
		 
		Sheet sheet= workbook.getSheet(sheetName);
		int lastRow=sheet.getLastRowNum();
		int lastCell=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
		
	}

}
