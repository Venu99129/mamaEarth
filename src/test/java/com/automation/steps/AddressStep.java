package com.automation.steps;

import com.automation.pages.andriod.AddressScreen;
import com.automation.pages.ui.AddressUi;
import com.automation.pages.web.AddressPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressStep {
    AddressUi addressUi;
    public AddressStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) addressUi = new AddressPage();
        else addressUi = new AddressScreen();
    }

    @Then("verify user is on address page")
    public void verifyUserIsOnAddressPage() {
        Assert.assertTrue(addressUi.verifyAddressPage());
        addressUi.verifyAddressDetails();
    }

    @When("user clicks on proceed to pay button in address page")
    public void userClicksOnProceedToPayButton() {
        addressUi.clickOnProceedToPayBtn();
    }

    @And("user enter valid address in address page")
    public void userEnterValidAddressInAddressPage() {
        addressUi.fillAddressDetails();
    }

    @Then("user enter valid address in address page with login")
    public void userEnterValidAddressInAddressPageWithLogin() {
        addressUi.fillAddressDetailsWithLogin();
    }
}
