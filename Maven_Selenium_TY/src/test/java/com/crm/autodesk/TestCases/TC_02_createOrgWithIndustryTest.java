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

public class TC_02_createOrgWithIndustryTest {
	WebDriver driver;
	@Test
	public void createOrgEduTest() throws Throwable {
	JSONFileUtility jsLib=new JSONFileUtility();
	JavaUtility jLib =new JavaUtility();
	WebDriverUtilities wLib= new WebDriverUtilities();
	ExcelUtility eLib = new ExcelUtility();
	
	String BROWSER = jsLib.readDataFromJSON("browser");
	String URL = jsLib.readDataFromJSON("url");
	String USERNAME = jsLib.readDataFromJSON("username");
	String PASSWORD = jsLib.readDataFromJSON("password");
	String orgName = eLib.getExcelData("Sheet1", 1, 2);
	String indusrtyName = eLib.getExcelData("Sheet1", 1, 3);
	
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
	
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	driver.findElement(By.name("accountname")).sendKeys(orgName+jLib.getRandomNum());
	
	WebElement ele = driver.findElement(By.name("industry"));
	wLib.dropDown(ele,indusrtyName);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	/*WebElement ele1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	wLib.mouseHover(driver, ele1);
	Thread.sleep(2000);
	driver.findElement(By.linkText("Sign Out")).click();*/

	wLib.windowClose(driver);


}
}