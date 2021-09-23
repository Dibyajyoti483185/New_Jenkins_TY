package com.crm.Pratice;

import com.crm.autodesk.GenericUtilities.ExcelUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;

public class DemoFileReader {

	public static void main(String[] args) throws Throwable {
		/*JSONFileUtility jsu=new JSONFileUtility();
		String BROWSER = jsu.readDataFromJSON("browser");
		String URL = jsu.readDataFromJSON("url");
		String USERNAME = jsu.readDataFromJSON("username");
		String PASSWORD = jsu.readDataFromJSON("password");
		
		System.out.println(BROWSER+"\n "+URL+"\n"+USERNAME+"\n"+PASSWORD);*/
		
		ExcelUtility eLib = new ExcelUtility();
		String productName = eLib.getExcelData("Sheet1", 1, 4);
		String partNo = eLib.getExcelData("Sheet1", 1, 5);
		System.out.println(partNo);
	}

}
