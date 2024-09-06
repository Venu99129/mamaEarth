package com.automation.pages.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage {

    @FindBy(xpath = "//div[@class='step-container']/div[contains(text(),'Payment')]")
    WebElement paymentText;

    //div[@class="button-text"][contains(text(),'Cash on Delivery')]

    //button[text()='PLACE ORDER']

    public boolean verifyPaymentPage(){
        return paymentText.isDisplayed();
    }
}
