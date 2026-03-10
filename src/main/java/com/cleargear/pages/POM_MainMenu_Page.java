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

public class POM_MainMenu_Page extends Base
{
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public POM_MainMenu_Page()
	{
		driver = DriverManager.getDriver();
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	// ================== WebElements ==================

	@FindBy(xpath = "//span[contains(@class,'font-medium')] | //span[contains(.,'Welcome')]")
	private WebElement Welcome_User_Text;

	@FindBy(xpath = "//button[normalize-space()='Logout']")
	private WebElement Logout_Button;

	@FindBy(xpath = "//body/div/div/main/div/div/div/div[1] | //span[contains(.,'Operations Overview')]/..")
	private WebElement Operations_Overview_Button;

	@FindBy(xpath = "//body//div//div//div[2] | //span[contains(.,'Clear Flow')]/..")
	private WebElement Clear_Flow_Button;

	//@FindBy(xpath = "//body//div//div//div[3] | //span[contains(.,'Clear Gear')]/..")
	@FindBy(xpath = "//div[contains(@class,'w-fit grid gap-x-12 gap-y-8 place-items-center')]/div[contains(@class,'w-fit md:w-[192px] sm:bg-white flex flex-col items-center justify-center space-y-4 rounded-xl')][3]")
	private WebElement Clear_Gear_Button;

	@FindBy(xpath = "//body//div//div//div[4] | //span[contains(.,'Clear Team')]/..")
	private WebElement Clear_Team_Button;

	@FindBy(xpath = "//body//div//div//div[5] | //span[contains(.,'Clear Slot')]/..")
	private WebElement Clear_Slot_Button;

	@FindBy(xpath = "//body//div//div//div[6] | //span[contains(.,'System Health')]/..")
	private WebElement System_Health_Button;

	@FindBy(xpath = "//body//div//div//div[7] | //span[contains(.,'User Management')]/..")
	private WebElement User_Management_Button;

	@FindBy(xpath = "//body//div//div//div[8] | //span[contains(.,'Settings')]/..")
	private WebElement Settings_Button;

	// ================== Verification Methods ==================

	public void verifyWelcome_User_Text() throws Throwable
	{
		Helper.highlightElement(driver, Welcome_User_Text);
	    Rectangle rect = Welcome_User_Text.getRect();
		Reporter.log("Welcome_User_Text Displayed :- " + Welcome_User_Text.isDisplayed());
		Reporter.log("Welcome_User_Text Height :- " + rect.getHeight());
		Reporter.log("Welcome_User_Text Width :- " + rect.getWidth());
		Reporter.log("Welcome_User_Text Text :- " + Welcome_User_Text.getText());

		ExtentReporter.extentReport.setSystemInfo(
				"Welcome_User_Text Displayed :- " + Welcome_User_Text.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"Welcome_User_Text Height :- " + rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"Welcome_User_Text Width :- " + rect.getWidth(), null);
		ExtentReporter.extentReport.setSystemInfo(
				"Welcome_User_Text Text :- " + Welcome_User_Text.getText(), null);
	}

	public void verifyMenu_Button(WebElement element, String menuName) throws Throwable
	{
		Helper.highlightElement(driver, element);
		Rectangle rect = element.getRect();

		Reporter.log(menuName + " Displayed :- " + element.isDisplayed());
		Reporter.log(menuName + " Height :- " + rect.getHeight());
		Reporter.log(menuName + " Width :- " + rect.getWidth());
		Reporter.log(menuName + " Text :- " + element.getText());

		ExtentReporter.extentReport.setSystemInfo(
				menuName + " Displayed :- " + element.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo(
				menuName + " Height :- " + rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo(
				menuName + " Width :- " + rect.getWidth(), null);
		ExtentReporter.extentReport.setSystemInfo(
				menuName + " Text :- " + element.getText(), null);
	}

	// ================== Utilization ==================

	public void verifyMainMenu() throws Throwable
	{
		verifyWelcome_User_Text();
		verifyMenu_Button(Operations_Overview_Button, "Operations Overview Button");
		verifyMenu_Button(Clear_Flow_Button, "Clear Flow Button");
		verifyMenu_Button(Clear_Gear_Button, "Clear Gear Button");
		verifyMenu_Button(Clear_Team_Button, "Clear Team Button");
		verifyMenu_Button(Clear_Slot_Button, "Clear Slot Button");
		verifyMenu_Button(System_Health_Button, "System Health Button");
		verifyMenu_Button(User_Management_Button, "User Management Button");
		verifyMenu_Button(Settings_Button, "Settings Button");
	}

	public void clickOperations_Overview_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Operations_Overview_Button));
		Helper.highlightElement(driver, Operations_Overview_Button);
		Operations_Overview_Button.click();
	}

	public void clickClear_Flow_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Clear_Flow_Button));
		Helper.highlightElement(driver, Clear_Flow_Button);
		Clear_Flow_Button.click();
	}

	public void clickClear_Gear_Button() throws Throwable
	{
		
		wait.until(ExpectedConditions.elementToBeClickable(Clear_Gear_Button));
		Helper.highlightElement(driver, Clear_Gear_Button);
		Clear_Gear_Button.click();
	}

	public void clickClear_Team_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Clear_Team_Button));
		Helper.highlightElement(driver, Clear_Team_Button);
		Clear_Team_Button.click();
	}

	public void clickClear_Slot_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Clear_Slot_Button));
		Helper.highlightElement(driver, Clear_Slot_Button);
		Clear_Slot_Button.click();
	}

	public void clickSystem_Health_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(System_Health_Button));
		Helper.highlightElement(driver, System_Health_Button);
		System_Health_Button.click();
	}

	public void clickUser_Management_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(User_Management_Button));
		Helper.highlightElement(driver, User_Management_Button);
		User_Management_Button.click();
	}

	public void clickSettings_Button() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Settings_Button));
		Helper.highlightElement(driver, Settings_Button);
		Settings_Button.click();
	}

	public void clickLogout() throws Throwable
	{
		wait.until(ExpectedConditions.elementToBeClickable(Logout_Button));
		Helper.highlightElement(driver, Logout_Button);
		Logout_Button.click();
	}
}

