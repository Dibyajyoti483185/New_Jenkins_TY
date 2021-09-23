package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDuplicatePage {
	
	public ContactDuplicatePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void clickOnSaveBtn() {
		saveBtn.click();
	}

}
