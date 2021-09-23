package com.crm.Pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AmazonPhoneUnderPrice {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile under 15000");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[3]")).click();
		String price = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText().replace(",", "");
		int actPrice=Integer.parseInt(price);
		Assert.assertTrue(actPrice<150000);
		System.out.println("true");
		driver.close();


	}

}
