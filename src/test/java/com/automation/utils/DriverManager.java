package com.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void setImplicitlyWait(long num){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }

    public static WebDriver getDriver() {
        return driver;
    }

}
