package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStep {

    ProductPage productPage = new ProductPage();


    @Then("verify user is on product page")
    public void verifyUserIsOnProductDescriptionPage() {
        Assert.assertTrue(productPage.verifyUserIsOnProductDescriptionPage());
    }

    @When("user selects the other variant")
    public void userSelectsTheVariant() {
        productPage.userSelectsTheVariant();
    }

    @And("clicks on add to cart button in product page")
    public void clicksOnAddToCartButton() throws InterruptedException {
        Assert.assertTrue(productPage.userClicksAddToCart());
    }

    @And("user click on cart icon in product page")
    public void clicksOnAddToCartButtonProductPage() {
        productPage.clickOnCartIcon();
    }

    @Then("user enter specific quantity {string}")
    public void userEnterSpecificQuantity(String qty) {
        productPage.selectGivenQuantity(qty);
    }

    @When("user logout throw product page")
    public void userLogoutThrowProductPage() {
        productPage.mouseOverOnUserIcon();
        productPage.clickOnLogOut();
    }
}
