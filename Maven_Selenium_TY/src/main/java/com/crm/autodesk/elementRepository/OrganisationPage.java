package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	  
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrganisationImg;

	public WebElement getCreateOrganisationImg() {
		return createOrganisationImg;
	}
	
	public void clickOnCreateOrgLink() {
		createOrganisationImg.click();
	}
	
}
