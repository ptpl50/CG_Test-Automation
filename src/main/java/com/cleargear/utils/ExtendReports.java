package com.cleargear.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.cleargear.driver.DriverManagerNew;

public class ExtendReports {
	private static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static Date startTime;
    private static Date endTime;

    private ExtendReports() {}
    public static void setDynamicSystemInfo() {

        try {

            Capabilities cap = ((RemoteWebDriver) DriverManagerNew.getDriver()).getCapabilities();
            extent.setSystemInfo("Application", "Clear Gear Web Application");
            extent.setSystemInfo("Environment",
                    System.getProperty("env", "Staging"));
            extent.setSystemInfo("Tester",
                    System.getProperty("user.name"));
            extent.setSystemInfo("Machine",
                    InetAddress.getLocalHost().getHostName());
            extent.setSystemInfo("OS",
                    System.getProperty("os.name"));
            extent.setSystemInfo("OS Version",
                    System.getProperty("os.version"));
            extent.setSystemInfo("Java Version",
                    System.getProperty("java.version"));
            extent.setSystemInfo("Browser",
                    cap.getBrowserName());
            extent.setSystemInfo("Browser Version",
                    cap.getBrowserVersion());
            extent.setSystemInfo("Execution Mode",
                    System.getProperty("execution", "Local"));
            extent.setSystemInfo("Thread Count",
                    String.valueOf(Thread.activeCount()));
            extent.setSystemInfo("Framework",
                    "Selenium + TestNG + POM");
            extent.setSystemInfo("Execution Time",
                    java.time.LocalDateTime.now().toString());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public static void initReports(String testClassName, String suiteName) throws IOException {

        try {

            String fileName = (suiteName == null || suiteName.isEmpty()
                    || suiteName.equalsIgnoreCase("Default suite"))
                    ? testClassName
                    : suiteName;

            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            String formattedDateTime = currentDateTime.format(formatter);

            if (Objects.isNull(extent)) {
                extent = new ExtentReports();
                String reportPath = "/Users/anilmajhimackbook/Desktop/Anil_Automation/CG_Test-Automation/AutomationReports/"
                        + fileName + " " + formattedDateTime + ".html";
                ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
                spark.config().setTheme(Theme.DARK);
                spark.config().setReportName(fileName + " Automation Report");
                spark.config().setDocumentTitle("Clear Gear Automation Report");
                extent.attachReporter(spark);
                setDynamicSystemInfo();
                startTime = new Date();
                System.out.println("✅ ExtentReport initialized successfully at: " + reportPath);
            }

        } catch (Exception e) {

            System.err.println("❌ Unexpected error while initializing ExtentReport: " + e.getMessage());
            e.printStackTrace();

        }
    }

    public static ExtentTest createTestForMethod(String className, String methodName, String description) {

        String testName = className + " - " + methodName;
        ExtentTest extentTest = extent
                .createTest(testName, description)
                .assignAuthor("Anil")
                .assignDevice("Mac");
        test.set(extentTest);
        return extentTest;
    }

    public static void logTestResult(Status status, String details) {

        ExtentTest currentTest = test.get();

        if (currentTest != null) {
            currentTest.log(status, details);
        }
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void teardownReports() {

        if (Objects.nonNull(extent)) {
            List<Test> allTests = extent.getReport().getTestList();
            int totalTests = allTests.size();
            int passedTests = (int) allTests.stream()
                    .filter(t -> t.getStatus() == Status.PASS)
                    .count();
            int failedTests = (int) allTests.stream()
                    .filter(t -> t.getStatus() == Status.FAIL)
                    .count();
            int skippedTests = (int) allTests.stream()
                    .filter(t -> t.getStatus() == Status.SKIP)
                    .count();
            endTime = new Date();
            long duration = endTime.getTime() - startTime.getTime();
            extent.setSystemInfo("Total Tests", String.valueOf(totalTests));
            extent.setSystemInfo("Passed Tests", String.valueOf(passedTests));
            extent.setSystemInfo("Failed Tests", String.valueOf(failedTests));
            extent.setSystemInfo("Skipped Tests", String.valueOf(skippedTests));
            extent.setSystemInfo("Total Execution Time (ms)", String.valueOf(duration));
            extent.flush();
            test.remove();
            ExtentreportTestManager.unload();
        }
    }

}
