package com.cleargear.commonfunction;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleargear.driver.DriverManagerNew;
import com.cleargear.utils.ExtentreportTestManager;

public abstract class CommonFunction {
	
	protected CommonFunction() {}
	
	 private static final int DEFAULT_TIMEOUT = 30;
	 
	 
	 
	 // =========================
	    // Basic Element Actions
	    // =========================
	 
	 
	 
//*******************************click Action**************************************************************
	    public static void click(WebElement element,String ename) {
	        try {
	        	waitForClickable(element);
	        	element.click();
	        	ExtentreportTestManager.getExtentTest().info("Clicked on "+ename);
			} catch (Exception e) {
				// TODO: handle exception'
				ExtentreportTestManager.getExtentTest().fail(ename+" not clicked");
				System.out.println(e.getMessage());
			}
	        
	    }
	    
	    public static void clickUsingJS(WebElement element, String elementName) {

	        try {

	            waitForVisible(element);

	            JavascriptExecutor js = (JavascriptExecutor) DriverManagerNew.getDriver();

	            js.executeScript("arguments[0].click();", element);

	            ExtentreportTestManager.getExtentTest().info("Clicked on : " + elementName + " using JavaScript");

	        } catch (Exception e) {

	        	ExtentreportTestManager.getExtentTest().fail("Unable to click on : " + elementName + " using JavaScript");

	            throw e;
	        }
	    }
	    
//*******************************waitfor clickable*****************************************************************	    
	    
	    public static void waitForClickable(WebElement element) {

	        WebDriverWait wait = new WebDriverWait(
	                DriverManagerNew.getDriver(),
	                Duration.ofSeconds(DEFAULT_TIMEOUT)
	        );

	        wait.until(ExpectedConditions.elementToBeClickable(element));

	    }
	    
	    
	    public static void waitForVisible(WebElement element) {

	        WebDriverWait wait = new WebDriverWait(
	                DriverManagerNew.getDriver(),
	                Duration.ofSeconds(DEFAULT_TIMEOUT)
	        );

	        wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    
//********************************sendkeys actions ****************************************************************
	    public static void sendKeys(WebElement element, String value, String elementName) {

	        try {

	            waitForVisible(element);

	            element.clear();
	            element.sendKeys(value);

	            ExtentreportTestManager.getExtentTest().info("Entered '" + value + "' into : " + elementName);

	        } catch (Exception e) {

	        	ExtentreportTestManager.getExtentTest().fail("Unable to enter '" + value + "' into : " + elementName);

	            throw e; // Important → fail the test
	        }
	    }
	    
	    public static void sendKeysUsingJS(WebElement element, String value, String elementName) {

	        try {

	            waitForVisible(element);

	            JavascriptExecutor js = (JavascriptExecutor) DriverManagerNew.getDriver();

	            js.executeScript("arguments[0].value='" + value + "';", element);

	            ExtentreportTestManager.getExtentTest().info("Entered '" + value + "' into : " + elementName + " using JavaScript");

	        } catch (Exception e) {

	        	ExtentreportTestManager.getExtentTest().fail("Unable to enter '" + value + "' into : " + elementName + " using JavaScript");

	            throw e;
	        }
	    }    
	    
	//**********************************scroll to an element************************************************************
	    
	    public static void scrollToElement(WebElement element, String elementName) {

	        try {

	            JavascriptExecutor js = (JavascriptExecutor) DriverManagerNew.getDriver();

	            js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);

	            ExtentreportTestManager.getExtentTest().info("Scrolled to : " + elementName);

	        } catch (Exception e) {

	        	ExtentreportTestManager.getExtentTest().fail("Unable to scroll to : " + elementName);

	            throw e;
	        }
	    }
	    
// ***********************************Highilighting an element*************************************************************
	    
	    
	    public static void highlightElement(WebElement element, String elementName) {

	        try {

	            JavascriptExecutor js = (JavascriptExecutor) DriverManagerNew.getDriver();

	            js.executeScript(
	                    "arguments[0].style.border='3px solid red'; arguments[0].style.backgroundColor='green';",
	                    element
	            );

	            //ExtentreportTestManager.getExtentTest().info("Highlighted element : " + elementName);

	        } catch (Exception e) {

	        	//ExtentreportTestManager.getExtentTest().fail("Unable to highlight element : " + elementName);

	            throw e;
	        }
	    }

}
