package com.crm.Pratice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelUtility;

public class DemoDataProviderTest {
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
			Object[][] val = eLib.getExcelData("Sheet2");
		return val;
	}
	
	@Test(dataProvider="getData")
	public void demo(String Name,String category)
	{
		System.out.println(Name+"\t"+category);
		
	}

}
