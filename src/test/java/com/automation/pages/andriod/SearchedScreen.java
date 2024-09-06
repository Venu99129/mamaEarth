package com.automation.pages.andriod;

import com.automation.pages.ui.SearchedUi;
import com.automation.utils.ConfigReader;
import com.automation.utils.DataStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchedScreen extends BaseScreen implements SearchedUi {
    @FindBy(xpath = "//android.widget.HorizontalScrollView/../following-sibling::android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    WebElement searchResultText;

    @FindBy(xpath = "//android.view.ViewGroup/following-sibling::android.widget.TextView[2]/preceding-sibling::android.widget.TextView")
    List<WebElement> productNames;
    
    @FindBy(xpath = "//android.widget.TextView[@text='SORT']/../../following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
    List<WebElement> subMenuItems;

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
        List<String> prodNames = productNames.stream().map(WebElement::getText).toList();
        boolean outerFlag = true;
        for(String prodName:prodNames){
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
        return searchResultText.getText().replace("'","");
    }

    @Override
    public boolean verifyAllProductsMatchesSearchedText(String searchedText) {
        List<String> prodNames = productNames.stream().map(WebElement::getText).filter(s->!s.isEmpty()).toList();
        for (String prodName : prodNames) {
            if (!prodName.toLowerCase().contains(searchedText.toLowerCase())) {
                if(searchedText.equals("Illumination") && prodName.toLowerCase().contains("Illuminating".toLowerCase())) continue;

                if(!searchedText.contains(" ") ) {
                    System.out.println(prodName);
                    return false;
                } else if (prodName.toLowerCase().contains(searchedText.split(" ")[0].toLowerCase())) {
                    return true;
                }else if(prodName.toLowerCase().contains("combo") || prodName.toLowerCase().contains("kit")) return true;
                else if (!(prodName.toLowerCase().contains(searchedText.split(" ")[1].toLowerCase()))) {
                    System.out.println(prodName);
                    return false;
                }
            }
        }
        return true;
    }

    public void clickOnSubMenu(String subCategory) {
        while(true){
            List<String> subMenu = subMenuItems.stream().map(WebElement::getText).toList();
            System.out.println(subMenu);
            if(subMenu.contains(subCategory)){
                driver.findElement(By.xpath("//android.widget.TextView[@text='SORT']/../../following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[@text='"+subCategory+"']")).click();
                break;
            }
            else {
                int x= subMenuItems.get(subMenuItems.size()-1).getLocation().x;
                int y= subMenuItems.get(subMenuItems.size()-1).getLocation().y;
                scrollOrSwipe(x,y,(x-700),y);
                subMenuItems = driver.findElements(By.xpath("//android.widget.TextView[@text='SORT']/../../following-sibling::android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup"));
            }
        }
        
    }
}
