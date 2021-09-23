package com.crm.autodesk.ContactsTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.ExcelUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtilities;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class TC_18_SendMailSingleContactTest extends BaseClass {
	
	@Test(groups = "RegressionSuite")
	public void sendMailSingleContactTest() throws Throwable {

		
		String SUBJECT = eLib.getExcelData("Sheet1", 1, 6);

		
		HomePage hp=new HomePage(driver);
		hp.clickOnContact();

		Thread.sleep(2000);
		ContactPage ConPage= new ContactPage(driver);
		ConPage.mailToSingleContact(driver,SUBJECT);
		
	
		
		}
	}


