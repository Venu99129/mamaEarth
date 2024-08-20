package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStep {
    HomePage homePage = new HomePage();

    @Given("user open the mamaEarth website")
    public void i_open_the_mamaEarth_website() {
        homePage.openTheBataWebsite();
    }


    @When("user verify the user is on the home page")
    public void i_verify_the_user_is_on_home_page() {
        Assert.assertTrue(homePage.verifyISOnHomePage());
    }

    @When("user click on the user icon")
    public void i_click_on_the_user_icon() {
        homePage.clickOnUserIcon();
    }

    @Then("user should see the logged out")
    public void iShouldSeeTheLoggedOut() {
        Assert.assertEquals("Login",homePage.verifyLoginWithUserIcon());
    }

    @When("the user clicks on the {string} menu item")
    public void theUserClicksOnTheMenuItem(String item) {
        homePage.clickOnMenuItem(item);
    }
}
