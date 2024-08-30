package com.automation.UI;

public interface ProductUi {
    public boolean verifyUserIsOnProductDescriptionPage();
    public void userSelectsTheVariant();
    public boolean userClicksAddToCart();
    public void selectGivenQuantity(String qty);
    public void mouseOverOnUserIcon();
    public void clickOnLogOut();
}
