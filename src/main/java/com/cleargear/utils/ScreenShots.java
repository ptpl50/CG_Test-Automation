package com.cleargear.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cleargear.driver.DriverManager;
import com.cleargear.driver.DriverManagerNew;

public final class ScreenShots {
	
	 private ScreenShots() {
	        // Prevent object creation
	    }
	 public static String getBase64image() {
		 
		 String base64Screenshot = "";

	        try {
	            WebDriver driver = DriverManagerNew.getDriver(); // Your Driver manager
	            base64Screenshot = ((TakesScreenshot) driver)
	                    .getScreenshotAs(OutputType.BASE64);

	        } catch (Exception e) {
	            System.out.println("Screenshot capture failed: " + e.getMessage());
	        }

	        return base64Screenshot;
	    }
	 

}
