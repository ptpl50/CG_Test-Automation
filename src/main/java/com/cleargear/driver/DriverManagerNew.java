package com.cleargear.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManagerNew {
	
	 private DriverManagerNew(){}

	    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    public static void setDriver(WebDriver driverRef) {
	        driver.set(driverRef);
	    }

	    public static void unload() {
	        driver.remove();
	    }

}
