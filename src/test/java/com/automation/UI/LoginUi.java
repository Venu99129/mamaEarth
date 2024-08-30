package com.automation.UI;

public interface LoginUi {

    public void doLogin(String mobileNumber);
    public void waitUntilOTPEnter();
    public boolean verifyLoginUi();
}
