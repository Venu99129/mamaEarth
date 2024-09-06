package com.automation.steps;

import com.automation.pages.andriod.ProductScreen;
import com.automation.pages.ui.ProductUi;
import com.automation.pages.web.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStep {

    ProductUi productUi;

    public ProductStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("web")) productUi = new ProductPage();
        else productUi = new ProductScreen();
    }


    @Then("verify user is on product page")
    public void verifyUserIsOnProductDescriptionPage() {
        Assert.assertTrue(productUi.verifyUserIsOnProductDescriptionUi());
    }

    @When("user selects the other variant")
    public void userSelectsTheVariant() {
        productUi.userSelectsTheVariant();
    }

    @And("clicks on add to cart button in product page")
    public void clicksOnAddToCartButton() throws InterruptedException {
        Assert.assertTrue(productUi.userClicksAddToCart());
    }

    @And("user click on cart icon in product page")
    public void clicksOnAddToCartButtonProductPage() {
        productUi.clickOnCartIcon();
    }

    @Then("user select specific quantity {string}")
    public void userEnterSpecificQuantity(String qty) {
        productUi.selectGivenQuantity(qty);
    }

    @When("user logout throw product page")
    public void userLogoutThrowProductPage() {
        productUi.mouseOverOnUserIcon();
        productUi.clickOnLogOut();
    }
}
