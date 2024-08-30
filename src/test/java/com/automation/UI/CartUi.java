package com.automation.UI;

public interface CartUi {
    public double filterAmount(String amount);
    public boolean verifyCartPage();
    public void clickOnFirstCouponBtn();
    public boolean verifyCouponApplied();
    public boolean verifyCartAmountWithCouponAmount();
    public boolean verifySameVariantIsAddedIntoCart();
    public String getProductName();
    public String getProductQuantityInCart();
    public void clickOnPlaceOrderBtn();
    public void clickOnAddAddressBtn();
    public void fillTheAddressDetails();
    public void removeProduct();
}
