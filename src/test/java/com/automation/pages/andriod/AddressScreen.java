package com.automation.pages.andriod;

import com.automation.pages.ui.AddressUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressScreen extends BaseScreen implements AddressUi {

    @FindBy(xpath = "//android.widget.TextView[ @text='First Name*']/../following-sibling::android.widget.EditText")
    WebElement firstNameField;

    @FindBy(xpath = "//android.widget.TextView[ @text='Last Name*']/../following-sibling::android.widget.EditText")
    WebElement lastNameField;

    @FindBy(xpath = "//android.widget.TextView[ @text='Email*']/../following-sibling::android.widget.EditText")
    WebElement emailField;

    @FindBy(xpath = "//android.widget.TextView[ @text='Mobile Number*']/../following-sibling::android.widget.EditText")
    WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.TextView[ @text='PIN Code*']/../following-sibling::android.widget.EditText")
    WebElement pinCodeField;

    @FindBy(xpath = "//android.widget.TextView[ @text='Address*']/../following-sibling::android.widget.EditText")
    WebElement addressField;

    @FindBy(xpath = "//android.widget.TextView[@text='Work']")
    WebElement workAddressType;

    @FindBy(xpath = "//android.widget.TextView[@text='Save Address']")
    WebElement saveAddressBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Add New Address']")
    WebElement addressText;

    @FindBy(xpath = "//android.widget.TextView[@text='City*']")
    WebElement cityField;

    @Override
    public boolean verifyAddressPage() {
        return addressText.isDisplayed();
    }

    @Override
    public void clickOnProceedToPayBtn() {
    }

    @Override
    public void verifyAddressDetails() {
    }

    public void fillAddressDetails() {
        firstNameField.sendKeys(ConfigReader.getConfigValue("address.first.name"));
        lastNameField.sendKeys(ConfigReader.getConfigValue("address.last.name"));
        emailField.sendKeys(ConfigReader.getConfigValue("address.email"));
        mobileNumberField.sendKeys(ConfigReader.getConfigValue("address.mobile"));
        pinCodeField.sendKeys(ConfigReader.getConfigValue("address.postal"));
        addressField.sendKeys(ConfigReader.getConfigValue("address.address"));

        workAddressType.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(driver -> !(cityField.getAttribute("text").isEmpty() || cityField.getAttribute("text").equals(" ")));

        saveAddressBtn.click();
    }

    @Override
    public void fillAddressDetailsWithLogin() {
        pinCodeField.sendKeys(ConfigReader.getConfigValue("address.postal"));
        addressField.sendKeys(ConfigReader.getConfigValue("address.address"));

        workAddressType.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
        wait.until(driver -> !(cityField.getAttribute("text").isEmpty() || cityField.getAttribute("text").equals(" ")));

        saveAddressBtn.click();
    }
}
