package com.automation.steps;

import com.automation.pages.AddressPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddressStep {
    AddressPage addressPage = new AddressPage();

    @Then("verify user is on address page")
    public void verifyUserIsOnAddressPage() {
        Assert.assertTrue(addressPage.verifyAddressPage());
        addressPage.verifyAddressDetails();
    }

    @When("user clicks on proceed to pay button")
    public void userClicksOnProceedToPayButton() {
        addressPage.clickOnProceedToPayBtn();
    }

}
