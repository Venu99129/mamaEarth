package com.automation.pages.web;

import com.automation.pages.ui.LoggedHomeUi;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends BasePage implements LoggedHomeUi {



//    @FindBy(xpath = "")
//    WebElement element;

    @FindBy(xpath = "//div[contains(@class,'cart-trigger')]")
    WebElement cartIcon;

    @FindBy(xpath = "//p[contains(text(),'Logout')]")
    WebElement logoutLink;

    @FindBy(xpath = "//div[contains(@class,'user-account-trigger isLoggedIn')]/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//div[contains(@class,'user-account-trigger isLoggedIn')]/div[2]")
    WebElement userIconText;

    @FindBy(xpath = "//p[normalize-space()='Manage Address']")
    WebElement manageAddressLink;




    public void clickOnUserIcon() {
        handleOfferAlert();
        userIcon.click();
    }

    public String verifyLoginWithUserIcon(){
        return userIconText.getText();
    }

    public void clickOnLogOut() {
        logoutLink.click();
    }

    public void clickOnCartIcon(){
        cartIcon.click();
    }

    public void mouseoverOnUserIcon() {
        mouseOverOn(userIcon);
    }
    public void mouseoverOnBurgerMenu(){}

    @Override
    public String verifyLoginWithBergerMenu() {
        return "";
    }

    @Override
    public void clickOnManageAddress() {
        manageAddressLink.click();
    }
}
