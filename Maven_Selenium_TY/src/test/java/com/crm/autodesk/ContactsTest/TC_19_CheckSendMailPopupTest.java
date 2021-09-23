package com.crm.autodesk.ContactsTest;

import org.openqa.selenium.WebDriver;
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

public class TC_19_CheckSendMailPopupTest extends BaseClass {
	
	@Test(groups = "SmokeSuite")
	public void checkSendMailPopUpTest() throws Throwable {

		
		HomePage hp=new HomePage(driver);
		hp.clickOnContact();
		
		Thread.sleep(5000);
		
		ContactPage ConPage= new ContactPage(driver);
		ConPage.clickOnSendMailBtn(driver);
	}

}
