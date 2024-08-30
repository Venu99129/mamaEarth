package com.automation.pages;

import com.automation.utils.ConfigReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

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

    @FindBy(xpath = "//div[contains(@class,'user-account-trigger isLoggedIn')]/div[2]")
    WebElement userIconText;

    @FindBy(xpath = "//p[normalize-space()='Logout']")
    WebElement logoutLink;

    public boolean verifyUserIsOnProductDescriptionPage() {
        return productDescriptionText.isDisplayed() & productVariantText.isDisplayed();
    }

    public void userSelectsTheVariant() {
        try {
            Thread.sleep(2000);
            if (unSelectedVariants.get(0).isDisplayed()) {
                String tittle = unSelectedVariants.get(0).findElement(By.xpath("//div[@class='item-title']/span")).getText();
                System.out.println(tittle);
                ConfigReader.setConfigValue("selectedMl", tittle);
                unSelectedVariants.get(0).click();
            }
        } catch (Exception e) {
        }
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
