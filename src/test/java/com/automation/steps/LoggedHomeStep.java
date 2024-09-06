package com.automation.steps;

import com.automation.pages.andriod.LoggedHomeScreen;
import com.automation.pages.ui.LoggedHomeUi;
import com.automation.pages.web.LoggedHomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoggedHomeStep {

    LoggedHomeUi homeUi ;

    public LoggedHomeStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("mobile") ) homeUi = new LoggedHomeScreen();
        else homeUi = new LoggedHomePage();
    }

    @When("user mouse over on the user icon or burger menu")
    public void iMouseOverOnTheUserIcon() {
        homeUi.mouseoverOnUserIconOrBurgerMenu();
    }

    @Then("user should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertEquals(
                (ConfigReader.getConfigValue("running.platform").equals("mobile") ?
                ConfigReader.getConfigValue("user.name.mobile") : ConfigReader.getConfigValue("user.fullName") )
                ,homeUi.verifyLoginWithUserIcon());
    }

    @When("user select logout")
    public void i_select_logout() {
        homeUi.clickOnLogOut();
    }

    @When("user clicks on a product in the Login home page")
    public void userClicksOnAProductInTheLoginHomePage() {
        homeUi.clickOnCartIcon();
    }

}
