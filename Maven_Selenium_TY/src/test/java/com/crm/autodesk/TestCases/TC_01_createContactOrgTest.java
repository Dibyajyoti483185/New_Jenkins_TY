package com.crm.autodesk.TestCases;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.ExcelUtility;
import com.crm.autodesk.GenericUtilities.JSONFileUtility;
import com.crm.autodesk.GenericUtilities.JavaUtility;
import com.crm.autodesk.GenericUtilities.WebDriverUtilities;

public class TC_01_createContactOrgTest {
	WebDriver driver;
	@Test
	public void createContactWthOrgTest() throws Throwable{
		
	
	
	JSONFileUtility jsLib=new JSONFileUtility();
	JavaUtility jLib =new JavaUtility();
	WebDriverUtilities wLib= new WebDriverUtilities();
	ExcelUtility eLib = new ExcelUtility();
	
	String BROWSER = jsLib.readDataFromJSON("browser");
	String URL = jsLib.readDataFromJSON("url");
	String USERNAME = jsLib.readDataFromJSON("username");
	String PASSWORD = jsLib.readDataFromJSON("password");
	
	String contactName = eLib.getExcelData("Sheet1", 1, 1);
	String orgName = eLib.getExcelData("Sheet1", 1, 2);
	
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver=new ChromeDriver();
		
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	else {
		System.out.println("invalid browser");
	}
	
	
	wLib.waitForpageLoad(driver);
	wLib.maximizeWindow(driver);
	driver.get(URL);
	
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	driver.findElement(By.name("lastname")).sendKeys(contactName);
	driver.findElement(By.xpath("//img[@title='Select']")).click();
	
	wLib.switchToWindow(driver, "Accounts");
	
	driver.findElement(By.id("search_txt")).sendKeys(orgName);
	driver.findElement(By.name("search")).click();
	driver.findElement(By.linkText("Dibya")).click();
	
	wLib.switchToWindow(driver, "Marketing");
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	
	Thread.sleep(3000);
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseHover(driver, ele);
	driver.findElement(By.linkText("Sign Out")).click();
	
	wLib.windowClose(driver);
	
}
}