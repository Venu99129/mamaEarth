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
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) homeUi = new LoggedHomePage();
        else homeUi = new LoggedHomeScreen();
    }

    @When("user mouse over on the user icon")
    public void mouseOverOnTheUserIcon() {
        homeUi.mouseoverOnUserIcon();
    }

    @When("user click on the burger menu")
    public void mouseOverOnBurgerMenu(){
        homeUi.mouseoverOnBurgerMenu();
    }

    @Then("user should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String expectedName = (System.getProperty("env").equals("mobile") ?
                ConfigReader.getConfigValue("user.name.mobile") : ConfigReader.getConfigValue("user.fullName") );

        String actualName = (System.getProperty("env").equals("mobile") ? homeUi.verifyLoginWithBergerMenu() : homeUi.verifyLoginWithUserIcon());

        Assert.assertEquals(expectedName,actualName);
    }

    @When("user select logout")
    public void i_select_logout() {
        homeUi.clickOnLogOut();
    }

    @When("user clicks on a cart Icon through logged home page")
    public void userClicksOnAProductInTheLoginHomePage() {
        homeUi.clickOnCartIcon();
    }

    @Then("click on Manage Address")
    public void clickOnManageAddress() {
        homeUi.clickOnManageAddress();
    }
}
