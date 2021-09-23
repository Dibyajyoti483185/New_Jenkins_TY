package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	public ContactInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath = "//input[@title='Duplicate [Alt+U]']")
	private WebElement duplicateContactbtn;
	
	
	public WebElement getDuplicateContactbtn() {
		return duplicateContactbtn;
	}
	
	
	public void clickOnDuplicate() {
		duplicateContactbtn.click();
	}
}
