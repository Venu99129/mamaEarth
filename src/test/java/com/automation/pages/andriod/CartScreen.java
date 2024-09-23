package com.automation.pages.andriod;

import com.automation.pages.ui.CartUi;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.DecimalFormat;
import java.util.List;

public class CartScreen extends BaseScreen implements CartUi {
    @FindBy(xpath = "//android.widget.TextView[@text='Your cart']")
    WebElement cartText;

    @FindBy(xpath = "//android.widget.TextView[@text='To Pay']/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement toPayAmount;

    @FindBy(xpath = "//android.widget.TextView[@text='Woohoo! Thanks']")
    WebElement cartPopUp;

    @FindBy(xpath = "//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.widget.TextView[1]")
    WebElement productName;
    @FindBy(xpath = "//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.widget.TextView[2]")
    WebElement productPrice;

    @FindBy(xpath = "//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.TextView")
    WebElement minusIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView")
    WebElement plusIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView")
    WebElement productQuantity;




    @Override
    public boolean verifyCartUi() {
        return cartText.isDisplayed();
    }

    @Override
    public void clickOnFirstCouponBtn() {
        DriverManager.setImplicitlyWait(5);
        for (int attempt = 0; attempt < 5; attempt++) {
            System.out.println("Attempt: " + (attempt + 1));

            List<WebElement> applyButtons = driver.findElements(By.xpath("//android.widget.TextView[@text='Apply']"));

            for (WebElement ele : applyButtons) {
                try {
                    if (ele.isDisplayed() && ele.isEnabled()) {
                        ele.click();
                        // Check for success message
                        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Woohoo! Thanks']")));
                        return; // Exit if successful
                    }
                } catch (Exception e) { System.out.println("Error clicking button: " + e.getMessage());}
            }
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

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Item Total')]/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement itemTotal;

    @FindBy(xpath = "//android.widget.TextView[@text='Shipping']/following-sibling::android.view.ViewGroup/android.widget.TextView")
    WebElement shippingAmount;
    
    @FindBy(xpath = "//android.widget.TextView[@text='Add address']")
    WebElement addAddressBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Proceed to pay']")
    WebElement proceedToPayBtn;

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
        System.out.println(ConfigReader.getConfigValue("product.price")+"   "+productPrice.getText().trim());
        return ConfigReader.getConfigValue("product.price").contains(productPrice.getText().trim());
    }

    @Override
    public String getProductName() {
        return productName.getText().trim();
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
        addAddressBtn.click();

    }

    @Override
    public void fillTheAddressDetails() {
    }

    @Override
    public void removeProduct() {

    }

    @Override
    public void selectQuantityByGivenQuantity(String qty) throws InterruptedException {
        int expectedQuantity =  Integer.parseInt(qty);
        if(expectedQuantity>0) {
            int quantity = Integer.parseInt(productQuantity.getText().trim());
            if(expectedQuantity != quantity) {
                do {
                    System.out.println(quantity);
                    if (expectedQuantity > quantity) {
                        plusIcon.click();
                        Thread.sleep(3000);
                        productQuantity = driver.findElement(By.xpath("//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"));
                        quantity = Integer.parseInt(productQuantity.getText().trim());
                    }
                    if (expectedQuantity < quantity) {
                        minusIcon.click();
                        Thread.sleep(3000);
                        productQuantity = driver.findElement(By.xpath("//android.widget.TextView[@text='Cart details']/../../android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView/../../following-sibling::android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"));
                        quantity = Integer.parseInt(productQuantity.getText().trim());
                    }
                } while (expectedQuantity != quantity);
            }else System.out.println("defaults your given quantity is available for the product");
        }
    }

    @Override
    public boolean comparePriceByQuantity() {
        double productAmount = filterAmount(productPrice.getText());
        int quantity = Integer.parseInt(productQuantity.getText().trim());
        DriverManager.setImplicitlyWait(2);
        while (true) {
            try {
                toPayAmount = driver.findElement(By.xpath("//android.widget.TextView[@text='To Pay']/following-sibling::android.view.ViewGroup/android.widget.TextView"));
                if (toPayAmount.isDisplayed()) break;
            } catch (Exception e) {
                scrollWindow();}
        }
        DriverManager.setImplicitlyWait(60);

        double itemPrice = filterAmount(itemTotal.getText().trim());
        System.out.println("productAmount  "+productAmount+"\nproductQuantity "+quantity+"\norderAmount "+itemPrice);
        double expectedAmount = productAmount*quantity;
        System.out.println(expectedAmount);

        return expectedAmount == itemPrice;
    }

    @Override
    public void clickOnProceedToPayBtn() {
        proceedToPayBtn.click();
    }

    @Override
    public void clickOnSelectAddressBtn() {
        //selectAddress.click();
    }

    @Override
    public void backToHomePage() {

    }
}
