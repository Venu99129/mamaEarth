package com.automation.steps;

import com.automation.pages.andriod.SearchedScreen;
import com.automation.pages.ui.SearchedUi;
import com.automation.pages.web.SearchedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SearchedStep {
    SearchedUi searchedUi;

    public SearchedStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) searchedUi = new SearchedPage();
        else searchedUi = new SearchedScreen();
    }

    @Then("the user should be on the {string} page")
    public void theUserShouldBeOnThePage(String itemName) {
        if(itemName.equals("Face")) itemName = "Skin";
        if(!searchedUi.getSearchedResultText().contains(itemName.trim()))
            System.out.println("false "+searchedUi.getSearchedResultText());
        Assert.assertTrue(searchedUi.getSearchedResultText().contains(itemName));
    }

    @And("the user should verify that all products displayed are under the category")
    public void theUserShouldVerifyThatAllProductsDisplayedAreUnderTheCategory() {
        Assert.assertTrue(searchedUi.verifyAllProductsInUnDerCategory());
    }

    @Then("verify user in searched page {string}")
    public void verifyUserInSearchedPage(String searchedText) {
        Assert.assertEquals(searchedText,searchedUi.verifySearchedUi());
    }

    @Then("verify all products are matches searched {string}")
    public void verifyAllProductsAreMatchesSearched(String productName) {
        Assert.assertTrue(searchedUi.verifyAllProductsMatchesSearchedText(productName));
    }

    @Then("verify sub-product type {string} of products are displayed")
    public void verifySubProductTypeOfProductsAreDisplayed(String category) {
        Assert.assertTrue(searchedUi.verifyAllProductsMatchesSearchedText(category));
    }

    @When("click first product in searched products")
    public void clickFirstProductInSearchedProducts() {
        searchedUi.clickOnFirstProduct();
    }
}
