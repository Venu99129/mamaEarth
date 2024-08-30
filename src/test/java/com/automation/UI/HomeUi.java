package com.automation.UI;

public interface HomeUi {

    public void openTheMamaEarthWebsite();
    public void clickOnUserIcon();
    public String verifyLoginWithUserIcon();
    public void mouseoverOnUserIcon();
    public void clickOnMenuItem(String itemCat);
    public void searchSearchBar(String productName);
    public void clickOnBestSellersFirstProduct();
    public boolean verifyCartPop();
    public void clickOnCartIcon();
    public void mouseOverOnMenuItem(String category);
    public void clickOnSubMenuItem(String subCategory);
    public void userClicksOnAProduct();

    public boolean verifyISOnHomeUi();
}
