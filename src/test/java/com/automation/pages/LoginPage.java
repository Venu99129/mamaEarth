package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(className = "login-signup-div")
    WebElement sigInText;

    @FindBy(xpath = "//input[@placeholder='Mobile number']")
    WebElement mobileField;

    @FindBy(id = "login-form-password")
    WebElement passwordField;

    @FindBy(css=".wzrk-alert wiz-show-animate")
    WebElement offersAlert;

    @FindBy( id = "wzrk-cancel-id")
    WebElement offersAlertCancelBtn;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginOTPBtn;

    @FindBy(xpath = "//div[@class='digit-group']/input[4]")
    WebElement OTPField;

    public boolean verifyLoginPage() {
        return sigInText.isDisplayed();
    }


    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger']/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger']/div[2]")
    WebElement userIconText;


    public void doLogin(String mobileNumber) {
        mobileField.sendKeys(ConfigReader.getConfigValue(mobileNumber));
        //handleOfferAlert(offersAlert,offersAlertCancelBtn);
        loginOTPBtn.click();
    }

    public void waitUntilOTPEnter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
            wait.until(driver -> !OTPField.getAttribute("value").isEmpty());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
