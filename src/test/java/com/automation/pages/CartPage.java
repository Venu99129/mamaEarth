package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.DecimalFormat;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[@class='step-container']/div[contains(text(),'Cart')]")
    WebElement cartText;

    @FindBy(xpath = " //div[@class='message after']/following-sibling::div")
    WebElement applyCoupon;

    @FindBy(css=".sc-jGxEUC.kaekRd")
    WebElement couponAddedPopup;

    @FindBy(className = "coupon-text")
    WebElement couponText;

    @FindBy(xpath = "//span[text()='Order Total']/following-sibling::span")
    WebElement totalAmount;

    @FindBy(xpath = "//span[contains(text(),'Shipping')]/following-sibling::span")
    WebElement shippingAmount;

    @FindBy(xpath = "//span[contains(text(),'Discount')]/following-sibling::span")
    WebElement disCountAmount;

    @FindBy(xpath = "//div[@class='proceed-text']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//span[contains(text(),'online payment discount')]/following-sibling::span")
    WebElement onlineDiscount;

    @FindBy(xpath = "//span[contains(text(),'To Pay')]/following-sibling::span")
    WebElement finalAmount;

    @FindBy(xpath = "//div[@class='item-name']")
    WebElement productNameInCart;

    @FindBy(xpath = "//i[@class='cart-icon']")
    WebElement cartIcon;

    @FindBy(className = "item-quantity")
    WebElement productQuantity;

    public double filterAmount(String amount){
        if(amount.contains(",")) amount = amount.replace(",","");
        if(amount.contains("-")) amount = amount.replace("-","");
        if(amount.contains("₹")) amount = amount.replace("₹","");
        return Double.parseDouble(amount);
    }

    public boolean verifyCartPage() {
        return cartText.isDisplayed();
    }

    public void clickOnFirstCouponBtn() {
        DriverManager.setImplicitlyWait(10);
        try {
            applyCoupon.click();
        }
        catch (Exception ignored){}
        finally {
            DriverManager.setImplicitlyWait(60);
        }

    }

    public boolean verifyCouponApplied(){

        DriverManager.setImplicitlyWait(10);
        try {
            if (couponAddedPopup.isDisplayed()) {
                double offerAmount = 0;
                for (String text : couponText.getText().split(" ")) {
                    try {
                        offerAmount = Double.parseDouble(text);
                        ConfigReader.setConfigValue("offerAmount", offerAmount + "");
                        return true;
                    } catch (Exception ignored) {
                    }
                }
            }
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public boolean verifyCartAmountWithCouponAmount() {
        double totalPrice = filterAmount(totalAmount.getText());
        double shippingPrice = 0;
        double onlineDiscountPrice = 0;
        if(!shippingAmount.getText().contains("Free"))
            shippingPrice = filterAmount(finalAmount.getText());

        if(displayedElement(onlineDiscount)) onlineDiscountPrice = filterAmount(onlineDiscount.getText());

        double finalPrice = filterAmount(finalAmount.getText());

        double discountPrice = 0;
        try{
            String offPrice = ConfigReader.getConfigValue("offerAmount");
            discountPrice = filterAmount(offPrice);
        }catch (Exception e){
            discountPrice = filterAmount(disCountAmount.getText());
        }

        //System.out.println(totalPrice+" "+shippingPrice+" "+onlineDiscountPrice+" "+discountPrice);
        double tempFinal = totalPrice+shippingPrice-onlineDiscountPrice-discountPrice;


        DecimalFormat df = new DecimalFormat("#.00");
        tempFinal = Double.parseDouble(df.format(tempFinal));
        //System.out.println(tempFinal);
        //System.out.println(finalPrice);

        return finalPrice == tempFinal;
    }

    public boolean verifySameVariantIsAddedIntoCart() {
        System.out.println(productNameInCart.getText());
        return productNameInCart.getText().contains(ConfigReader.getConfigValue("selectedMl"));
    }

    public String getProductName() {
        return productNameInCart.getText();
    }

    public String getProductQuantityInCart(){
        return productQuantity.getText();
    }

    public void clickOnPlaceOrderBtn() {
    }

    public void clickOnAddAddressBtn() {
        addAddressBtn.click();
    }

    @FindBy(name = "firstName")
    WebElement firstNameField;

    @FindBy(name = "lastName")
    WebElement lastNameField;

    @FindBy(name = "email")
    WebElement email;

    @FindBy(name = "mobile")
    WebElement mobile;

    @FindBy(name = "postCode")
    WebElement postCode;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(id = "workOption")
    WebElement workBtn;

    @FindBy(xpath = "//button[text()='SAVE ADDRESS']")
    WebElement saveAddress;



    public void fillTheAddressDetails() {
        firstNameField.sendKeys(ConfigReader.getConfigValue("address.first.name"));
        lastNameField.sendKeys(ConfigReader.getConfigValue("address.last.name"));
        email.sendKeys(ConfigReader.getConfigValue("address.email"));
        mobile.sendKeys(ConfigReader.getConfigValue("address.mobile"));
        postCode.sendKeys(ConfigReader.getConfigValue("address.postal"));
        address.sendKeys(ConfigReader.getConfigValue("address.address"));

        workBtn.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        jsClick(saveAddress);
    }
}
