package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;

    public static void createDriver() {
        if (ConfigReader.getConfigValue("running.platform").equals("mobile")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            caps.setCapability("appium:app", ConfigReader.getConfigValue("app.path"));
            caps.setCapability("deviceName", ConfigReader.getConfigValue("running.in").equals("my phone")? ConfigReader.getConfigValue("device.name.mobile") : ConfigReader.getConfigValue("device.name"));
            caps.setCapability("appium:automationName", ConfigReader.getConfigValue("automation.name"));
            caps.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
            caps.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
            driver = new AppiumDriver(caps);
        } else {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setImplicitlyWait(int sec) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
    }
}
