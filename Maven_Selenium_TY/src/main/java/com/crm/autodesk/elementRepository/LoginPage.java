package com.crm.autodesk.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
		@FindBy(name="user_name")
		private WebElement userNameEdt;
		
		@FindBy(name="user_password")
		private WebElement passwordEdt;
		
		@FindBy(id="submitButton")
		private WebElement loginBtn;
		
		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}

		public void login(String username,String password) {
			
			userNameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click();
			
		}
	
	

}
