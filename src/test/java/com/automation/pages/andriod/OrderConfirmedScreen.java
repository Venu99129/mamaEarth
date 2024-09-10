package com.automation.pages.andriod;

import com.automation.pages.ui.OrderConfirmedUi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderConfirmedScreen extends BaseScreen implements OrderConfirmedUi {
    
    @FindBy(xpath = "//android.widget.TextView[@text='Thank you, your order has been placed!!']")
    WebElement conformText;
    
    public boolean verifyOrderConfirmation(){
        return conformText.isDisplayed();
    }
}
