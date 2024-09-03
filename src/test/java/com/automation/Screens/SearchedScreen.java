package com.automation.Screens;

import com.automation.UI.SearchedUi;
import com.automation.utils.ConfigReader;
import com.automation.utils.DataStore;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchedScreen extends BaseScreen implements SearchedUi {
    @FindBy(xpath = "//android.widget.HorizontalScrollView/../following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    WebElement searchResultText;

    @FindBy(xpath = "//android.view.ViewGroup/following-sibling::android.widget.TextView[2]/preceding-sibling::android.widget.TextView")
    List<WebElement> resultProducts;

    @Override
    public String getSearchedResultText() {
        return searchResultText.getText();
    }

    @Override
    public boolean verifyAllProductsInUnDerCategory() {
        List<String> categoryProducts = new ArrayList<>();
        String itemCat = ConfigReader.getConfigValue("itemCat");
        switch (itemCat) {
            case "Face" -> categoryProducts.addAll(DataStore.faceCategories);
            case "Hair" -> categoryProducts.addAll(DataStore.hairCareProducts);
            case "Makeup", "Make Up" -> categoryProducts.addAll(DataStore.makeupProducts);
            case "Body" -> categoryProducts.addAll(DataStore.bodyCareProducts);
            case "Baby" -> categoryProducts.addAll(DataStore.babyCareProducts);
        }
        List<String> productNames = resultProducts.stream().map(WebElement::getText).toList();
        boolean outerFlag = true;
        for(String prodName:productNames){
            boolean inFlag = true;
            System.out.println(prodName);
            System.out.println(categoryProducts.size());
            for(int i =0;i<categoryProducts.size();i++){
                System.out.println(categoryProducts.get(i));
                System.out.println(prodName.contains(categoryProducts.get(i)));
                if(prodName.contains(categoryProducts.get(i))){
                    break;
                }
                if (i == categoryProducts.size() - 1) {
                    System.out.println("in last if");
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

    @Override
    public String verifySearchedUi() {
        return searchResultText.getText().replace("\"","");
    }

    @Override
    public boolean verifyAllProductsMatchesSearchedText(String searchedText) {
        return false;
    }
}
