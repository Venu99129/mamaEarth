package com.automation.pages;

import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;

    public boolean displayedElement(WebElement element){
        DriverManager.setImplicitlyWait(0);
        try {
            if (element.isDisplayed()) return true;
        }catch (Exception e){
            return false;
        }finally {
            DriverManager.setImplicitlyWait(60);
        }
        return false;
    }



    public BasePage(){
        this.driver = DriverManager.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void mouseOverOn(WebElement element){
        Actions actions = new Actions(driver);

        actions.moveToElement(element).perform();
    }

    public void handleOfferAlert() {
        try {
            DriverManager.setImplicitlyWait(0);
            WebElement alert = driver.findElement(By.cssSelector(".wzrk-alert.wiz-show-animate"));
            WebElement cancelBtn = driver.findElement(By.id("wzrk-cancel-id"));

            if (displayedElement(alert)) {
                cancelBtn.click();
            }
        }catch (Exception e){
        }finally {
            DriverManager.setImplicitlyWait(60);
        }

    }

}
