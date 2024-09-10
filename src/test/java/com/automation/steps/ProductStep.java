package com.automation.steps;

import com.automation.pages.andriod.ProductScreen;
import com.automation.pages.ui.ProductUi;
import com.automation.pages.web.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductStep {

    ProductUi productUi;

    public ProductStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) productUi = new ProductPage();
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

    @And("Back to home page throw product page")
    public void backToHomePageThrowProductPage() {
        productUi.clickOnBackArrowProductPage();
    }

    @When("click on Rate product in product page")
    public void clickOnRateProductInProductPage() {
        productUi.clickOnRateProduct();
    }

    @And("give the review {string}")
    public void giveTheReview(String num) {
        productUi.clickOnGivenStar(num);
    }

    @Then("user fills the name {string} , review {string}")
    public void userFillsTheNameReview(String name, String feedback) {
        productUi.fillNameAndReview(name,feedback);
    }

    @When("user click on submit")
    public void userClickOnSubmit() {
        productUi.clickOnSubmitBtn();
    }

    @Then("verify order review with success toast")
    public void verifyOrderReviewWithSuccessToast() {
        Assert.assertTrue(productUi.verifySuccessToastDisplayed());
    }
}
