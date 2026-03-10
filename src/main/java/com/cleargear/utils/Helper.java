package com.cleargear.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper
{
	public static void highlightElement(WebDriver driver ,WebElement element) throws Throwable
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style','background : red')", element);
		Thread.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style','background : green')", element);
	}

}
