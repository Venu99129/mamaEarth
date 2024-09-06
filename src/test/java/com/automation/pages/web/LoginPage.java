package com.automation.pages.web;

import com.automation.pages.ui.LoginUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage implements LoginUi {

    @FindBy(className = "login-signup-div")
    WebElement sigInText;

    @FindBy(xpath = "//input[@placeholder='Mobile number']")
    WebElement mobileField;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginOTPBtn;

    @FindBy(xpath = "//div[@class='digit-group']/input[4]")
    WebElement OTPField;

    public boolean verifyLoginUi() {
        return sigInText.isDisplayed();
    }

    public void doLogin(String mobileNumber) {
        mobileField.sendKeys(ConfigReader.getConfigValue(mobileNumber));
        //handleOfferAlert();
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
