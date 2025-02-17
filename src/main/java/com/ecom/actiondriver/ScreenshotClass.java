/**
 * 
 */
package com.ecom.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.ecom.base.BaseClass;

/**
 * 
 */
public class ScreenshotClass extends BaseClass {

	
	public String captureScreenshot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8080/job/EcomAutomationProject/ws/EcomAutomationProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
//		return destination;
	}
}
