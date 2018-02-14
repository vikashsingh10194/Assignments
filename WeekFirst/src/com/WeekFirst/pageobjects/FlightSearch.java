package com.WeekFirst.pageobjects;

import java.text.SimpleDateFormat;

/**
 * @author Vikash.Singh
 *This test case will perform action on flight home page.
 *
 */
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlightSearch {
	WebDriver driver;
	By Product = By.xpath("//*[@id='primary-header-flight']");
	By oneWay = By.xpath("//*[@id='flight-type-one-way-label']");
	By SourceBox = By.xpath("//*[@id='flight-origin']");
	By destinationBox = By.xpath("//*[@id='flight-destination']");
	By searchButton = By.xpath("//*[@id='search-button']");
	By onwardDate = By.xpath("//*[@id='flight-departing']");

	public FlightSearch(WebDriver driver) {

		this.driver = driver;
	}

	public void selectProduct() throws InterruptedException {

		driver.findElement(Product).click();
		driver.findElement(oneWay).click();
		//Thread.sleep(2000);

	}

	public void selectOriginCity() {

		driver.findElement(SourceBox).sendKeys("Mumbai, India (BOM-Chhatrapati Shivaji Intl.)");

	}

	public void selectDestinationCity() throws InterruptedException {
		driver.findElement(destinationBox).sendKeys("Bengaluru, India (BLR-Kempegowda Intl.)");
		 Thread.sleep(1000);

	}

	public void selectJourneyDate() throws InterruptedException {
		driver.findElement(onwardDate).click();
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/YYYY");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendar.DATE, 5);
		date = calendar.getTime();

		String stringFormat = format.format(date);

		driver.findElement(onwardDate).sendKeys(stringFormat);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='datepicker-close-btn close btn-text']")).click();
		System.out.println("Selected departing date");
	}

	public void searchFLight() {

		driver.findElement(searchButton).click();

	}

}
