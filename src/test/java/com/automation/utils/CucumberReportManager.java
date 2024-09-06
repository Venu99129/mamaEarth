package com.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class CucumberReportManager {

    static Scenario scenario;

    public static void setScenario(Scenario scenario1){
        scenario = scenario1;
    }

    public static void addaScreenshot(){
        scenario.attach(takeScreenShot(),"image/png","screen snap");
    }

    private static byte[] takeScreenShot(){
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        return ts.getScreenshotAs(OutputType.BYTES);
    }

    public static void addaLog(String message){
        scenario.log(message);
    }
}
