package com.automation.pages.andriod;

import com.automation.pages.ui.LoggedHomeUi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomeScreen extends BaseScreen implements LoggedHomeUi {

    @FindBy(xpath = "//android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    WebElement cartIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//android.widget.ImageView/following-sibling::android.view.ViewGroup[4]/com.horcrux.svg.SvgView")
    WebElement userIcon;

    @FindBy(xpath = "//android.view.ViewGroup/android.view.ViewGroup/com.horcrux.svg.SvgView[2]/following-sibling::android.widget.TextView[1]")
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
    public String verifyLoginWithUserIcon() {return "";}
    public String verifyLoginWithBergerMenu() {

        mouseoverOnBurgerMenu();
        String username  = userIconText.getText();
        System.out.println(userIconText.isDisplayed()+" "+userIcon.getText());
        if(username.trim().contains("Guest")) return "Login";
        closeBurgerMenu();
        return username;
    }

    @Override
    public void clickOnManageAddress() {

    }

    public void clickOnLogOut() {
        logoutLink.click();
        closeBurgerMenu();
    }

    public void mouseoverOnUserIcon() {
    }

    public void clickOnCartIcon(){
        cartIcon.click();
    }

    @Override
    public void mouseoverOnBurgerMenu() {
        waitForElementToBeVisible("(//android.widget.ImageView/following-sibling::android.view.ViewGroup/android.widget.ImageView)[1]");
        waitForElementToBeClickable("(//android.widget.ImageView/following-sibling::android.view.ViewGroup/android.widget.ImageView)[1]");

        driver.findElement(By.xpath("(//android.widget.ImageView/following-sibling::android.view.ViewGroup/android.widget.ImageView)[1]")).click();
        System.out.println("first time clicked burger menu");
    }
}
