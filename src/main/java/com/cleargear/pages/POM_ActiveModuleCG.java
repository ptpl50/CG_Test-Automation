	package com.cleargear.pages;

	import java.time.Duration;

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

	public class POM_ActiveModuleCG extends Base
	{
		public WebDriverWait wait;

		public POM_ActiveModuleCG()
		{
			driver = DriverManager.getDriver();
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			PageFactory.initElements(driver, this);
		}

		// ================== WebElements ==================

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

		@FindBy(xpath = "(//div[@aria-label='Sort by Ack Timestamp'])[1]")
		private WebElement Ack_Timestamp_Column;

		@FindBy(xpath = "(//span[.='Actions'])[1]")
		private WebElement Actions_Column;

		// ================== Common Verification ==================

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

		// ================== UTILIZATION (Verification Only) ==================

		public void verifyActiveAlertsModule() throws Throwable
		{
			verifyElement(ACTIVE_ALERTS_Label, "ACTIVE ALERTS Label");
			verifyElement(Live_Label, "Live Label");
			verifyElement(Priority_Column, "Priority Column");
			verifyElement(Start_Date_Column, "Start Date Column");
			verifyElement(Start_Time_Column, "Start Time Column");
			verifyElement(Alert_Column, "Alert Column");
			verifyElement(Description_Column, "Description Column");
			verifyElement(Ack_Timestamp_Column, "Ack Timestamp Column");
			verifyElement(Actions_Column, "Actions Column");
		}
	}