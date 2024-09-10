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
    WebElement successPopup;

    @FindBy(xpath = "//tbody/tr/td[2][not(contains(@class,\"out-of-stock\"))]/ancestor::div[@class='variant']")
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

        return presentWithNonDisplay(successPopup);
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    @Override
    public void clickOnBackArrowProductPage() {}

    @FindBy(className = "button-desktop")
    WebElement rateProductBtn;

    @Override
    public void clickOnRateProduct() {
        int x =500,y=500;
        for (int i=0;true;i++){
            //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[@class='product-description-header']"))));
            System.out.println("above if");
            if(displayedElement(rateProductBtn)) {
                rateProductBtn.click();
                break;
            }
            else scrollWindowOrSlide(x+=100,y+=100);
            //if(i==0) scrollWindowOrSlide(0,0);

        }
    }

    @FindBy(xpath = "//div[text()='Was Okay']/preceding-sibling::img")
    WebElement star3;

    @FindBy(xpath = "//div[text()='Hated it']/preceding-sibling::img")
    WebElement star1;

    @FindBy(xpath = "//div[text()='Hated it']/../following-sibling::div/img")
    WebElement star2;

    @FindBy(xpath = "//div[text()='Liked it']/preceding-sibling::img")
    WebElement star4;

    @FindBy(xpath = "//div[text()='Loved it']/preceding-sibling::img")
    WebElement star5;

    @Override
    public void clickOnGivenStar(String num) {
        int n = Integer.parseInt(num);

        switch (n){
            case 1 -> star1.click();
            case 2 -> star2.click();
            case 3 -> star3.click();
            case 4 -> star4.click();
            case 5 -> star5.click();
        }
    }

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameField;

    @FindBy(xpath = "//textarea[@placeholder='Message']")
    WebElement messageField;

    @Override
    public void fillNameAndReview(String name, String feedback) {
        nameField.sendKeys(name);
        messageField.sendKeys(feedback);
    }

    @FindBy(xpath = "//button[text()='Submit']")
    WebElement reviewSubmitBtn;

    @Override
    public void clickOnSubmitBtn() {
        clickAnyway(reviewSubmitBtn);
    }

    @Override
    public boolean verifySuccessToastDisplayed() {
        return presentWithNonDisplay(successPopup);

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
