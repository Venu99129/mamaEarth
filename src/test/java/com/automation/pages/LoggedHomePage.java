package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class LoggedHomePage extends BasePage{

    @FindBy(xpath = "//div[@class='categorytitle']")
    WebElement categoryTitle;

    @FindBy(xpath = "")
    WebElement element;

    @FindBy(xpath = "//p[normalize-space()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger isLoggedIn']/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger isLoggedIn']/div[2]")
    WebElement userIconText;

    
    public void openTheBataWebsite() {
        driver.get(ConfigReader.getConfigValue("base.url"));
    }

    public boolean verifyISOnHomePage() {
        return categoryTitle.isDisplayed();
    }

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
        System.out.println(userIconText.getText());
        return userIconText.getText();
    }

    public void clickOnLogOut() {
        logoutLink.click();
    }


    public void mouseoverOnUserIcon() {
        mouseOverOn(userIcon);
    }
}
