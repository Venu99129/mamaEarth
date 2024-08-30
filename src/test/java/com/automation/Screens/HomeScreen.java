package com.automation.Screens;

import com.automation.UI.HomeUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeScreen extends BaseScreen implements HomeUi{


    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Search for ')]")
    WebElement searchBarTittle;

    @FindBy(xpath = "(//android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView)[4]")
    WebElement cartIcon;

    @FindBy(xpath = "")
    WebElement element;

    @FindBy(xpath = "//android.widget.ImageView/following-sibling::android.view.ViewGroup[1]")
    WebElement bergerMenu;

    @FindBy(xpath = "//android.widget.ImageView/following-sibling::android.view.ViewGroup[4]")
    WebElement userIcon;

    @FindBy(xpath = "//android.view.ViewGroup/com.horcrux.svg.SvgView[3]/preceding-sibling::android.widget.TextView[1]")
    WebElement userIconText;

    @FindBy(xpath = "//div[@class='product-detail-wrap']/div")
    List<WebElement> products;



    public void openTheMamaEarthWebsite() {
        handleOfferAlert();
    }

    public boolean verifyISOnHomeUi() {
        return searchBarTittle.isDisplayed();
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
        bergerMenu.click();
        if(userIconText.getText().trim().contains("Guest")) return "Login";
        return userIconText.getText();
    }

    public void mouseoverOnUserIcon() {
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

    @Override
    public void clickOnBestSellersFirstProduct() {
    }


    @Override
    public boolean verifyCartPop() {
        return false;
    }


    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void mouseOverOnMenuItem(String category) {
        handleOfferAlert();
        String itemXpath = "//li[@class='category']/a[text()='%s']";
        WebElement menuItem = driver.findElement(By.xpath(String.format(itemXpath, category)));
        mouseOverOn(menuItem);
    }

    public void clickOnSubMenuItem(String subCategory) {
        String subMenuXpath = "//a[text()='%s']";
        clickAnyway(driver.findElement(By.xpath(String.format(subMenuXpath,subCategory))));
    }

    public void userClicksOnAProduct() {
        for(WebElement ele :products){
            if(displayedElement(ele)) {
                ele.click();
                break;
            }
        }
    }
}
