package com.automation.pages.web;

import com.automation.pages.ui.PaymentUi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage implements PaymentUi {

    @FindBy(xpath = "//div[@class='step-container']/div[contains(text(),'Payment')]")
    WebElement paymentText;

    @FindBy(xpath = "//div[@class='step-container']/div[contains(text(),'Cart')]")
    WebElement cartText;

    @FindBy(xpath = "//div[@class='button-text'][contains(text(),'Cash on Delivery')]")
    WebElement cashOnDeliveryBtn;

    @FindBy(xpath = "//button[text()='PLACE ORDER']")
    WebElement placeOrderBtn;

    public boolean verifyPaymentPage() {
        return paymentText.isDisplayed();
    }

    @Override
    public void clickOnCashAndDeliveryBtn() {
        cashOnDeliveryBtn.click();
    }

    @Override
    public void clickOnPlaceTheOrder() {
        jsClick(placeOrderBtn);
    }

    @Override
    public void clickOnCartText() {
        jsClick(cartText);
    }


}
