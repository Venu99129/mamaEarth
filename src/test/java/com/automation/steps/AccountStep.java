package com.automation.steps;

import com.automation.pages.andriod.AccountScreen;
import com.automation.pages.ui.AccountUi;
import com.automation.pages.web.AccountPage;
import io.cucumber.java.en.When;

public class AccountStep {
    AccountUi accountUi;

    public AccountStep(){
        String runningPlatform = System.getProperty("env");
        if(runningPlatform.equals("web")) accountUi = new AccountPage();
        else accountUi = new AccountScreen();
    }

    @When("close the account page")
    public void closeTheAccountPage() {
        accountUi.clickOnClosePoolBtn();
        accountUi.clickOnBackArrow();
    }
}
