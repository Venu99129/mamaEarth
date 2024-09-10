package com.automation.steps;

import com.automation.pages.andriod.OrderConfirmedScreen;
import com.automation.pages.ui.OrderConfirmedUi;
import com.automation.pages.web.OrderConfirmPage;
import com.automation.utils.CucumberReportManager;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class OrderConfirmStep {
    OrderConfirmedUi orderConfirmedUi;

    public OrderConfirmStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) orderConfirmedUi = new OrderConfirmPage();
        else orderConfirmedUi = new OrderConfirmedScreen();
    }

    @Then("verify the order confirmation")
    public void verifyTheOrderConfirmation() {
        Assert.assertTrue(orderConfirmedUi.verifyOrderConfirmation());
        CucumberReportManager.addaScreenshot();
    }


}
