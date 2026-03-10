package com.cleargear.pages;
	import java.time.Duration;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Rectangle;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Reporter;
	import com.cleargear.base.Base;
	import com.cleargear.driver.DriverManager;
	import com.cleargear.utils.ExtentReporter;
	import com.cleargear.utils.Helper;

	public class POM_AlertsMenuPage extends Base
	{
	    public JavascriptExecutor js;
	    public WebDriverWait wait;

	    public POM_AlertsMenuPage()
	    {
	        driver = DriverManager.getDriver();
	        this.js = (JavascriptExecutor) driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        PageFactory.initElements(driver, this);
	    }

	    // ================== WebElements ==================

	    @FindBy(xpath = "//span[normalize-space()='Alerts']")
	    private WebElement Alerts_Tab;

	    @FindBy(xpath = "//span[normalize-space()='Manager']")
	    private WebElement Manager_Tab;

	    @FindBy(xpath = "//span[normalize-space()='History']")
	    private WebElement History_Tab;

	    @FindBy(xpath = "//span[normalize-space()='Maintenance']")
	    private WebElement Maintenance_Tab;

	    @FindBy(xpath = "//span[normalize-space()='Search']")
	    private WebElement Search_Tab;

	    // ================== Common Verification ==================

	    private void verifyTab(WebElement element, String tabName) throws Throwable
	    {
	        Helper.highlightElement(driver, element);
	        Rectangle rect = element.getRect();

	        Reporter.log(tabName + " Displayed :- " + element.isDisplayed());
	        Reporter.log(tabName + " Height :- " + rect.getHeight());
	        Reporter.log(tabName + " Width :- " + rect.getWidth());
	        Reporter.log(tabName + " Text :- " + element.getText());

	        ExtentReporter.extentReport.setSystemInfo(
	                tabName + " Displayed :- " + element.isDisplayed(), null);
	        ExtentReporter.extentReport.setSystemInfo(
	                tabName + " Height :- " + rect.getHeight(), null);
	        ExtentReporter.extentReport.setSystemInfo(
	                tabName + " Width :- " + rect.getWidth(), null);
	        ExtentReporter.extentReport.setSystemInfo(
	                tabName + " Text :- " + element.getText(), null);
	    }

	    // ================== Verification Methods ==================

	    public void verifyAlertsTab() throws Throwable
	    {
	        verifyTab(Alerts_Tab, "Alerts Tab");
	    }

	    public void verifyManagerTab() throws Throwable
	    {
	        verifyTab(Manager_Tab, "Manager Tab");
	    }

	    public void verifyHistoryTab() throws Throwable
	    {
	        verifyTab(History_Tab, "History Tab");
	    }

	    public void verifyMaintenanceTab() throws Throwable
	    {
	        verifyTab(Maintenance_Tab, "Maintenance Tab");
	    }

	    public void verifySearchTab() throws Throwable
	    {
	        verifyTab(Search_Tab, "Search Tab");
	    }

	    // ================== Utilization ==================

	    public void verifyAlertsMenu() throws Throwable
	    {
	        verifyAlertsTab();
	        verifyManagerTab();
	        verifyHistoryTab();
	        verifyMaintenanceTab();
	        verifySearchTab();
	    }

	    // ================== Click Actions ==================

	    public void clickAlertsTab() throws Throwable
	    {
	        Helper.highlightElement(driver, Alerts_Tab);
	        Alerts_Tab.click();
	    }

	    public void clickManagerTab() throws Throwable
	    {
	        Helper.highlightElement(driver, Manager_Tab);
	        Manager_Tab.click();
	    }

	    public void clickHistoryTab() throws Throwable
	    {
	        Helper.highlightElement(driver, History_Tab);
	        History_Tab.click();
	    }

	    public void clickMaintenanceTab() throws Throwable
	    {
	        Helper.highlightElement(driver, Maintenance_Tab);
	        Maintenance_Tab.click();
	    }

	    public void clickSearchTab() throws Throwable
	    {
	        Helper.highlightElement(driver, Search_Tab);
	        Search_Tab.click();
	    }
	}

