package com.automation.pages.web;

import com.automation.pages.ui.ManageAddressUi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageAddressPage extends BasePage implements ManageAddressUi {

    @FindBy(xpath = "//span[contains(text(),'Address')]")
    WebElement addressSection;

    @FindBy(xpath = "//button[@class='delete']")
    WebElement deleteAddressBtn;

    @FindBy(xpath = "//button[@class='confirm-btn']")
    WebElement confirmBtn;

    public void clickAddressSection(){
        addressSection.click();
    }

    @Override
    public void deleteAddress() {
        deleteAddressBtn.click();
        confirmBtn.click();
    }
}
