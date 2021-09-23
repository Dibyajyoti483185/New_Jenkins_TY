package com.crm.Pratice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Naukri  {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.naukri.com/");
		
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		while(it.hasNext()) {
			String winId = it.next();
			String actTitle = driver.switchTo().window(winId).getTitle();
			if(actTitle.contains("9sep2021")) {
				driver.switchTo().window(actTitle);
				break;
			}
			
		}
		driver.close();
		
		Thread.sleep(7000);
		
		driver.quit();	

	}
}
