package com.automation.steps;

import com.automation.pages.andriod.CartScreen;
import com.automation.pages.ui.CartUi;
import com.automation.pages.web.CartPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartStep {
    CartUi cartUi;
    public CartStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) cartUi = new CartPage();
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
        System.out.println(ConfigReader.getConfigValue("product.name")+"  "+cartUi.getProductName());
        Assert.assertEquals(ConfigReader.getConfigValue("product.name"),cartUi.getProductName());
        if(System.getProperty("env").equals("web")) Assert.assertEquals(ConfigReader.getConfigValue("product.quantity"),cartUi.getProductQuantityInCart());
    }

    @When("user clicks on place order button")
    public void userClicksOnPlaceOrderButton() {
        cartUi.clickOnPlaceOrderBtn();
    }

    @When("user clicks on add address button")
    public void userClicksOnAddAddressButton() {
        cartUi.clickOnAddAddressBtn();
    }

    @And("user enter valid address data in cart Page")
    public void userEntersValidAddressData() {
        cartUi.fillTheAddressDetails();
    }

    @And("remove product from cart")
    public void removeProductFromCart() {
        cartUi.removeProduct();
    }

    @When("user select specific quantity {string} in cart Page")
    public void userSelectSpecificQuantityInCartPage(String qty) throws InterruptedException {
        cartUi.selectQuantityByGivenQuantity(qty);
    }

    @Then("comparing prices of increasing quantity")
    public void comparingPricesOfIncreasingQuantity() {
        Assert.assertTrue(cartUi.comparePriceByQuantity());
    }

    @When("user clicks on proceed to pay button through cart page")
    public void userClicksOnProceedToPayButtonThroughCartPage() {
        cartUi.clickOnProceedToPayBtn();
    }

    @When("click on select address")
    public void clickOnSelectAddress() {
        cartUi.clickOnSelectAddressBtn();
    }

    @Then("remove the cart product")
    public void removeTheCartProduct() {
        cartUi.removeProduct();
    }

    @When("back to home page through cart page")
    public void backToHomePageThroughCartPage() {
        cartUi.backToHomePage();
    }
}
