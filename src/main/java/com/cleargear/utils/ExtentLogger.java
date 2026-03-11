package com.cleargear.utils;
import com.aventstack.extentreports.MediaEntityBuilder;

public final class ExtentLogger {
     
	 public static void pass(String message) {
	        ExtentreportTestManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(
                    ScreenShots.getBase64image()
            ).build());
	    }
	 
	 public static void fail(String message) {
		    ExtentreportTestManager.getExtentTest().fail(
		            message,
		            MediaEntityBuilder.createScreenCaptureFromBase64String(
		                    ScreenShots.getBase64image()
		            ).build()
		    );
		}
	 
	 public static void skip(String message) {
	        ExtentreportTestManager.getExtentTest().skip(message);
	    }

	 public static void warning(String message) {
	        ExtentreportTestManager.getExtentTest().warning(message);
	    }
    
	 public static void info(String message) {
	        ExtentreportTestManager.getExtentTest().info(message);
	    }
	
	
}
