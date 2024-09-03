package com.automation.UI;

public interface CartUi {
    public boolean verifyCartUi();
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
