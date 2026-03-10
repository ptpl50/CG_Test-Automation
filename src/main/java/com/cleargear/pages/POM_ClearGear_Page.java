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

	public class POM_ClearGear_Page extends Base
	{
		public JavascriptExecutor js;
		public WebDriverWait wait;

		public POM_ClearGear_Page()
		{
			driver = DriverManager.getDriver();
			this.js = (JavascriptExecutor) driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			PageFactory.initElements(driver, this);
		}

		// ================== WebElements ==================

		@FindBy(xpath = "//div[@aria-label='Navigate to Alerts'] | //span[.='Alerts']/..")
		private WebElement Alerts_Menu;

		@FindBy(xpath = "//span[normalize-space()='Manager']/..")
		private WebElement Manager_Menu;

		@FindBy(xpath = "//span[normalize-space()='History']/..")
		private WebElement History_Menu;
		
		@FindBy(xpath = "//div[text()='Back to the menu']")
		private WebElement History_back;

		//@FindBy(xpath = "//span[normalize-space()='Maintenance']/..")
		@FindBy(xpath = "//div[contains(@class,'w-fit grid gap-x-12 gap-y-8 place-items-center')]/div[contains(@class,'w-fit md:w-[192px] sm:bg-white flex flex-col items-center justify-center space-y-4 rounded-xl')][4]")
		private WebElement Maintenance_Menu;

		@FindBy(xpath = "//span[normalize-space()='Search']/..")
		private WebElement Search_Menu;

		// ================== Verification Methods ==================

		public void verifyMenu(WebElement element, String menuName) throws Throwable
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

		public void verifyClearGearMenu() throws Throwable
		{
			verifyMenu(Alerts_Menu, "Alerts Menu");
			verifyMenu(Manager_Menu, "Manager Menu");
			verifyMenu(History_Menu, "History Menu");
			verifyMenu(Maintenance_Menu, "Maintenance Menu");
			verifyMenu(Search_Menu, "Search Menu");
		}

		public void clickAlerts() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(Alerts_Menu));
			Helper.highlightElement(driver, Alerts_Menu);
			js.executeScript("arguments[0].click();", Alerts_Menu);
		}

		public void clickManager() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(Manager_Menu));
			Helper.highlightElement(driver, Manager_Menu);
			Manager_Menu.click();
		}

		public void clickHistory() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(History_Menu));
			Helper.highlightElement(driver, History_Menu);
			History_Menu.click();
		}
		
		public void backhistory() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(History_back));
			Helper.highlightElement(driver, History_back);
			History_back.click();
		}

		public void clickMaintenance() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(Maintenance_Menu));
			Helper.highlightElement(driver, Maintenance_Menu);
			Maintenance_Menu.click();
		}

		public void clickSearch() throws Throwable
		{
			wait.until(ExpectedConditions.elementToBeClickable(Search_Menu));
			Helper.highlightElement(driver, Search_Menu);
			Search_Menu.click();
		}
	}



