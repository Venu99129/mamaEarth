package com.automation.pages;

import com.automation.UI.LoggedHomeUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomePage extends BasePage implements LoggedHomeUi {



    @FindBy(xpath = "")
    WebElement element;

    @FindBy(xpath = "//com.horcrux.svg.SvgView/following-sibling::android.widget.TextView[@text='Home']")
    WebElement homeOption;

    @FindBy(xpath = "//div[contains(@class,'cart-trigger')]")
    WebElement cartIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[contains(@class,'user-account-trigger isLoggedIn')]/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//div[contains(@class,'user-account-trigger isLoggedIn')]/div[2]")
    WebElement userIconText;




    public void clickOnUserIcon() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        handleOfferAlert();
        userIcon.click();
    }

    public String verifyLoginWithUserIcon(){
        if(homeOption.isDisplayed()){
            return ConfigReader.getConfigValue("user.name");
        }
        return "";
    }

    public void clickOnLogOut() {
        logoutLink.click();
    }

    public void clickOnCartIcon(){
        cartIcon.click();
    }

    public void mouseoverOnUserIconOrBurgerMenu() {
        mouseOverOn(userIcon);
    }
}
