package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DataStore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchedPage extends BasePage {

    @FindBy(xpath = "//div[@class='sc-fAjcbJ ixddFw banner-slider-wrapper']/following-sibling::div/h1")
    WebElement searchedText;
    
    @FindBy(xpath = "//div[@class='product-detail-wrap']/div[@class='title']")
    List<WebElement> productNames;

    @FindBy(css=".wzrk-alert wiz-show-animate")
    WebElement offersAlert;

    @FindBy(id = "wzrk-cancel-id")
    WebElement offersAlertCancelBtn;

    public String getSearchedResultText(){
        handleOfferAlert(offersAlert,offersAlertCancelBtn);
        return searchedText.getText();
    }


    public boolean verifyAllProductsInUnDerCategory() {
        List<String> categoryProducts = new ArrayList<>();
        String itemCat = ConfigReader.getConfigValue("itemCat");
        if(itemCat.equals("Face")) categoryProducts.addAll(DataStore.faceCategories);
        else if (itemCat.equals("Hair")) categoryProducts.addAll(DataStore.hairCareProducts);
        else if (itemCat.equals("Makeup")) categoryProducts.addAll(DataStore.makeupProducts);
        else if (itemCat.equals("Body")) categoryProducts.addAll(DataStore.bodyCareProducts);
        else if (itemCat.equals("Baby")) categoryProducts.addAll(DataStore.babyCareProducts);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<String> prodNames = productNames.stream().map(WebElement::getText).filter(s->!s.isEmpty()).toList();
        boolean outerFlag = true;
        for(String prodName:prodNames){
            boolean inFlag = true;
            for(int i =0;i<categoryProducts.size();i++){
                if(prodName.contains(categoryProducts.get(i))){
                    break;
                }
                if (i == productNames.size() - 1) {
                    System.out.println(categoryProducts.get(i));
                    inFlag = false;
                    break;
                }
            }
            outerFlag = inFlag;
            if(inFlag)
                break;
        }
        return outerFlag;
    }
}
