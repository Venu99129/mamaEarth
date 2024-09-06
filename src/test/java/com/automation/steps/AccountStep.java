package com.automation.steps;

import com.automation.pages.andriod.AccountScreen;
import com.automation.pages.ui.AccountUi;
import com.automation.pages.web.AccountPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.When;

public class AccountStep {
    AccountUi accountUi;

    public AccountStep(){
        if(ConfigReader.getConfigValue("running.platform").equals("web")) accountUi = new AccountPage();
        else accountUi = new AccountScreen();
    }

    @When("close the account page")
    public void closeTheAccountPage() {
        accountUi.clickOnClosePoolBtn();
        accountUi.clickOnBackArrow();
    }
}
