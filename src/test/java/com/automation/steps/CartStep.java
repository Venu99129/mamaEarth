package com.automation.steps;

import com.automation.pages.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStep {
    CartPage cartPage = new CartPage();

    @Then("verify user is on cart page")
    public void verifyCartPage() {
        Assert.assertTrue(cartPage.verifyCartPage());
    }

    @When("click on available offer applyBtn")
    public void clickOnAvailableOfferApplyBtn() {
        cartPage.clickOnFirstCouponBtn();
    }

    @Then("verify coupon applied")
    public void verifyCouponApplied() {
        Assert.assertTrue(cartPage.verifyCouponApplied());
    }

    @Then("verify coupon amount applied")
    public void verifyCouponAmountApplied() {
        Assert.assertTrue(cartPage.verifyCartAmountWithCouponAmount());
    }


    @Then("verify same variant of the product is added into the cart")
    public void verifySameVariantOfTheProductIsAddedIntoTheCart() {
        Assert.assertTrue(cartPage.verifySameVariantIsAddedIntoCart());
    }

    @Then("verify product is added into the cart")
    public void verifyProductVisibleInCartPage() {
        Assert.assertEquals(ConfigReader.getConfigValue("product.name"),cartPage.getProductName());
        Assert.assertEquals(ConfigReader.getConfigValue("product.quantity"),cartPage.getProductQuantityInCart());
    }

    @When("user clicks on place order button")
    public void userClicksOnPlaceOrderButton() {
        cartPage.clickOnPlaceOrderBtn();
    }

    @When("user clicks on add address button")
    public void userClicksOnAddAddressButton() {
        cartPage.clickOnAddAddressBtn();
    }

    @And("user enters valid address data")
    public void userEntersValidAddressData() {
        cartPage.fillTheAddressDetails();
    }

    @And("remove product from cart")
    public void removeProductFromCart() {
        cartPage.removeProduct();
    }
}
