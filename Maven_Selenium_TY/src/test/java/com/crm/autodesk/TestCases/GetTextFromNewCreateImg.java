package com.crm.autodesk.TestCases;

import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.BaseClass;
import com.crm.autodesk.elementRepository.ContactPage;
import com.crm.autodesk.elementRepository.HomePage;

public class GetTextFromNewCreateImg  extends BaseClass{
	@Test
	
	public void getTextFromNewCreateImg() {
		HomePage hp= new HomePage(driver);
		hp.clickOnContact();
		ContactPage conPage= new ContactPage(driver);
		System.out.println(conPage.getTitleCreateContactImg());
		
	}

}
