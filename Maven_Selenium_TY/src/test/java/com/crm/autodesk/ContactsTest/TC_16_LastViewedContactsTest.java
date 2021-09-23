package com.crm.autodesk.ContactsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.GenericUtilities.ExcelUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtilities;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;


public class TC_16_LastViewedContactsTest extends BaseClass  {
	
	@Test(groups = "SmokeSuite")
	public void viewContactsTest() throws Throwable {

		

		HomePage hp=new HomePage(driver);
		hp.clickOnContact();

		ContactPage ConPage= new ContactPage(driver);
		ConPage.checkLastlyviewedContact();
		String expectedResult = ConPage.getLastName().getText();
		String actualResult = ConPage.getDropDownCheck().getText();
		Assert.assertTrue(actualResult.contains(expectedResult));
		System.out.println("lastly viewedn contact is displayed in lastly views list");
		

		
	



	}

}
