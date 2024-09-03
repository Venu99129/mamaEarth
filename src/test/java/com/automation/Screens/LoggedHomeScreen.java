package com.automation.Screens;

import com.automation.UI.LoggedHomeUi;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedHomeScreen extends BaseScreen implements LoggedHomeUi {

    @FindBy(xpath = "//div[contains(@class,'cart-trigger')]")
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

    public String verifyLoginWithUserIcon() {

        mouseoverOnUserIconOrBurgerMenu();
        String username  = userIconText.getText();
        System.out.println(userIconText.isDisplayed()+" "+userIcon.getText());
        if(username.trim().contains("Guest")) return "Login";
        close_burgerMenu();
        return username;
    }

    public void clickOnLogOut() {
        logoutLink.click();
        close_burgerMenu();
    }

    public void mouseoverOnUserIcon() {

    }

    public void clickOnCartIcon(){
        cartIcon.click();
    }

    @Override
    public void mouseoverOnUserIconOrBurgerMenu() {
        driver.findElement(By.xpath("(//android.widget.ImageView/following-sibling::android.view.ViewGroup/android.widget.ImageView)[1]")).click();
    }
}
