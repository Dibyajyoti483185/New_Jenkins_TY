package com.crm.autodesk.GenericUtilities;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.elementRepository.HomePage;
import com.crm.autodesk.elementRepository.LoginPage;

public class BaseClass {
	
	public DataBaseUtility dbLib=new DataBaseUtility();
	public JSONFileUtility jsLib=new JSONFileUtility();
	public JavaUtility jLib =new JavaUtility();
	public WebDriverUtilities wLib= new WebDriverUtilities();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriver driver;
	public static WebDriver staticdriver;
	@BeforeSuite(groups = {"SmokeSuite","RegressionSuite"})
	public void connectDB() throws Throwable {
		
		System.out.println("=====Connect to DataBase========");
		//dbLib.connectToDB(); 
		}
	//@Parameters("Browser")
	@BeforeClass(groups = {"SmokeSuite","RegressionSuite"})
	public void launchBrowser() throws Throwable {
		System.out.println("=====Launch The Browser========");
		String BROWSER = jsLib.readDataFromJSON("browser");
		String URL = jsLib.readDataFromJSON("url");
		

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
		staticdriver= driver;
	}
	
	@BeforeMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logIntoApp() throws Throwable {
		System.out.println("=====Login to Application========");
		String USERNAME = jsLib.readDataFromJSON("username");
		String PASSWORD = jsLib.readDataFromJSON("password");
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
	}
	@AfterMethod(groups = {"SmokeSuite","RegressionSuite"})
	public void logoutFromApp() {
		System.out.println("=====Logout From Application========");
		HomePage hp=new HomePage(driver);
		hp.signOut(driver);
	}
	@AfterClass(groups = {"SmokeSuite","RegressionSuite"})
	public void closeBrowser() {
		System.out.println("=====Close The Browser========");
		wLib.windowClose(driver);
	}
	
	@AfterSuite
	public void closeDB() throws Throwable {
		System.out.println("=====Close The DataBase========");
		//dbLib.closeDB();
	}
	public String getsscreenShot(String name) throws Throwable {
		File srcfile=((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);;
		String destfile=System.getProperty("user.dir")+"/Screenshots/"+name+".png";
		File finaldest=new File(destfile);
		FileUtils.copyFile(srcfile, finaldest);
		
		return destfile;
		
		
	}
}

