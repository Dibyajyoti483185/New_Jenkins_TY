package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtilities;

public class HomePage extends WebDriverUtilities {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Organizations")
	private WebElement organisationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administatorLink;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLink;
	
	

	public WebElement getOrganisationLink() {
		return organisationLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getAdministatorLink() {
		return administatorLink;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void clickOnOrganisation() {
		
		organisationLink.click();
	}
	
	public void clickOnContact() {
		
		contactLink.click();
	}
	
	public void signOut(WebDriver driver)  {
		
		
		mouseHover(driver,administatorLink );
		signOutLink.click();
		
	}

	

}
