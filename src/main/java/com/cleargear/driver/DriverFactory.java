package com.cleargear.driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {
	
	private DriverFactory(){}

	public static WebDriver initDriver(String browser) {
        WebDriver driver;

        try {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    // Add headless if needed: chromeOptions.addArguments("--headless");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    // Firefox maximize via options
                    firefoxOptions.addArguments("--width=1920", "--height=1080");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--start-maximized");
                    driver = new EdgeDriver(edgeOptions);
                    break;

                default:
                    throw new RuntimeException("Invalid browser name: " + browser);
            }

            // Set timeouts
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

            // Set in ThreadLocal driver manager
            DriverManagerNew.setDriver(driver);

        } catch (Exception e) {
            throw new RuntimeException("❌ WebDriver initialization failed for browser: " + browser, e);
        }

        return driver;
        
    }

    public static void quitDriver() {

        if(DriverManagerNew.getDriver()!=null) {
            DriverManagerNew.getDriver().quit();

            DriverManagerNew.unload();
        }
    }
	

}
