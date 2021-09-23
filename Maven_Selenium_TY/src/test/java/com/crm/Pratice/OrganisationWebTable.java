package com.crm.Pratice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.autodesk.GenericUtilities.JSONFileUtility;

public class OrganisationWebTable {
	
	@Test
	public void organisationTest() throws Throwable {
		
		JSONFileUtility jsu=new JSONFileUtility();
		String BROWSER = jsu.readDataFromJSON("browser");
		String URL = jsu.readDataFromJSON("url");
		String USERNAME = jsu.readDataFromJSON("username");
		String PASSWORD = jsu.readDataFromJSON("password");
		
		WebDriver driver=null;
		if(BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		else if(BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		else {
			System.out.println("invalid browser");
		}
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		/*1.select all;
		 * 2.deselect last element;
		 * 3.select 3rd element;
		 */
		
		/*List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
		for( WebElement wb:list) {
			wb.click();
		}
		 list.get(list.size()-1).click();
		 
		 for(int i=1;i<list.size();i++) {
			 
			 if(i==2)
				 list.get(i).click();
		 }*/
		
		
		
		/*1.print all organization name*/
		/*List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']"));
		for( WebElement wb:list) {
			System.out.println(wb.getText());
		}*/
		
		
		
		/*
		 * select and delete a particular data;
		 */
		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		for(int i=1;i<list.size();i++) {
			 
			 if(i==2)
				 list.get(i).click();
		 }
		Thread.sleep(2000);
		
		List<WebElement> list1 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[8]/a[text()='del']"));
		for(int i=1;i<list1.size();i++) {
			if(i==2) {
				list1.get(i).click();
				driver.switchTo().alert().accept();
			}
			
		}
		Thread.sleep(5000);
		 
		 driver.close();
		 
	}

	
	}
	


