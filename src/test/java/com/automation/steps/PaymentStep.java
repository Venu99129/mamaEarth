package com.automation.steps;

import com.automation.pages.andriod.PaymentScreen;
import com.automation.pages.ui.PaymentUi;
import com.automation.pages.web.PaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaymentStep {
    PaymentUi paymentUi;
    public PaymentStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) paymentUi = new PaymentPage();
        else   paymentUi = new PaymentScreen();
    }

    @Then("verify user is on payment page")
    public void verifyUserIsOnPaymentPage() {
        Assert.assertTrue(paymentUi.verifyPaymentPage());
    }

    @When("click on cash on delivery option")
    public void clickOnCashOnDeliveryOption() {
        paymentUi.clickOnCashAndDeliveryBtn();
    }


    @And("place the order")
    public void placeTheOrder() {
        paymentUi.clickOnPlaceTheOrder();
    }

    @When("back to cart page")
    public void backToCartPage() {
        paymentUi.clickOnCartText();
    }
}
