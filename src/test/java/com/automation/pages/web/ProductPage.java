package com.automation.pages.web;

import com.automation.pages.ui.ProductUi;
import com.automation.utils.ConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage implements ProductUi {

    @FindBy(className = "product-description-header")
    WebElement productDescriptionText;

    @FindBy(className = "plus-icon")
    WebElement plusIcon;

    @FindBy(className = "minus-icon")
    WebElement minusIcon;

    @FindBy(className = "product-name")
    WebElement productName;

    @FindBy(xpath = "//div[contains(@class,'cart-trigger')]")
    WebElement cartIcon;

    @FindBy(xpath = "//span[text()='Select Variant']")
    WebElement productVariantText;

    @FindBy(xpath = "//button//span[contains(text(),'Add To Cart')]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='ct-toast  ct-toast-success']//div[@class='ct-text']")
    WebElement cartSuccessPopup;

    @FindBy(xpath = "//div[@class='variant-group']//div[@class='variant']")
    List<WebElement> unSelectedVariants;

    @FindBy(xpath = "//div[contains(@class,'user-account-trigger isLoggedIn')]/div[1]")
    WebElement userIcon;

    @FindBy(xpath = "//p[normalize-space()='Logout']")
    WebElement logoutLink;

    @FindBy(xpath = "//div[@class='price-container']/td")
    WebElement productPrice;

    public boolean verifyUserIsOnProductDescriptionUi() {
        return productDescriptionText.isDisplayed();
    }

    public void userSelectsTheVariant() {
        try {
            if(productVariantText.isDisplayed()) {
                if (unSelectedVariants.get(0).isDisplayed()) {
                    unSelectedVariants.get(0).click();
                    Thread.sleep(2000);
                }
            }
        } catch (Exception ignored) {}

        productPrice = driver.findElement(By.xpath("//tr[@class='price-container']/td"));
        ConfigReader.setConfigValue("product.price",productPrice.getText());
    }

    public boolean userClicksAddToCart() throws InterruptedException {
        Thread.sleep(2000);

        if (productName.isDisplayed()) ConfigReader.setConfigValue("product.name", productName.getText());

        WebElement productQuantity = driver.findElement(By.xpath("//div[contains(@class,'qty-selector')]/span"));
        ConfigReader.setConfigValue("product.quantity", productQuantity.getText());
        addToCartBtn.click();

        return presentWithNonDisplay(cartSuccessPopup);
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void selectGivenQuantity(String qty) {

        int quantity = Integer.parseInt(qty);
        if (quantity >= 1) {
            int productQuantity = Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'qty-selector')]/span")).getText());
            while (quantity != productQuantity) {
                if (quantity > productQuantity) plusIcon.click();
                if (quantity < productQuantity) minusIcon.click();

                productQuantity = Integer.parseInt(driver.findElement(By.xpath("//div[contains(@class,'qty-selector')]/span")).getText());
            }
        }else System.out.println("please give quantity minimum 1  !");
    }

    public void mouseOverOnUserIcon(){
        mouseOverOn(userIcon);
    }

    public void clickOnLogOut(){
        logoutLink.click();
    }
}
