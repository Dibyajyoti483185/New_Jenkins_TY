package com.crm.autodesk.TestCases;

import java.util.List;

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

public class TC_05_CreateLeadAndEdit {
	WebDriver driver;
	@Test

	public void createLeadAndEdit() throws Throwable {



		JSONFileUtility jsLib=new JSONFileUtility();
		JavaUtility jLib =new JavaUtility();
		WebDriverUtilities wLib= new WebDriverUtilities();
		ExcelUtility eLib = new ExcelUtility();

		String BROWSER = jsLib.readDataFromJSON("browser");
		String URL = jsLib.readDataFromJSON("url");
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");


		String productName = eLib.getExcelData("Sheet1", 1, 4);
		String partNo = eLib.getExcelData("Sheet1", 1, 5)+jLib.getRandomNum();

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

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		WebElement fName = driver.findElement(By.name("salutationtype"));
		wLib.dropDown(fName, "Mr.");
		driver.findElement(By.name("firstname")).sendKeys("Dibyajyoti Satyapriya");
		driver.findElement(By.name("lastname")).sendKeys("Sahoo");
		driver.findElement(By.name("company")).sendKeys("TestYantra");
		driver.findElement(By.id("designation")).sendKeys("Automation Engineer");
		driver.findElement(By.id("phone")).sendKeys("7978451478");
		driver.findElement(By.id("mobile")).sendKeys("7978451478");
		driver.findElement(By.id("fax")).sendKeys("0674212223");
		driver.findElement(By.id("email")).sendKeys("dibyajyoti483185@gmail.com");
		driver.findElement(By.name("website")).sendKeys("www.testyantra.com");
		driver.findElement(By.name("annualrevenue")).sendKeys("5000000");
		driver.findElement(By.id("noofemployees")).sendKeys("2000");
		driver.findElement(By.id("secondaryemail")).sendKeys("mitusoa@gmail.com");
		WebElement leadSource = driver.findElement(By.name("leadsource"));
		wLib.dropDown(leadSource, "Partner");
		WebElement industry = driver.findElement(By.name("industry"));
		wLib.dropDown(industry, "Education");
		WebElement leadStatus = driver.findElement(By.name("leadstatus"));
		wLib.dropDown(leadStatus,"Hot");
		WebElement rating = driver.findElement(By.name("rating"));
		wLib.dropDown(rating, "Active");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		WebElement assignedGroupId = driver.findElement(By.name("assigned_group_id"));
		wLib.dropDown(assignedGroupId, "Marketing Group");
		driver.findElement(By.name("lane")).sendKeys("M.I.G-1,38/2,H.B.COLONY,PHASE-1");
		driver.findElement(By.id("pobox")).sendKeys("C.S.PUR");
		driver.findElement(By.id("code")).sendKeys("751016");
		driver.findElement(By.id("city")).sendKeys("BHUBANESWAR");
		driver.findElement(By.id("country")).sendKeys("INDIA");
		driver.findElement(By.id("state")).sendKeys("ODISHA");
		driver.findElement(By.name("description")).sendKeys("This is the best institution for Automation");
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		driver.findElement(By.xpath("//input[@title='Edit [Alt+E]']")).click();

		driver.findElement(By.xpath("//input[@value='U']")).click();
		
		driver.findElement(By.name("company")).clear();
		driver.findElement(By.name("company")).sendKeys("BrillQuest Technologies PVT. LTD.");
		driver.findElement(By.name("website")).clear();
		driver.findElement(By.name("website")).sendKeys("www.brillquest.com");
		WebElement assignedGroupId1= driver.findElement(By.name("assigned_user_id"));
		wLib.dropDown(assignedGroupId1, "Administrator");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		String expectedResult = driver.findElement(By.xpath("//td[contains(text(),'LE')]")).getText();
		driver.findElement(By.linkText("Leads")).click();

		List<WebElement> list = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[2]"));
		for(WebElement wb:list) {

			String  actualResult= wb.getText();
			if(expectedResult.contains(actualResult))
			{
				System.out.println("lead created and displayed in product list successfully");
				break;
			}

		}

		Thread.sleep(3000);
		WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wLib.mouseHover(driver, ele2);
		
		driver.findElement(By.linkText("Sign Out")).click();
		 wLib.windowClose(driver);


		




	}
}
