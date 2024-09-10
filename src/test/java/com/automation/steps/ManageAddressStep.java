package com.automation.steps;

import com.automation.pages.andriod.ManageAddressScreen;
import com.automation.pages.ui.ManageAddressUi;
import com.automation.pages.web.ManageAddressPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageAddressStep {
    ManageAddressUi manageAddressUi;

    public ManageAddressStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) manageAddressUi = new ManageAddressPage();
        else manageAddressUi = new ManageAddressScreen();
    }

    @When("click on address section")
    public void clickOnAddressSection() {
        manageAddressUi.clickAddressSection();
    }

    @Then("remove the Address")
    public void removeTheAddress() {
        manageAddressUi.deleteAddress();
    }
}
