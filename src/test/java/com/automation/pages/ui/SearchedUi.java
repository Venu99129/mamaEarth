package com.automation.pages.ui;

public interface SearchedUi {
    public String getSearchedResultText();
    public boolean verifyAllProductsInUnDerCategory();
    public String verifySearchedUi();
    public boolean verifyAllProductsMatchesSearchedText(String searchedText);

    void clickOnFirstProduct();
}
