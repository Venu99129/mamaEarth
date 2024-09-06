package com.automation.pages.ui;

public interface ProductUi {
    public boolean verifyUserIsOnProductDescriptionUi();
    public void userSelectsTheVariant();
    public boolean userClicksAddToCart() throws InterruptedException;
    public void selectGivenQuantity(String qty);
    public void mouseOverOnUserIcon();
    public void clickOnLogOut();

    void clickOnCartIcon();
}
