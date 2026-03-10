package com.cleargear.pages;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import com.cleargear.base.Base;
import com.cleargear.driver.DriverManager;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

public class POM_UserManagementPage extends Base
{
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public POM_UserManagementPage()
	{
		driver = DriverManager.getDriver();
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	// ================== WebElements ==================

	@FindBy(xpath = "//span[normalize-space()='USER MANAGEMENT']")
	private WebElement User_Management_Header;

	@FindBy(xpath = "//button[normalize-space()='Create New User']/..")
	private WebElement Create_New_User_Button;

	@FindBy(xpath = "//div[contains(@class,'border-dashed')]")
	private WebElement Create_New_User_Table_Header;

	@FindBy(xpath = "//span[normalize-space()='Username']")
	private WebElement Username_Column;

	@FindBy(xpath = "//span[normalize-space()='Employee ID']")
	private WebElement EmployeeID_Column;

	@FindBy(xpath = "//span[normalize-space()='Name']")
	private WebElement Name_Column;

	@FindBy(xpath = "//span[normalize-space()='Email']")
	private WebElement Email_Column;

	@FindBy(xpath = "//span[normalize-space()='Profile']")
	private WebElement Profile_Column;

	@FindBy(xpath = "//span[normalize-space()='Language']")
	private WebElement Language_Column;

	@FindBy(xpath = "//span[normalize-space()='Actions']")
	private WebElement Actions_Column;

	@FindBy(xpath = "(//div[contains(@class,'font-archivo font-normal')]/..)[1]//div")
	private WebElement Create_New_User_Table_Data;
	
	@FindBy(xpath = "//button[normalize-space()='×']")
	private WebElement Close_Popup;

	// ================== Verification Methods ==================

	public void verifyUserManagementHeader() throws Throwable
	{
		Helper.highlightElement(driver, User_Management_Header);
		Rectangle rect = User_Management_Header.getRect();

		Reporter.log("USER MANAGEMENT Header Displayed :- " + User_Management_Header.isDisplayed());
		Reporter.log("USER MANAGEMENT Header Height :- " + rect.getHeight());
		Reporter.log("USER MANAGEMENT Header Width :- " + rect.getWidth());
		Reporter.log("USER MANAGEMENT Header Text :- " + User_Management_Header.getText());

		ExtentReporter.extentReport.setSystemInfo(
				"USER MANAGEMENT Header Displayed :- " + User_Management_Header.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"USER MANAGEMENT Header Height :- " + rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"USER MANAGEMENT Header Width :- " + rect.getWidth(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"USER MANAGEMENT Header Text :- " + User_Management_Header.getText(), null);
	}

	public void verifyTableColumn(WebElement element, String columnName) throws Throwable
	{
		Helper.highlightElement(driver, element);
		Rectangle rect = element.getRect();

		Reporter.log(columnName + " Displayed :- " + element.isDisplayed());
		Reporter.log(columnName + " Height :- " + rect.getHeight());
		Reporter.log(columnName + " Width :- " + rect.getWidth());
		Reporter.log(columnName + " Text :- " + element.getText());

		ExtentReporter.extentReport.setSystemInfo(
				columnName + " Displayed :- " + element.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo(
				columnName + " Height :- " + rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo(
				columnName + " Width :- " + rect.getWidth(), null);
		ExtentReporter.extentReport.setSystemInfo(
				columnName + " Text :- " + element.getText(), null);
	}

	public void verifyCreateNewUserTableData() throws Throwable
	{
		Helper.highlightElement(driver, Create_New_User_Table_Data);
		Rectangle rect = Create_New_User_Table_Data.getRect();

		Reporter.log("Create New User Table Data Displayed :- " + Create_New_User_Table_Data.isDisplayed());
		Reporter.log("Create New User Table Data Height :- " + rect.getHeight());
		Reporter.log("Create New User Table Data Width :- " + rect.getWidth());

		ExtentReporter.extentReport.setSystemInfo(
				"Create New User Table Data Displayed :- " + Create_New_User_Table_Data.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"Create New User Table Data Height :- " + rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"Create New User Table Data Width :- " + rect.getWidth(), null);
	}

	// ================== Utilization ==================

	public void verifyUserManagementPage() throws Throwable
	{
		verifyUserManagementHeader();
		verifyTableColumn(Username_Column, "Username Column");
		verifyTableColumn(EmployeeID_Column, "Employee ID Column");
		verifyTableColumn(Name_Column, "Name Column");
		verifyTableColumn(Email_Column, "Email Column");
		verifyTableColumn(Profile_Column, "Profile Column");
		verifyTableColumn(Language_Column, "Language Column");
		verifyTableColumn(Actions_Column, "Actions Column");
		verifyCreateNewUserTableData();
	}

	public void clickCreateNewUserButton() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Create_New_User_Button));
		Helper.highlightElement(driver, Create_New_User_Button);
		Create_New_User_Button.click();
	}


	public void closeCreateNewUserPopup() throws Throwable 
	{
		wait.until(ExpectedConditions.elementToBeClickable(Close_Popup));
		Helper.highlightElement(driver, Close_Popup);
		Close_Popup.click();
		
	}
}
