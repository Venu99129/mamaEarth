package com.automation.pages.ui;

public interface LoginUi {

    public void doLogin(String mobileNumber);
    public void waitUntilOTPEnter();
    public boolean verifyLoginUi();
}
