package com.automation.steps;

import com.automation.pages.andriod.LoginScreen;
import com.automation.pages.ui.LoginUi;
import com.automation.pages.web.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep {

    LoginUi loginui;

    public LoginStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) loginui = new LoginPage();
        else loginui = new LoginScreen();
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
