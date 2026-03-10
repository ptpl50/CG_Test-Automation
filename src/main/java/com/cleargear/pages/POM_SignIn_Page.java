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
import com.cleargear.listeners.MyListeners;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

public class POM_SignIn_Page extends Base
{
	public JavascriptExecutor js;
	public WebDriverWait wait;
	public POM_SignIn_Page() 
	{
		driver=DriverManager.getDriver();
		this.js=(JavascriptExecutor)driver;
		this.wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[normalize-space()='Sign In']")
	private WebElement Sign_in_Page_Header;
	@FindBy(xpath = "//button[contains(@id,'trigger-username')]" )
	private WebElement UsernameTab;
	@FindBy(xpath = "//button[contains(@id,'trigger-badge')]")
	private WebElement BadgeTab;
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement Username_Text_Field;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement Password_Text_Field;
	@FindBy(xpath = "//button[@aria-label='Show password']//*[name()='svg']/..")
	private WebElement Show_Password_Button;
	@FindBy(xpath = "//img[@alt='TopHat']")
	private WebElement TopHat_Logo;
	@FindBy(xpath = "//button[@aria-label='Open Tanstack query devtools']/..")
	private WebElement Open_Tanstack_query_devtools_Button;
	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	private WebElement SignInButton;
	@FindBy(xpath ="//input[@placeholder='Bagde ID']/../..")
	private WebElement Badge_ID_TextField;


	
	public void verifySign_in_Header() throws Throwable
	{
		
		Helper.highlightElement(driver, Sign_in_Page_Header);
		Rectangle Sign_in_Page_Header_rect = Sign_in_Page_Header.getRect();
		Reporter.log("Sign_in_Page_Header is Displayed :-"+Sign_in_Page_Header.isDisplayed());
		Reporter.log( "Sign_in_Page_Header  Height is :-"+ Sign_in_Page_Header_rect.getHeight());
		Reporter.log( "Sign_in_Page_Header  Width is :-"+Sign_in_Page_Header_rect.getWidth());
		Reporter.log( "Sign_in_Page_Header text is :-"+Sign_in_Page_Header.getText());
		
		ExtentReporter.extentReport.setSystemInfo("Sign_in_Page_Header is Displayed :-"+Sign_in_Page_Header.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo( "Sign_in_Page_Header  Height is :-"+ Sign_in_Page_Header_rect.getHeight(),null);
		ExtentReporter.extentReport.setSystemInfo( "Sign_in_Page_Header  Width is :-"+Sign_in_Page_Header_rect.getWidth(),null);
		ExtentReporter.extentReport.setSystemInfo( "Sign_in_Page_Header text is :-"+Sign_in_Page_Header.getText(),null);
	}
	public void verifyUsernameTab_Menu() throws Throwable
	{
		Helper.highlightElement(driver, UsernameTab);
		Rectangle UsernameTab_rect = UsernameTab.getRect();
		Reporter.log("UsernameTab is Displayed :-"+UsernameTab.isDisplayed());
		Reporter.log("UsernameTab Height is :-"+ UsernameTab_rect.getHeight());
		Reporter.log( "UsernameTab Width is :-"+UsernameTab_rect.getWidth());
		Reporter.log("UsernameTab text is :-"+UsernameTab.getText());
		
		ExtentReporter.extentReport.setSystemInfo("UsernameTab is Displayed :-"+UsernameTab.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo("UsernameTab Height is :-"+ UsernameTab_rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo( "UsernameTab Width is :-"+UsernameTab_rect.getWidth(), null);
		ExtentReporter.extentReport.setSystemInfo("UsernameTab text is :-"+UsernameTab.getText(), null);
	}

	public void verifyBadgeTab_Menu() throws Throwable
	{
		Helper.highlightElement(driver, BadgeTab);
		Rectangle BadgeTab_rect = BadgeTab.getRect();
		Reporter.log( "BadgeTab is Displayed :-"+BadgeTab.isDisplayed());
		Reporter.log( "BadgeTab Height is :-"+ BadgeTab_rect.getHeight());
		Reporter.log( "BadgeTab Width is :-"+BadgeTab_rect.getWidth());
		Reporter.log( "BadgeTab text is :-"+BadgeTab.getText());
		
		
		ExtentReporter.extentReport.setSystemInfo( "BadgeTab is Displayed :-"+BadgeTab.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo( "BadgeTab Height is :-"+ BadgeTab_rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo( "BadgeTab Width is :-"+BadgeTab_rect.getWidth(), null);
		ExtentReporter.extentReport.setSystemInfo( "BadgeTab text is :-"+BadgeTab.getText(), null);
	}

	public void verifyUsername_Text_Field_Area() throws Throwable
	{
		Helper.highlightElement(driver, Username_Text_Field);
		Rectangle Username_Text_Field_rect = Username_Text_Field.getRect();
		Reporter.log( "Username_Text_Field is Displayed :-"+Username_Text_Field.isDisplayed());
		Reporter.log( "Username_Text_Field Height is :-"+ Username_Text_Field_rect.getHeight());
		Reporter.log( "Username_Text_Field Width is :-"+Username_Text_Field_rect.getWidth());
		
		ExtentReporter.extentReport.setSystemInfo( "Username_Text_Field is Displayed :-"+Username_Text_Field.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo( "Username_Text_Field Height is :-"+ Username_Text_Field_rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo( "Username_Text_Field Width is :-"+Username_Text_Field_rect.getWidth(), null);
	}
	public void verifyPassword_Text_Field_Area() throws Throwable
	{
		Helper.highlightElement(driver, Password_Text_Field);
		Rectangle Password_Text_Field_rect = Password_Text_Field.getRect();
		Reporter.log( "Password_Text_Field is Displayed :-"+Password_Text_Field.isDisplayed());
		Reporter.log( "Password_Text_Field  Height is :-"+ Password_Text_Field_rect.getHeight());
		Reporter.log( "Password_Text_Field  Width is :-"+Password_Text_Field_rect.getWidth());
		
		ExtentReporter.extentReport.setSystemInfo( "Password_Text_Field is Displayed :-"+Password_Text_Field.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo( "Password_Text_Field  Height is :-"+ Password_Text_Field_rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo( "Password_Text_Field  Width is :-"+Password_Text_Field_rect.getWidth(), null);
	}
	public void verifyShow_Password_Button_Area() throws Throwable
	{
		Helper.highlightElement(driver, Show_Password_Button);
		Reporter.log( "Show_Password_Button is Displayed :-"+Password_Text_Field.isDisplayed());
		Reporter.log( "Show_Password_Button is Enabled  :-"+Show_Password_Button.isEnabled());
		
		ExtentReporter.extentReport.setSystemInfo( "Show_Password_Button is Displayed :-"+Password_Text_Field.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo( "Show_Password_Button is Enabled  :-"+Show_Password_Button.isEnabled(), null);
	}
	public void verifyTopHat_Logo_Area() throws Throwable
	{
		Helper.highlightElement(driver, TopHat_Logo);
		Rectangle TopHat_Logo_rect = TopHat_Logo.getRect();
		Reporter.log( "Username_Text_Field is Displayed :-"+TopHat_Logo.isDisplayed());
		Reporter.log( "Username_Text_Field Height is :-"+ TopHat_Logo_rect.getHeight());
		Reporter.log( "Username_Text_Field Width is :-"+ TopHat_Logo_rect.getWidth());
		
		ExtentReporter.extentReport.setSystemInfo( "Username_Text_Field is Displayed :-"+TopHat_Logo.isDisplayed(), null);
		ExtentReporter.extentReport.setSystemInfo( "Username_Text_Field Height is :-"+ TopHat_Logo_rect.getHeight(), null);
		ExtentReporter.extentReport.setSystemInfo( "Username_Text_Field Width is :-"+ TopHat_Logo_rect.getWidth(), null);
	}

	//Utilization
	public void Sign_inValidation() throws Throwable
	{
		wait.until(ExpectedConditions.visibilityOf(Username_Text_Field));
		Helper.highlightElement(driver, Username_Text_Field);
		//js.executeScript("arguments[0].value='user1';",Username_Text_Field);
		Username_Text_Field.sendKeys(prop.getProperty("username"));
		MyListeners.extentTest.info("Username entered successfully and verified");

		wait.until(ExpectedConditions.visibilityOf(Password_Text_Field));
		Helper.highlightElement(driver, Password_Text_Field);
		//js.executeScript("arguments[0].value='TestPassword1234!';",Password_Text_Field);
		Password_Text_Field.sendKeys(prop.getProperty("password"));
		MyListeners.extentTest.info("Password entered successfully and verified");
		wait.until(ExpectedConditions.visibilityOf(Show_Password_Button));
		Helper.highlightElement(driver, Show_Password_Button);
		Show_Password_Button.click();
		
		wait.until(ExpectedConditions.visibilityOf(SignInButton));
		Helper.highlightElement(driver, SignInButton);
		js.executeScript("arguments[0].click()",SignInButton);
		MyListeners.extentTest.info("Sign In button clicked successfully");
	}

	public void Bagde_ID_Signin() throws Throwable
	{
		Helper.highlightElement(driver, Badge_ID_TextField);
		Username_Text_Field.sendKeys(prop.getProperty("Bagde_ID_Text"));
	}

	public void Sign_inVerification() throws Throwable
	{
		verifySign_in_Header();
		verifyUsernameTab_Menu();
		verifyBadgeTab_Menu();
		verifyUsername_Text_Field_Area();
		verifyPassword_Text_Field_Area();
		verifyShow_Password_Button_Area();
		verifyTopHat_Logo_Area();
	}
}