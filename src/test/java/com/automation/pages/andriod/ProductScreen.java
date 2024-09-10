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

    @FindBy(xpath = "//android.widget.TextView[@text='Recommendations for you']/../preceding-sibling::android.view.ViewGroup/android.widget.ImageView")
    WebElement closeCartPopUp;

    @FindBy(xpath = "(//android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView)[1]")
    WebElement backArrow;

    @Override
    public boolean verifyUserIsOnProductDescriptionUi() {
        return productName.isDisplayed();
    }

    @Override
    public void userSelectsTheVariant() {
        if (displayedElement(variantSection)) {
            List<WebElement> variants = variantSection.findElements(By.xpath("./android.view.ViewGroup"));
            System.out.println(variants.size());
            variants.get(variants.size() - 1).click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } else System.out.println("only one variant available for the product"); // add log in reports
    }

    @Override
    public boolean userClicksAddToCart() {
        ConfigReader.setConfigValue("product.name", productName.getText().trim());
        ConfigReader.setConfigValue("product.price", eachProductAmount.getText().trim());
        addToCartBtn.click();
        if (displayedElement(closeCartPopUp)) closeCartPopUp.click();
        return viewCartBtn.isDisplayed();
    }

    @Override
    public void selectGivenQuantity(String qty) {
    }

    @Override
    public void mouseOverOnUserIcon() {
    }

    @Override
    public void clickOnLogOut() {
    }

    @Override
    public void clickOnCartIcon() {
        cartIcon.click();
    }

    @Override
    public void clickOnBackArrowProductPage() {
        backArrow.click();
    }

    @Override
    public void clickOnRateProduct() {
    }

    @FindBy(xpath = "//android.widget.TextView[@text='We’d Really Appreciate Your Feedback']/following-sibling::android.view.ViewGroup[1]/android.widget.ImageView")
    WebElement star1;
    @FindBy(xpath = "//android.widget.TextView[@text='We’d Really Appreciate Your Feedback']/following-sibling::android.view.ViewGroup[2]/android.widget.ImageView")
    WebElement star2;
    @FindBy(xpath = "//android.widget.TextView[@text='We’d Really Appreciate Your Feedback']/following-sibling::android.view.ViewGroup[3]/android.widget.ImageView")
    WebElement star3;
    @FindBy(xpath = "//android.widget.TextView[@text='We’d Really Appreciate Your Feedback']/following-sibling::android.view.ViewGroup[4]/android.widget.ImageView")
    WebElement star4;
    @FindBy(xpath = "//android.widget.TextView[@text='We’d Really Appreciate Your Feedback']/following-sibling::android.view.ViewGroup[5]/android.widget.ImageView")
    WebElement star5;


    @Override
    public void clickOnGivenStar(String num) {
        while (!displayedElement(star1)) {
            scrollWindow();
        }
        scrollWindow();
        scrollWindow();

        int n = Integer.parseInt(num);

        switch (n) {
            case 1 -> {
                star1.click();
                star1.click();
            }
            case 2 -> {
                star2.click();
                star2.click();
            }
            case 3 -> {
                star3.click();
                star3.click();
            }
            case 4 -> {
                star4.click();
                star4.click();
            }
            case 5 -> {
                star5.click();
                star5.click();
            }
        }
    }

    @FindBy(xpath = "//android.widget.EditText[@text=\"Enter your name\"]")
    WebElement nameField;

    @FindBy(xpath = "//android.widget.EditText[@text=\"Tell us what you like and dislike about this product...\"]")
    WebElement feedBackField;

    @Override
    public void fillNameAndReview(String name, String feedback) {
        nameField.sendKeys(name);
        feedBackField.sendKeys(feedback);
    }

    @FindBy(xpath = "//android.widget.TextView[@text=\"Submit\"]")
    WebElement reviewSubmitBtn;

    @Override
    public void clickOnSubmitBtn() {
        tabClick(reviewSubmitBtn);
    }

    @FindBy(xpath = "//android.widget.TextView[@resource-id=\"toastText1\"]")
    WebElement feedBackSuccessToast;

    @Override
    public boolean verifySuccessToastDisplayed() {
        return feedBackSuccessToast.isDisplayed();
    }
}
