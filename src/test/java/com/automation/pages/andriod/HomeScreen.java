package com.automation.pages.andriod;

import com.automation.pages.ui.HomeUi;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeScreen extends BaseScreen implements HomeUi {


    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Search for ')]")
    WebElement searchBarTittle;

    @FindBy(xpath = "//android.view.ViewGroup/com.horcrux.svg.SvgView/com.horcrux.svg.GroupView/com.horcrux.svg.GroupView/com.horcrux.svg.PathView")
    WebElement cartIcon;

    @FindBy(xpath = "//android.widget.ImageView/following-sibling::android.view.ViewGroup[1]")
    WebElement bergerMenu;

    @FindBy(xpath = "//android.widget.TextView[@text='View Cart']")
    WebElement cartPopUp;

    @FindBy(xpath = "//android.widget.ImageView/following-sibling::android.view.ViewGroup[4]")
    WebElement userIcon;

    @FindBy(xpath = "//android.view.ViewGroup/com.horcrux.svg.SvgView[3]/preceding-sibling::android.widget.TextView[1]")
    WebElement userIconText;

    @FindBy(xpath = "//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[1]")
    List<WebElement> products;


    public void openTheMamaEarthWebsite() {
        handleOfferAlert();
    }

    public boolean verifyISOnHomeUi() {
        return searchBarTittle.isDisplayed();
    }

    public void clickOnUserIcon() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        handleOfferAlert();
        userIcon.click();
    }

    public String verifyLoginWithUserIcon() {
        bergerMenu.click();
        if (userIconText.getText().trim().contains("Guest")) return "Login";
        return userIconText.getText();
    }

    public boolean verifyCartPop() {
        return cartPopUp.isDisplayed();
    }

    public void mouseoverOnUserIcon() {
    }


    public void clickOnMenuItem(String itemCat) {

        if(itemCat.equals("Makeup")) itemCat = "Make Up";

        while (true) {
            List<WebElement> menuItems = driver.findElements(By.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/following-sibling::android.widget.TextView"));
            int x = menuItems.get(menuItems.size() - 1).getLocation().x;
            int y = menuItems.get(menuItems.size() - 1).getLocation().y;
            if (menuItems.stream().map(WebElement::getText).toList().contains(itemCat)) {
                System.out.println("in if");
                driver.findElement(By.xpath("//android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/following-sibling::android.widget.TextView[contains(@text,'"+itemCat+"')]")).click();
                ConfigReader.setConfigValue("itemCat",itemCat);
                break;
            }
            else{
                System.out.println("in else");
                scrollOrSwipe(x, y, x - 900, y);
            }
        }
    }

    public void searchSearchBar(String productName) {
        searchBarTittle.click();
        driver.findElement(By.className("android.widget.EditText"))
                .sendKeys(productName);
        ((AppiumDriver)driver).executeScript("mobile: performEditorAction", ImmutableMap.of("action","search"));
    }

    @Override
    public void clickOnBestSellersFirstProduct() {
        DriverManager.setImplicitlyWait(0);
        System.out.println("while out");
        while (true) {
            try {
                System.out.println("try in");
                WebElement bestSellerFirstProduct = driver.findElement(By.xpath("(//android.widget.TextView[@text='Best Sellers']/../android.widget.HorizontalScrollView//android.widget.TextView[@text=' ADD'])[1]"));
                if (bestSellerFirstProduct.isDisplayed()) {
                    bestSellerFirstProduct.click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("catch");
                scrollWindow();
            }
        }
        DriverManager.setImplicitlyWait(10);


    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void mouseOverOnMenuItem(String category) {
        handleOfferAlert();
        String itemXpath = "//li[@class='category']/a[text()='%s']";
        WebElement menuItem = driver.findElement(By.xpath(String.format(itemXpath, category)));
        mouseOverOn(menuItem);
    }

    public void clickOnSubMenuItem(String subCategory) {
        String subMenuXpath = "//a[text()='%s']";
        clickAnyway(driver.findElement(By.xpath(String.format(subMenuXpath, subCategory))));
    }

    public void userClicksOnAProduct() {
        for (WebElement ele : products) {
            if (displayedElement(ele)) {
                ele.click();
                break;
            }
        }
    }
}
