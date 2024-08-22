package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStep {

    LoginPage loginPage = new LoginPage();

    @Then("user should see the login page")
    public void i_should_see_the_login_page() {
        Assert.assertTrue(loginPage.verifyLoginPage());
    }

    @When("user log in with mobile number {string}")
    public void i_log_in_with_email_and_password(String mobileNumber) {
        loginPage.doLogin(mobileNumber);
    }


    @Then("user enter OTP manually")
    public void enterOTPManually() {
        loginPage.waitUntilOTPEnter();
    }

}
