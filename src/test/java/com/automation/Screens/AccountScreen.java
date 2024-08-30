package com.automation.Screens;

import com.automation.UI.AccountUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountScreen extends BaseScreen implements AccountUi {

    @FindBy(xpath = "//com.horcrux.svg.SvgView/../preceding-sibling::android.view.ViewGroup/android.widget.ImageView")
    WebElement closePoolBtn;
    
    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Hello, ')]")
    WebElement userName;

    @FindBy(xpath = "//android.widget.TextView[@text='\uE61C']")
    WebElement backArrow;

    public void clickOnClosePoolBtn(){
        if(displayedElement(closePoolBtn)){
            closePoolBtn.click();
        }
    }

    public void clickOnBackArrow(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String accountHolderName = (userName.getAttribute("text").split(","))[1].trim();
        ConfigReader.setConfigValue("user.name",accountHolderName);
        backArrow.click();
    }

}
