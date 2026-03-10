package com.cleargear.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter 
{
	public static ExtentReports extentReport= new ExtentReports();
	public static Object extentTest;
	
public static ExtentReports generateExtentReport()
{
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
//		String logoPath = "file:///" +
//		        System.getProperty("user.dir")
//		                .replace("\\", "/") +
//		        "/src/test/resources/Prath_Tech.png";
//
//		sparkReporter.config().setJs(
//		        "document.addEventListener('DOMContentLoaded', function() {" +
//		        "var brand = document.querySelector('.navbar-brand');" +
//		        "if (brand) {" +
//		        "brand.innerHTML = '<img src=\"" + logoPath + "\" style=\"height:50px; vertical-align:middle;\" /> " +
//		        "<span style=\"margin-left:10px; font-size:20px;\">ClearGear Report</span>';" +
//		        "}" +
//		        "});"
//		);
		
		//String logoPath = "D:/Automation Project/ClearGear_Automation_V4/test-output/ExtentReports/Prath_Tech.png";

		//sparkReporter.config().setReportName(
		  //  "<img src='file:///" + logoPath + "' height='50'/>"
		//);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("ClearGear Test Automation Report");
		sparkReporter.config().setDocumentTitle("CG Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cleargear\\config\\config.properties");
		
		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
		extentReport.setSystemInfo("User name",configProp.getProperty("username"));
		extentReport.setSystemInfo("Password",configProp.getProperty("password"));
		extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
		extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
		return extentReport;
	}
}
