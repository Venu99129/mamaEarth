package com.automation.pages.web;

import com.automation.pages.ui.OrderConfirmedUi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmPage extends BasePage implements OrderConfirmedUi {

    @FindBy(css = ".thankyoutext")
    WebElement confirmText;

    @Override
    public boolean verifyOrderConfirmation() {
        return confirmText.isDisplayed();
    }
}
