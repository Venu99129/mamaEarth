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

    @When("user search in search bar {string}")
    public void userSearchInSearchBar(String productName) {
        homePage.searchSearchBar(productName);
    }

    @When("user click first product in bestsellers cart button")
    public void userSelectsFirstProductInBestsellers() {
        homePage.clickOnBestSellersFirstProduct();
    }

    @Then("verify with Success popUp")
    public void verifyWithSuccessPopUp() {
        Assert.assertTrue(homePage.verifyCartPop());
    }

    @When("user go to cart page")
    public void userGoToCartPage() {
        homePage.clickOnCartIcon();
    }


    @When("user selects category type {string} and sub-category type {string}")
    public void userSelectsCategoryTypeAndSubCategoryType(String category, String subCategory) {
        homePage.mouseOverOnMenuItem(category);
        homePage.clickOnSubMenuItem(subCategory);
    }

    @When("user clicks on a product in the home page")
    public void userClicksOnAProductInTheHomePage() {
        homePage.userClicksOnAProduct();
    }
}
