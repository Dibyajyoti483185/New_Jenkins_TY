package com.crm.autodesk.elementRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.GenericUtilities.WebDriverUtilities;

public class ContactPage extends WebDriverUtilities{

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactImg;
	
	public WebElement getCreateContactImg() {
		return createContactImg;
	}

	@FindBy(xpath = "//img[@title='Last Viewed']")
	private WebElement lastSeenImg;

	@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[4]/a[text()='SAHOO']")
	private WebElement selectContact;

	@FindBy(linkText = "DIBYAJYOTI SAHOO")
	private WebElement dropDownCheck;

	@FindBy(xpath ="//span[text()='SAHOO']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@value='Send Mail']")
	private WebElement sendEmailBtn;

	@FindAll(@FindBy(xpath="//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"))
	private List<WebElement> selectContactBox;

	@FindBy(name = "Select")
	private WebElement goForSelectBtn;
	
	@FindBy(name="subject")
	private WebElement subjectTextBox;
	
	@FindBy(name = "Send")
	private WebElement sendBtn;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homeBtn;

	public WebElement getDropDownCheck() {
		return dropDownCheck;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public List<WebElement> getSelectContactBox() {
		return selectContactBox;
	}

	public void checkLastlyviewedContact() {
		selectContact.click();

		lastSeenImg.click();
		
	}

	public void clickOnAnyContact() {
		selectContact.click();
		
	}

	public void clickOnSendMailBtn(WebDriver driver) throws Throwable {
		sendEmailBtn.click();
		Thread.sleep(2000);
		acceptAlert(driver);

		
		
	}



	public void mailToSingleContact(WebDriver driver,String subjectText) throws Throwable {

		List<WebElement> list = getSelectContactBox();
		for(int i=1;i<list.size();i++) {

			if(i==1) {
				list.get(i).click();
				
			}
		}
		sendEmailBtn.click();
		goForSelectBtn.click();
		switchToWindow(driver, "EditView&sendmail");
		subjectTextBox.sendKeys(subjectText);
		sendBtn.click();
		Thread.sleep(2000);
		acceptAlert(driver);
		Thread.sleep(2000);
		windowClose(driver);
		switchToWindow(driver, "Contacts&action=index");
		
	}
	
	public void mailToMultipleContact(WebDriver driver,String subjectText) throws Throwable {
		List<WebElement> list = getSelectContactBox();
		
		for(int i=1;i<list.size();i++) {

			if(i==1 | i==3 | i==4  ) {
				list.get(i).click();
			
			}

		}
		sendEmailBtn.click();
		goForSelectBtn.click();
		switchToWindow(driver, "EditView&sendmail");
		subjectTextBox.sendKeys(subjectText);
		sendBtn.click();
		Thread.sleep(2000);
		acceptAlert(driver);
		Thread.sleep(2000);
		windowClose(driver);
		switchToWindow(driver, "Contacts&action=index");
		

	}
	
	public String getTitleCreateContactImg() {
		return createContactImg.getAttribute("title");
	}
}