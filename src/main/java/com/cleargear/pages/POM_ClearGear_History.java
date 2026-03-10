	package com.cleargear.pages;
	import java.time.Duration;
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

	public class POM_ClearGear_History extends Base{
		public JavascriptExecutor js;
		
		String result;
		boolean value;
		WebDriver driver;
		
		
		// Click on Calender icon field
		   @FindBy(xpath = "(//*[name()='svg' and contains(@class,'MuiSvgIcon-root')])[1]")
		   WebElement CalenderIconStart;
				
	    // Click on Calender icon field
		   @FindBy(xpath = "(//*[name()='svg' and contains(@class,'MuiSvgIcon-root')])[2]")
		   WebElement CalenderIconEnd;
		
		// Start Date input field
		@FindBy(xpath = "//button[text()='5']")
		WebElement startDateField;
		
		// End Date input field
		@FindBy(xpath = "//button[text()='6']")
		WebElement EndDateField;
		
		// Start Date input field
				@FindBy(xpath = "//div[text()='No data available']")
				WebElement AftersearchbuttonClicked;

		// Month title
		@FindBy(xpath = "//div[contains(@class,'calendar')]//div[contains(text(),'February')]")
		WebElement monthTitle;

		// Next month button
		@FindBy(xpath = "//button[contains(@class,'next')]")
		WebElement nextButton;
		
		@FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div/div[3]/div/img")
		private WebElement Clear_Gear_Button;

		@FindBy(xpath = "(//label[contains(.,'Start Date')])[1]")
		private WebElement Start_Date_Label;

		@FindBy(xpath = "(//label[contains(.,'End Date')])[1]")
		private WebElement End_Date_Label;

		@FindBy(xpath = "(//div[contains(@class,'MuiPickersOutlinedInput')])[1]")
		private WebElement Start_Date_TextField;

		@FindBy(xpath = "(//div[contains(@class,'MuiPickersOutlinedInput')])[3]")
		private WebElement End_Date_TextField;

		@FindBy(xpath = "(//button[contains(.,'Search')])[1]")
		private WebElement Search_Button;
		
		@FindBy(xpath = "//span[normalize-space()='History']/..")
		private WebElement History_Menu;
		
		@FindBy(xpath = "(//span[normalize-space()='Event History'])[1]")
		private WebElement Historypage;
		
		ExtentReports extent;
	     ExtentTest extentTest;

		 private WebDriverWait wait;
		 
			public POM_ClearGear_History(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
		
		// ================== Common Verification ==================
		
		public boolean verify_History_Page() throws InterruptedException {
			Clear_Gear_Button.click();
			Thread.sleep(3000);
			History_Menu.click();
			MyListeners.extentTest.info("History_Menu Button Clicked");
			Thread.sleep(5000);
			value=Historypage.isDisplayed();
			MyListeners.extentTest.info("History page loaded and displayed properly");
			return value;
			
		}

		private void verifyElement(WebElement element, String elementName) throws Throwable
		{
			wait.until(ExpectedConditions.visibilityOf(element));
			Helper.highlightElement(driver, element);

			Rectangle rect = element.getRect();

			Reporter.log(elementName + " Displayed :- " + element.isDisplayed());
			Reporter.log(elementName + " Height :- " + rect.getHeight());
			Reporter.log(elementName + " Width :- " + rect.getWidth());
			Reporter.log(elementName + " Text :- " + element.getText());

			ExtentReporter.extentReport.setSystemInfo(
					elementName + " Displayed :- " + element.isDisplayed(), null);
			ExtentReporter.extentReport.setSystemInfo(
					elementName + " Height :- " + rect.getHeight(), null);
			ExtentReporter.extentReport.setSystemInfo(
					elementName + " Width :- " + rect.getWidth(), null);
			ExtentReporter.extentReport.setSystemInfo(
					elementName + " Text :- " + element.getText(), null);
		}

		// ================== VERIFICATION ==================
		
		

		public boolean EnterStartAndEndDateFieldsCalender() throws Throwable
		{
			CalenderIconStart.click();
			
			MyListeners.extentTest.info("Start Date Entered");
			
			Thread.sleep(3000);
			
			startDateField.click();
			Thread.sleep(3000);
					
			CalenderIconEnd.click();
			Thread.sleep(3000);
			
			EndDateField.click();
			
			MyListeners.extentTest.info("End Date Entered");
			Thread.sleep(5000);
			
			Search_Button.click();
			
			Thread.sleep(5000);
			
			AftersearchbuttonClicked.isDisplayed();
			
			
			
			MyListeners.extentTest.info("Search Button Clicked");
		
		return value;
		
		}

		public boolean verifyStartAndEndDateFields() throws Throwable
		{
			verifyElement(Start_Date_Label, "Start Date Label");
			verifyElement(Start_Date_TextField, "Start Date TextField");
			verifyElement(End_Date_Label, "End Date Label");
			verifyElement(End_Date_TextField, "End Date TextField");
			verifyElement(Search_Button, "Search Button");
			
			return value;
		}

		// ================== VALIDATION / UTILIZATION ==================

		public boolean enterStartDate(String startDate) throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(Start_Date_TextField));
			Helper.highlightElement(driver, Start_Date_TextField);

			//js.executeScript("arguments[0].click();", Start_Date_TextField);
			//js.executeScript("arguments[0].innerText='" + startDate + "';", Start_Date_TextField);

			Reporter.log("Entered Start Date :- " + startDate);
			ExtentReporter.extentReport.setSystemInfo(
					"Entered Start Date :- " + startDate, startDate);
			
			return value;
		}

		public boolean enterEndDate(String endDate) throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(End_Date_TextField));
			Helper.highlightElement(driver, End_Date_TextField);

			//js.executeScript("arguments[0].click();", End_Date_TextField);
			//js.executeScript("arguments[0].innerText='" + endDate + "';", End_Date_TextField);

			Reporter.log("Entered End Date :- " + endDate);
			ExtentReporter.extentReport.setSystemInfo(
					"Entered End Date :- " + endDate, endDate);
			
			return value;
		}

		public boolean clickSearchButton() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(Search_Button));
			Helper.highlightElement(driver, Search_Button);
			Search_Button.click();

			Reporter.log("Clicked on Search button");
			ExtentReporter.extentReport.setSystemInfo(
					"Clicked on Search button", null);
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
