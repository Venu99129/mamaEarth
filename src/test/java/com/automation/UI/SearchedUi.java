package com.automation.UI;

public interface SearchedUi {
    public String getSearchedResultText();
    public boolean verifyAllProductsInUnDerCategory();
    public String verifySearchedPage();
    public boolean verifyAllProductsMatchesSearchedText(String searchedText);

}
