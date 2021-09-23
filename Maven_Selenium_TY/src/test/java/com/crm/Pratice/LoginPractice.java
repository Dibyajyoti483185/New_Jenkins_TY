package com.crm.Pratice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtilities;
import com.crm.autodesk.elementRepository.LoginPage;

public class LoginPractice {
	WebDriver driver;
	@Test
	
	public void loginPractice() throws Throwable {
		

		JSONFileUtility jsLib=new JSONFileUtility();
		JavaUtility jLib =new JavaUtility();
		WebDriverUtilities wLib= new WebDriverUtilities();
		ExcelUtility eLib = new ExcelUtility();
		
		String BROWSER = jsLib.readDataFromJSON("browser");
		String URL = jsLib.readDataFromJSON("url");
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		
		String contactName = eLib.getExcelData("Sheet1", 1, 1);
		String orgName = eLib.getExcelData("Sheet1", 1, 2);
		
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		
		wLib.waitForpageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
		System.out.println("login successfull");
	}

}
