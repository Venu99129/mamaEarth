package com.automation.steps;

import com.automation.Screens.SearchedScreen;
import com.automation.UI.SearchedUi;
import com.automation.pages.SearchedPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SearchedStep {
    SearchedUi searchedUi;

    public SearchedStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("web")) searchedUi = new SearchedPage();
        else searchedUi = new SearchedScreen();
    }

    @Then("the user should be on the {string} page")
    public void theUserShouldBeOnThePage(String itemName) {
        if(itemName.equals("Face")) itemName = "Skin";
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
}
