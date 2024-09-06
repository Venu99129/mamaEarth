package com.automation.steps;

import com.automation.pages.web.PaymentPage;
import io.cucumber.java.en.Then;

public class PaymentStep {
    PaymentPage paymentPage = new PaymentPage();

    @Then("verify user is on payment page")
    public void verifyUserIsOnPaymentPage() {
    }
}
