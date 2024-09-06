package com.automation.pages.andriod;

import com.automation.pages.ui.ProductUi;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductScreen extends BaseScreen implements ProductUi {

    @FindBy(xpath = "//android.widget.HorizontalScrollView/../following-sibling::android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView[1]")
    WebElement productName;

    @FindBy(xpath = "//android.widget.HorizontalScrollView/../following-sibling::android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.HorizontalScrollView/android.view.ViewGroup")
    WebElement variantSection;

    @FindBy(xpath = "//android.widget.ImageView/../../preceding-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[contains(@text,'₹')][1]")
    WebElement eachProductAmount;
    
    @FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    WebElement addToCartBtn;

    @FindBy(xpath = "//android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    WebElement cartIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='View Cart']")
    WebElement viewCartBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Recommendations for you\"]/../preceding-sibling::android.view.ViewGroup/android.widget.ImageView")
    WebElement closeCartPopUp;

    @Override
    public boolean verifyUserIsOnProductDescriptionUi() {
        return productName.isDisplayed();
    }

    @Override
    public void userSelectsTheVariant() {
        if(displayedElement(variantSection)){
            List<WebElement> variants = variantSection.findElements(By.xpath("./android.view.ViewGroup"));
            System.out.println(variants.size());
            variants.get(variants.size()-1).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean userClicksAddToCart() {
        ConfigReader.setConfigValue("product.name",productName.getText().trim());
        ConfigReader.setConfigValue("product.price",eachProductAmount.getText().trim());
        addToCartBtn.click();
        if(displayedElement(closeCartPopUp)) closeCartPopUp.click();
        return viewCartBtn.isDisplayed();
    }

    @Override
    public void selectGivenQuantity(String qty) {}

    @Override
    public void mouseOverOnUserIcon() {}

    @Override
    public void clickOnLogOut() {}

    @Override
    public void clickOnCartIcon() {
        cartIcon.click();
    }
}
