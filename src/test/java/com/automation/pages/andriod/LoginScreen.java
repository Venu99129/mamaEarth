package com.automation.pages.andriod;

import com.automation.pages.ui.LoginUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen extends BaseScreen implements LoginUi {

    @FindBy(xpath = "//android.widget.TextView[@text='Login or Signup']")
    WebElement sigInText;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='text-input-outlined']")
    WebElement mobileField;

    @FindBy(xpath = "//android.widget.Button[@resource-id='button']")
    WebElement loginOTPBtn;

    @FindBy(xpath = "(//android.widget.EditText[@resource-id='text-input-outlined'])[4]")
    WebElement OTPField;

    public boolean verifyLoginUi() {
        return sigInText.isDisplayed();
    }
    


    public void doLogin(String mobileNumber) {
        mobileField.sendKeys(ConfigReader.getConfigValue(mobileNumber));
        loginOTPBtn.click();
    }

    public void waitUntilOTPEnter() {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(1));
            wait.until(driver -> !OTPField.getAttribute("text").isEmpty());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
