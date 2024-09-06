package com.automation.steps;

import com.automation.pages.andriod.HomeScreen;
import com.automation.pages.andriod.SearchedScreen;
import com.automation.pages.ui.HomeUi;
import com.automation.pages.web.HomePage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeStep {
    HomeUi homeui;

    public HomeStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("web")) homeui = new HomePage();
        else homeui = new HomeScreen(); 
    }

    @Given("user open the mamaEarth application")
    public void i_open_the_mamaEarth_website() {
        homeui.openTheMamaEarthWebsite();
    }


    @When("user verify the user is on the home page")
    public void i_verify_the_user_is_on_home_page() {
        Assert.assertTrue(homeui.verifyISOnHomeUi());
    }

    @When("user click on the user icon")
    public void i_click_on_the_user_icon() {
        homeui.clickOnUserIcon();
    }

    @Then("user should see the logged out")
    public void iShouldSeeTheLoggedOut() {
        Assert.assertEquals("Login",homeui.verifyLoginWithUserIcon());
    }

    @When("the user clicks on the {string} menu item")
    public void theUserClicksOnTheMenuItem(String item) {
        homeui.clickOnMenuItem(item);
    }

    @When("user search in search bar {string}")
    public void userSearchInSearchBar(String productName) {
        homeui.searchSearchBar(productName);
    }

    @When("user click first product in bestsellers cart button")
    public void userSelectsFirstProductInBestsellers() {
        homeui.clickOnBestSellersFirstProduct();
    }

    @Then("verify with Success popUp")
    public void verifyWithSuccessPopUp() {
        Assert.assertTrue(homeui.verifyCartPop());
    }

    @When("user go to cart page")
    public void userGoToCartPage() {
        homeui.clickOnCartIcon();
    }


    @When("user selects category type {string} and sub-category type {string}")
    public void userSelectsCategoryTypeAndSubCategoryType(String category, String subCategory) {

        if(ConfigReader.getConfigValue("running.platform").contains("web")) {
            homeui.mouseOverOnMenuItem(category);
            homeui.clickOnSubMenuItem(subCategory);
        }
        else {
            homeui.clickOnMenuItem(category);
            new SearchedScreen().clickOnSubMenu(subCategory);
        }
    }

    @When("user clicks on a first product in the home page")
    public void userClicksOnAProductInTheHomeUi() {
        homeui.userClicksOnAProduct();
    }

}
