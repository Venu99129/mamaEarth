package com.automation.pages.andriod;

import com.automation.pages.ui.PaymentUi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentScreen extends BaseScreen implements PaymentUi {

    @FindBy(xpath = "//android.widget.TextView[@text='Payment Options']")
    WebElement paymentText;

    @FindBy(xpath = "//android.widget.TextView[@text='Cash on delivery (COD)']")
    WebElement cashOnDeliveryBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Pay via Cash')]")
    WebElement payViaCashBtn;

    @Override
    public boolean verifyPaymentPage() {
        return paymentText.isDisplayed();
    }

    public void clickOnCashAndDeliveryBtn() {
        cashOnDeliveryBtn.click();
    }

    @Override
    public void clickOnPlaceTheOrder() {
        payViaCashBtn.click();
    }

    @Override
    public void clickOnCartText() {

    }
}
