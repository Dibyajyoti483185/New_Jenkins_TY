package com.crm.Pratice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestionLensKart {
	public static void main(String[] args) {
		
	

	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.lenskart.com/");
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	driver.findElement(By.name("q")).click();
	List<WebElement> suggest = driver.findElements(By.xpath("//div[@class='trending']"));
	for(WebElement b:suggest)
	 {
		 System.out.println(b.getText());
		 
		 
	 }
	 driver.close();
	}
}
