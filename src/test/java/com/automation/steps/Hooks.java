package com.automation.steps;

import com.automation.utils.DriverManager;
import com.automation.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import com.automation.utils.CucumberReportManager;
import java.io.IOException;


public class Hooks {

    @Before
    public void setUp(Scenario scenario) throws IOException {
        System.out.println("starting scenario "+ scenario.getName());
        CucumberReportManager.setScenario(scenario);
        ConfigReader.initConfig();
        DriverManager.createDriver();
    }

    @After
    public void cleanUp(Scenario scenario) {
        if(scenario.isFailed()){
            CucumberReportManager.addaScreenshot();
        }
        //DriverManager.getDriver().quit();
    }



}