package com.automation.steps;

import com.automation.Screens.LoginScreen;
import com.automation.UI.LoginUi;
import com.automation.pages.LoginPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep {

    LoginUi loginui;

    public LoginStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("mobile") ) loginui = new LoginScreen();
        else loginui = new LoginPage();
    }

    @Then("user should see the login page")
    public void i_should_see_the_login_page() {
        Assert.assertTrue(loginui.verifyLoginUi());
    }

    @When("user log in with mobile number {string}")
    public void i_log_in_with_email_and_password(String mobileNumber) {
        loginui.doLogin(mobileNumber);
    }


    @Then("user enter OTP manually")
    public void enterOTPManually() {
        loginui.waitUntilOTPEnter();
    }

}
