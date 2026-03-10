package com.cleargear.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.cleargear.base.Base;
import com.cleargear.driver.DriverManager;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

	public class POM_CreateNew_User_Page extends Base
	{
	    public JavascriptExecutor js;
	    public WebDriverWait wait;
	    public SoftAssert softAssert;

	    public POM_CreateNew_User_Page()
	    {
	        driver = DriverManager.getDriver();
	        this.js = (JavascriptExecutor) driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        this.softAssert = new SoftAssert();
	        PageFactory.initElements(driver, this);
	    }

	    // ================== WebElements ==================

	    @FindBy(xpath = "//h2[normalize-space()='CREATE NEW USER']")
	    private WebElement Create_New_User_Label;

	    @FindBy(xpath = "//div[contains(@class,'self-stretch')]//label[contains(.,'Employee ID')]")
	    private WebElement Employee_ID_Label;

	    @FindBy(xpath = "//input[@placeholder='Enter Employee ID']")
	    private WebElement Employee_ID_Textbox;

	    @FindBy(xpath = "//div[contains(@class,'self-stretch')]//label[contains(.,'First Name')]")
	    private WebElement First_Name_Label;

	    @FindBy(xpath = "//input[@placeholder='First Name']")
	    private WebElement First_Name_Textbox;

	    @FindBy(xpath = "//div[contains(@class,'self-stretch')]//label[contains(.,'Last Name')]")
	    private WebElement Last_Name_Label;

	    @FindBy(xpath = "//input[@placeholder='Last Name']")
	    private WebElement Last_Name_Textbox;

	    @FindBy(xpath = "//div[contains(@class,'self-stretch')]//label[contains(.,'Email')]")
	    private WebElement Email_Label;

	    @FindBy(xpath = "//input[@placeholder='Email']")
	    private WebElement Email_Textbox;

	    @FindBy(xpath = "//div[contains(@class,'items-start')]//label[contains(.,'Language')]")
	    private WebElement Language_Label;

	    @FindBy(xpath = "//select[@id='«r29»']")
	    private WebElement Language_Dropdown;

	    @FindBy(xpath = "//div[contains(@class,'items-start')]//label[contains(.,'Role')]")
	    private WebElement Role_Label;

	    @FindBy(xpath = "//select[@id='«r2a»']")
	    private WebElement Role_Dropdown;

	    @FindBy(xpath = "//button[@type='submit' and normalize-space()='Create New User']")
	    private WebElement Create_New_User_Button;

	    // ================== Common Verification ==================

	    public void verifyElement(WebElement element, String elementName) throws Throwable
	    {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        Helper.highlightElement(driver, element);

	        Rectangle rect = element.getRect();

	        Reporter.log(elementName + " Displayed :- " + element.isDisplayed());
	        Reporter.log(elementName + " Height :- " + rect.getHeight());
	        Reporter.log(elementName + " Width :- " + rect.getWidth());

	        ExtentReporter.extentReport.setSystemInfo(elementName + " Displayed :- " + element.isDisplayed(), null);

	        softAssert.assertTrue(element.isDisplayed(), elementName + " is not displayed");
	    }

	    // ================== Page Verification ==================

	    public void verifyCreateNewUserPopup() throws Throwable
	    {
	        verifyElement(Create_New_User_Label, "Create New User Header");
	        verifyElement(Employee_ID_Label, "Employee ID Label");
	        verifyElement(Employee_ID_Textbox, "Employee ID Textbox");
	        verifyElement(First_Name_Label, "First Name Label");
	        verifyElement(First_Name_Textbox, "First Name Textbox");
	        verifyElement(Last_Name_Label, "Last Name Label");
	        verifyElement(Last_Name_Textbox, "Last Name Textbox");
	        verifyElement(Email_Label, "Email Label");
	        verifyElement(Email_Textbox, "Email Textbox");
	        softAssert.assertAll();
	    }
	    

	    // ================== Utilization ==================

	    public void enterEmployeeID(String empId)
	    {
	        wait.until(ExpectedConditions.visibilityOf(Employee_ID_Textbox));
	        Employee_ID_Textbox.clear();
	        Employee_ID_Textbox.sendKeys(empId);
	        ExtentReporter.extentReport.setSystemInfo("Entered Employee ID : " + empId, empId);
	    }

	    public void enterFirstName(String firstName)
	    {
	        First_Name_Textbox.clear();
	        First_Name_Textbox.sendKeys(firstName);
	        ExtentReporter.extentReport.setSystemInfo("Entered First Name : " + firstName, firstName);
	    }

	    public void enterLastName(String lastName)
	    {
	        Last_Name_Textbox.clear();
	        Last_Name_Textbox.sendKeys(lastName);
	        ExtentReporter.extentReport.setSystemInfo("Entered Last Name : " + lastName, lastName);
	    }

	    public void enterEmail(String email)
	    {
	        Email_Textbox.clear();
	        Email_Textbox.sendKeys(email);
	        ExtentReporter.extentReport.setSystemInfo("Entered Email : " + email, email);
	    }

	    public void clickCreateNewUserButton() throws Throwable
	    {
	        wait.until(ExpectedConditions.elementToBeClickable(Create_New_User_Button));
	        Helper.highlightElement(driver, Create_New_User_Button);
	        Create_New_User_Button.click();
	        ExtentReporter.extentReport.setSystemInfo("Clicked on Create New User button", null);
	    }
	    public void selectLanguageFromDropdown(String language) throws Throwable
	    {
	    	Thread.sleep(2000);
	    	Helper.highlightElement(driver, Language_Dropdown);
	    	Language_Dropdown.click();
	    	Thread.sleep(2000);
	    	Select sel = new Select(Language_Dropdown);
	    	sel.selectByVisibleText(language);

	    	Reporter.log("Selected Language from dropdown :- " + language);
	    	ExtentReporter.extentReport.setSystemInfo(
	    			"Selected Language from dropdown :- " + language, language);
	    }
	    
	    public void selectRoleFromDropdown(String Role) throws Throwable
	    {
	    	Thread.sleep(2000);
	    	Helper.highlightElement(driver, Role_Dropdown);
	    	Role_Dropdown.click();
	    	Select sel = new Select(Role_Dropdown);
	    	List<WebElement> options = sel.getOptions();
	    	for (WebElement newoption:options)
	    	{
	    		Reporter.log("Role options in  dropdown are :- " + newoption);
	    	}
	    	
	    	sel.selectByVisibleText("Role");

	    	ExtentReporter.extentReport.setSystemInfo(
	    			"Selected Language from dropdown :- " + Role,Role);
	    }
	    
	    
	    
	}



