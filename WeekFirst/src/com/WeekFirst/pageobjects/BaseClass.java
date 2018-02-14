/**
 * 
 */
package com.WeekFirst.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.WeekFirst.utils.TakeScreenShot;

/**
 * @author Vikash.Singh
 *
 */

public class BaseClass {

	static WebDriver driver;
	static String url = "https://www.orbitz.com/";
	public static void main(String[] args) throws InterruptedException {
		BaseClass.launchBrowser();
		TakeScreenShot.captureScreenShot(driver);
		FlightSearch search = new FlightSearch(driver);
		search.selectProduct();
		search.selectOriginCity();
		search.selectDestinationCity();
		search.selectJourneyDate();
		search.searchFLight();
		Thread.sleep(2000);
		TakeScreenShot.captureScreenShot(driver);
		BaseClass.closeBrowser();
	}
	public static void launchBrowser() {
		// Here I am setting up the path for ChromeDriver
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver_win32\\chromedriver.exe");
		try{
			driver = new ChromeDriver();
		}
		catch(Exception e){
			System.out.println("Not able to launch browser "+e.getMessage());
		}
		driver.get(url);
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		//String pageTitleExpected = "ORBITZ.com – Best Travel Deals";
		System.out.println(pageTitle);
		
	}

	public static void closeBrowser() {
		driver.close();
		System.out.println("Passed succesfully");
	}

}
