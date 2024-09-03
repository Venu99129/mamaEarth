package com.automation.steps;

import com.automation.Screens.CartScreen;
import com.automation.UI.CartUi;
import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStep {
    CartUi cartUi;
    public CartStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("web")) cartUi = new CartPage();
        else cartUi = new CartScreen();
    }

    @Then("verify user is on cart page")
    public void verifyCartUi() {
        Assert.assertTrue(cartUi.verifyCartUi());
    }

    @When("click on available offer applyBtn")
    public void clickOnAvailableOfferApplyBtn() {
        cartUi.clickOnFirstCouponBtn();
    }

    @Then("verify coupon applied")
    public void verifyCouponApplied() {
        Assert.assertTrue(cartUi.verifyCouponApplied());
    }

    @Then("verify coupon amount applied")
    public void verifyCouponAmountApplied() {
        Assert.assertTrue(cartUi.verifyCartAmountWithCouponAmount());
    }


    @Then("verify same variant of the product is added into the cart")
    public void verifySameVariantOfTheProductIsAddedIntoTheCart() {
        Assert.assertTrue(cartUi.verifySameVariantIsAddedIntoCart());
    }

    @Then("verify product is added into the cart")
    public void verifyProductVisibleInCartUi() {
        Assert.assertEquals(ConfigReader.getConfigValue("product.name"),cartUi.getProductName());
        Assert.assertEquals(ConfigReader.getConfigValue("product.quantity"),cartUi.getProductQuantityInCart());
    }

    @When("user clicks on place order button")
    public void userClicksOnPlaceOrderButton() {
        cartUi.clickOnPlaceOrderBtn();
    }

    @When("user clicks on add address button")
    public void userClicksOnAddAddressButton() {
        cartUi.clickOnAddAddressBtn();
    }

    @And("user enters valid address data")
    public void userEntersValidAddressData() {
        cartUi.fillTheAddressDetails();
    }

    @And("remove product from cart")
    public void removeProductFromCart() {
        cartUi.removeProduct();
    }
}
