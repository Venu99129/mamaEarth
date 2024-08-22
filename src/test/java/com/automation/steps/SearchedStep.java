package com.automation.steps;

import com.automation.pages.SearchedPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SearchedStep {
    SearchedPage searchedPage = new SearchedPage();

    @Then("the user should be on the {string} page")
    public void theUserShouldBeOnThePage(String itemName) {
        if(itemName.equals("Face")) itemName = "Skin";
        Assert.assertTrue(searchedPage.getSearchedResultText().contains(itemName));
    }

    @And("the user should verify that all products displayed are under the category")
    public void theUserShouldVerifyThatAllProductsDisplayedAreUnderTheCategory() {
        Assert.assertTrue(searchedPage.verifyAllProductsInUnDerCategory());
    }

    @Then("verify user in searched page {string}")
    public void verifyUserInSearchedPage(String searchedText) {
        Assert.assertEquals(searchedText,searchedPage.verifySearchedPage());
    }

    @Then("verify all products are matches searched {string}")
    public void verifyAllProductsAreMatchesSearched(String productName) {
        Assert.assertTrue(searchedPage.verifyAllProductsMatchesSearchedText(productName));
    }

    @Then("verify sub-product type {string} of products are displayed")
    public void verifySubProductTypeOfProductsAreDisplayed(String category) {
        Assert.assertTrue(searchedPage.verifyAllProductsMatchesSearchedText(category));
    }
}
