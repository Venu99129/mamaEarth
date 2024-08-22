package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='categorytitle']")
    WebElement categoryTitle;

    @FindBy(xpath ="//div[@class='categorytitle'][text()='Best Sellers']/../../following-sibling::div//div[@class='product-card-slide-desktop']//span[text()='Add To Cart']")
    List<WebElement> bestSellerItemsAddToCart;

    @FindBy(css = ".ct-toast.ct-toast-success")
    WebElement cartPopUp;

    @FindBy(className = "cart-icon")
    WebElement cartIcon;

    @FindBy(xpath = "")
    WebElement element;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger']/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//div[@class='sc-iAyFgw jNwXbb user-account-trigger']/div[2]")
    WebElement userIconText;

    @FindBy(xpath = "//div[@class='product-detail-wrap']/div")
    List<WebElement> products;



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

    public void clickOnBestSellersFirstProduct() {
        for(WebElement addToCart : bestSellerItemsAddToCart){
            if(displayedElement(addToCart)){
                addToCart.click();
                break;
            }
        }
    }



    public boolean verifyCartPop() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {}
        return cartPopUp.isDisplayed();
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
