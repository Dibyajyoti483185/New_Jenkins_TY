package com.crm.autodesk.GenericUtilities;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
/**
 * This class contains generic method related to webdriver actions
 * @author Dibyajyoti
 *
 */

public class WebDriverUtilities { 
/**
 * This will wait for the page load for 10 seconds 	
 * @param driver
 */
	public void waitForpageLoad(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void windowClose(WebDriver driver) {
		driver.close();
	}
	/**
	 * This method will select from the dropdown using visible text
	 * @param ele
	 * @param text
	 */
	
	public void dropDown(WebElement ele,String text) {
		
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		}
		
	/**
	 * This method will select from the dropdown using index
	 * @param ele
	 * @param index
	 */
      public void dropDown(WebElement ele,int index) {
		
		Select s=new Select(ele);
		s.selectByIndex(index);
		}
	public void switchFrame(WebDriver driver) {
		driver.switchTo().frame(0);
		
	}
	
	public void switchBackFrame(WebDriver driver) {
		driver.switchTo().defaultContent();
		
	}
	/**
	 * This method is used for mouse hover action
	 * @param driver
	 * @param ele
	 */
	
	public void mouseHover(WebDriver driver,WebElement ele) {
		 Actions a=new Actions(driver);
		 a.moveToElement(ele).perform();
	}
	/**
	 * This method is used for double click action
	 * @param driver
	 * @param ele
	 */
	public void doubleClick(WebDriver driver,WebElement ele) {
		 Actions a=new Actions(driver);
		a.doubleClick(ele).perform();
		}
	/**
	 * This method is used for right click action 
	 * @param driver
	 * @param ele
	 */
	public void rightClick(WebDriver driver,WebElement ele) {
		 Actions a=new Actions(driver);
		a.contextClick(ele).perform();
	}
	public void dragDrop(WebDriver driver,WebElement source,WebElement target) {
		 Actions a=new Actions(driver);
		 a.dragAndDrop(source, target).perform();
	}
	public void scrollBar(WebDriver driver,int x,int y) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	/**
	 * Accept the alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
		
	}
	/**
	 * Dismiss the alert popup
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will switch to window wrt partial window title
	 * @param driver
	 */
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		while(it.hasNext()) {
			String winId = it.next();
			String actTitle = driver.switchTo().window(winId).getTitle();
			if(actTitle.contains(partialWinTitle)) {
				driver.switchTo().window(actTitle);
				break;
			}
			
		}
		
	}
}
