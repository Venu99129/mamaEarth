package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='categorytitle']")
    WebElement categoryTitle;

    @FindBy(xpath = "")
    WebElement element;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger']/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger']/div[2]")
    WebElement userIconText;


    public void openTheBataWebsite() {
        driver.get(ConfigReader.getConfigValue("base.url"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        handleOfferAlert();
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

    public String verifyLoginWithUserIcon() {
        return userIconText.getText();
    }

    public void mouseoverOnUserIcon() {
        mouseOverOn(userIcon);
    }


    public void clickOnMenuItem(String itemCat) {
        handleOfferAlert();
        String itemXpath = "//li[@class='category']/a[text()='%s']";
        driver.findElement(By.xpath(String.format(itemXpath, itemCat))).click();
        ConfigReader.setConfigValue("itemCat", itemCat);
    }

    public void searchSearchBar(String productName) {
        driver.findElement(By.xpath("//div[@class='ShortSearchBar']/div[2]")).click();
        driver.findElement(By.xpath("//div[@class='ShortSearchBar']/input"))
                .sendKeys(productName + Keys.ENTER);
    }
}
