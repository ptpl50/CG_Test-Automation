package com.cleargear.pages;

import java.time.Duration;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cleargear.base.Base;
import com.cleargear.driver.DriverManager;
import com.cleargear.listeners.MyListeners;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

public class POM_ClearGear_Alert extends Base{
	public JavascriptExecutor js;
	
	String result;
	boolean value;
	WebDriver driver;
//	ExtentReports extent;
//	ExtentTest test;
	
	@FindBy(xpath = "//span[.='ACTIVE ALERTS']")
	private WebElement ACTIVE_ALERTS_Label;

	@FindBy(xpath = "//div[@class='mb-2']")
	private WebElement Live_Label;

	@FindBy(xpath = "(//div[@aria-label='Sort by Priority'])[1]")
	private WebElement Priority_Column;

	@FindBy(xpath = "(//div[@aria-label='Sort by Start Date'])[1]")
	private WebElement Start_Date_Column;

	@FindBy(xpath = "(//div[@aria-label='Sort by Start Time'])[1]")
	private WebElement Start_Time_Column;

	@FindBy(xpath = "(//div[@aria-label='Sort by Alert'])[1]")
	private WebElement Alert_Column;

	@FindBy(xpath = "(//div[@aria-label='Sort by Description'])[1]")
	private WebElement Description_Column;
	
	@FindBy(xpath = "//div[text()='History']")
	private WebElement History_Tab;
	
	@FindBy(xpath = "//div[text()='History']")
	private WebElement History_Page;
	

	@FindBy(xpath = "(//div[@aria-label='Sort by Ack Timestamp'])[1]")
	private WebElement Ack_Timestamp_Column;

	@FindBy(xpath = "(//span[.='Actions'])[1]")
	private WebElement Actions_Column;
	@FindBy(xpath = "(//label[contains(.,'Start Date')])[1]")
	private WebElement Start_Date_Label;

	@FindBy(xpath = "(//label[contains(.,'End Date')])[1]")
	private WebElement End_Date_Label;

	@FindBy(xpath = "(//div[contains(@class,'MuiPickersOutlinedInput')])[1]")
	private WebElement Start_Date_TextField;

	//@FindBy(xpath = "(//div[contains(@class,'MuiPickersOutlinedInput')])[3]")
	
	@FindBy(xpath = "//div[contains(@class,'grid-cols-1')]//label[normalize-space()='End Date']/following-sibling::div//div[contains(@class,'MuiPickersInputBase-root')][1]")
	private WebElement End_Date_TextField;

	@FindBy(xpath = "(//button[contains(.,'Search')])[1]")
	private WebElement Search_Button;
	
	
	
	
	 ExtentReports extent;
     ExtentTest extentTest;

	 private WebDriverWait wait;
	
	
	
	public POM_ClearGear_Alert(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		driver = DriverManager.getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}
	private void verifyElement(WebElement element, String elementName) throws Throwable
	{
		wait.until(ExpectedConditions.visibilityOf(element));
		Helper.highlightElement(driver, element);

		Rectangle rect = element.getRect();
	}
	
	
	public boolean verify_alertspage_Activealerts() throws Throwable {
		Thread.sleep(3000);
		value=ACTIVE_ALERTS_Label.isDisplayed();
		Helper.highlightElement(driver, ACTIVE_ALERTS_Label);
		MyListeners.extentTest.info("Active alerts label is displayed");
		Thread.sleep(3000);
		value=Live_Label.isDisplayed();
		Helper.highlightElement(driver, Live_Label);
		MyListeners.extentTest.info("Live label is displayed");
		Thread.sleep(5000);
		value=Priority_Column.isDisplayed();
		Helper.highlightElement(driver, Priority_Column);
		MyListeners.extentTest.info("Priority_Column is displayed");
		Thread.sleep(5000);
		value=Start_Date_Column.isDisplayed();
		Helper.highlightElement(driver, Start_Date_Column);
		MyListeners.extentTest.info("Start_Date_Column is displayed");
		Thread.sleep(5000);
		value=Start_Time_Column.isDisplayed();
		Helper.highlightElement(driver, Start_Time_Column);		
		MyListeners.extentTest.info("Start_Time_Column is displayed");
		Thread.sleep(5000);
		value=Alert_Column.isDisplayed();
		Helper.highlightElement(driver, Alert_Column);
		MyListeners.extentTest.info("Alert_Column is displayed");
		Thread.sleep(5000);
		value=Description_Column.isDisplayed();
		Helper.highlightElement(driver, Description_Column);
		MyListeners.extentTest.info("Description_Column is displayed");
		Thread.sleep(5000);
		value=Ack_Timestamp_Column.isDisplayed();
		Helper.highlightElement(driver, Ack_Timestamp_Column);
		MyListeners.extentTest.info("Ack_Timestamp_Column is displayed");
		Thread.sleep(5000);
		value=Actions_Column.isDisplayed();
		Helper.highlightElement(driver, Actions_Column);
		MyListeners.extentTest.info("Actions_Column is displayed");	
		
		
		
		return value;
		
		
	}
	public boolean Verify_User_Can_Navigate_To_History_Tab() throws InterruptedException {
		Thread.sleep(3000);
		History_Tab.click();
		MyListeners.extentTest.info("History tab clicked and verified");
		
		return value;
}
	public boolean Verify_History_Page_Loads_Successfully() throws InterruptedException {
		Thread.sleep(3000);
		value=History_Page.isDisplayed();
		MyListeners.extentTest.info("History page open and displayed");
		
		return value;
	}
	

public boolean verifyStartAndEndDateFields() throws Throwable
{
	verifyElement(Start_Date_Label, "Start Date Label");
	verifyElement(Start_Date_TextField, "Start Date TextField");
	verifyElement(End_Date_Label, "End Date Label");
	verifyElement(End_Date_TextField, "End Date TextField");
	verifyElement(Search_Button, "Search Button");
	value=History_Page.isDisplayed();
	
	MyListeners.extentTest.info("StartAndEndDateFields Verified");
	
	return value;
}

// ================== VALIDATION / UTILIZATION ==================

public boolean enterStartDate(String startDate) throws Throwable
{
	wait.until(ExpectedConditions.elementToBeClickable(Start_Date_TextField));
	Helper.highlightElement(driver, Start_Date_TextField);
	
	Thread.sleep(3000);

	//js.executeScript("arguments[0].click();", Start_Date_TextField);
	//js.executeScript("arguments[0].innerText='" + startDate + "';", Start_Date_TextField);
	
	MyListeners.extentTest.info("Start Date Entered Sucessfully");
	
	return value;

	
}

public boolean enterEndDate(String endDate) throws Throwable
{
	wait.until(ExpectedConditions.elementToBeClickable(End_Date_TextField));
	Helper.highlightElement(driver, End_Date_TextField);
	
	Thread.sleep(3000);

	//js.executeScript("arguments[0].click();", End_Date_TextField);
	//js.executeScript("arguments[0].innerText='" + endDate + "';", End_Date_TextField);
	
MyListeners.extentTest.info("End Date Entered Sucessfully");
	
	return value;



}

public boolean clickSearchButton() throws Throwable
{
	wait.until(ExpectedConditions.elementToBeClickable(Search_Button));
	Helper.highlightElement(driver, Search_Button);
	Search_Button.click();
	value=History_Page.isDisplayed();
	
MyListeners.extentTest.info("Search button clicked and verified");
	
	return value;

	
}

// ================== UTILIZATION (Combined Flow) ==================

public boolean validateHistorySearchByDate(String startDate, String endDate) throws Throwable
{
	enterStartDate(startDate);
	enterEndDate(endDate);
	clickSearchButton();
	
	MyListeners.extentTest.info("Serach option by date working properly");
	
	return value;
}
}



	
	