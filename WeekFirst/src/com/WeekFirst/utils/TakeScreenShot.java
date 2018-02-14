package com.WeekFirst.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Vikash.Singh
 * 
 *         common method to capture screenshot.
 *
 */

public class TakeScreenShot {

	public static void captureScreenShot(WebDriver driver) {

		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile,
					new File("D:/Assignments/WeekFirst/ScreenShots" + System.currentTimeMillis() + ".png"));
			System.out.println("Screenshot is captured successfully and saved to project");
		} catch (Exception e) {

			System.out.println(e.getMessage());

		}

	}

}
