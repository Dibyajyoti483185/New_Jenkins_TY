package com.crm.autodesk.ContactsTest;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.ExcelUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtilities;
import com.crm.autodesk.elementRepository.ContactDuplicatePage;
import com.crm.autodesk.elementRepository.ContactInformationPage;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;



public class TC_17_DuplicateContactTest extends BaseClass {
	
	
	
	@Test(groups = "RegressionSuite")
	public void duplicateContactsTest() throws Throwable {

		

		HomePage hp=new HomePage(driver);
		hp.clickOnContact();

		ContactPage ConPage= new ContactPage(driver);
		ConPage.clickOnAnyContact();
		
		ContactInformationPage conInfoPage=new ContactInformationPage(driver);
		conInfoPage.clickOnDuplicate();
		
		ContactDuplicatePage ConDupPage=new ContactDuplicatePage(driver);
		ConDupPage.clickOnSaveBtn();
		
		
		
		
	}

}
