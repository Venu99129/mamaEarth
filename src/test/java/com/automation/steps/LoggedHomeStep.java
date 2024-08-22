package com.automation.steps;

import com.automation.pages.LoggedHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoggedHomeStep {

    LoggedHomePage homePage = new LoggedHomePage();

    @When("user mouse over on the user icon")
    public void iMouseOverOnTheUserIcon() {
        homePage.mouseoverOnUserIcon();
    }

    @Then("user should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(ConfigReader.getConfigValue("user.fullName"),homePage.verifyLoginWithUserIcon());
    }

    @When("user select logout")
    public void i_select_logout() {
        homePage.clickOnLogOut();
    }
}
