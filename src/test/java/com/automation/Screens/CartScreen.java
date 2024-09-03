package com.automation.Screens;

import com.automation.UI.CartUi;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DecimalFormat;
import java.util.List;

public class CartScreen extends BaseScreen implements CartUi {
    @FindBy(xpath = "//android.widget.TextView[@text='Your cart']")
    WebElement cartText;

    @FindBy(xpath = "//android.widget.TextView[@text='To Pay']/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement toPayAmount;

    @FindBy(xpath = "//android.widget.TextView[@text='Woohoo! Thanks']")
    WebElement cartPopUp;

    @Override
    public boolean verifyCartUi() {
        return cartText.isDisplayed();
    }

    @Override
    public void clickOnFirstCouponBtn() {
        DriverManager.setImplicitlyWait(5);
        while (true) {
            System.out.println("in while");
            List<WebElement> applyButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Apply']"));
            boolean inFlag = false;
            for (WebElement ele : applyButtons) {
                System.out.println("in for");
                System.out.println(ele.isEnabled());
                if (ele.isDisplayed()) {
                    ele.click();
                    try {
                        if (driver.findElement(By.xpath("//android.widget.TextView[@text='Woohoo! Thanks']")).isDisplayed())
                            inFlag = true;
                        break;
                    }catch (Exception ignored){}
                }
            }
            if (inFlag) break;
            scrollOrSwipe(900, 600,  200, 600);
        }
        DriverManager.setImplicitlyWait(60);
    }

    @Override
    public boolean verifyCouponApplied() {
        return cartPopUp.isDisplayed();
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Order Total']/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement orderAmount;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Discount')]/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement discountAmount;

    @FindBy(xpath = "//android.widget.TextView[@text='Shipping']/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement shippingAmount;


    @Override
    public boolean verifyCartAmountWithCouponAmount() {
        DriverManager.setImplicitlyWait(2);
        while (true) {
            try {
                toPayAmount = driver.findElement(By.xpath("//android.widget.TextView[@text='To Pay']/following-sibling::android.view.ViewGroup/android.widget.TextView"));
                if (toPayAmount.isDisplayed()) break;
            } catch (Exception e) {
                scrollWindow();}
        }
        DriverManager.setImplicitlyWait(60);
        double extraDiscountPrice = 0;
        try {
            List<WebElement> extraDiscountAmount = driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'discount')]/following-sibling::android.view.ViewGroup/android.widget.TextView"));

            for (WebElement i : extraDiscountAmount){
                extraDiscountPrice += filterAmount(i.getAttribute("text"));
                System.out.println("extra amount "+i.getAttribute("text"));
            }
        }catch (Exception ignored){}

        double orderPrice = filterAmount(orderAmount.getAttribute("text"));
        double shippingPrice = 0;
        double discountPrice = 0;
        if(!shippingAmount.getAttribute("text").contains("Free"))
            shippingPrice = filterAmount(shippingAmount.getAttribute("text"));
        System.out.println(shippingAmount.getAttribute("text"));

        if(displayedElement(discountAmount)) discountPrice = filterAmount(discountAmount.getAttribute("text"));
        System.out.println(discountAmount.getAttribute("text"));

        double finalPrice = filterAmount(toPayAmount.getAttribute("text"));
        System.out.println(toPayAmount.getAttribute("text"));

        System.out.println(orderPrice+"  "+shippingPrice+"   "+discountPrice+"  "+extraDiscountPrice);
        double tempFinal = orderPrice+shippingPrice-discountPrice-extraDiscountPrice;

        DecimalFormat df = new DecimalFormat("#.00");
        tempFinal = Double.parseDouble(df.format(tempFinal));

        return finalPrice == tempFinal;




    }

    @Override
    public boolean verifySameVariantIsAddedIntoCart() {
        return false;
    }

    @Override
    public String getProductName() {
        return "";
    }

    @Override
    public String getProductQuantityInCart() {
        return "";
    }

    @Override
    public void clickOnPlaceOrderBtn() {
    }

    @Override
    public void clickOnAddAddressBtn() {

    }

    @Override
    public void fillTheAddressDetails() {

    }

    @Override
    public void removeProduct() {

    }
}
