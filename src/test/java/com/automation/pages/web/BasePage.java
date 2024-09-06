package com.automation.pages.web;

import com.automation.utils.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    WebDriver driver;
    JavascriptExecutor js;

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

    public void jsClick(WebElement element){

        js.executeScript("arguments[0].click();",element);
    }


    public BasePage(){
        this.driver = DriverManager.getDriver();
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver,this);
    }

    public void mouseOverOn(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    public void scrollWindowOrSlide(int x , int y){
        String script = "window.scrollTo(%s,%s)";
        js.executeScript(String.format(script,x,y));
        try {
            Thread.sleep(2000);
        }catch (Exception ignored){}
    }

    public boolean presentWithNonDisplay(WebElement element){
        try{
            element.isDisplayed();
            return true;
        }catch (Exception e){
            return false;
        }
    }

  
    public void handleOfferAlert() {
        try {
            DriverManager.setImplicitlyWait(5);
            WebElement alert = driver.findElement(By.cssSelector(".wzrk-alert.wiz-show-animate"));
            WebElement cancelBtn = driver.findElement(By.id("wzrk-cancel-id"));

            if (displayedElement(alert)) {
                cancelBtn.click();
            }
        } catch (Exception ignored) {
        } finally {
            DriverManager.setImplicitlyWait(60);
        }

    }

    public double filterAmount(String amount){
        if(amount.contains(",")) amount = amount.replace(",","");
        if(amount.contains("-")) amount = amount.replace("-","");
        if(amount.contains("₹")) amount = amount.replace("₹","");
        return Double.parseDouble(amount);
    }
  
    public void clickAnyway(@org.jetbrains.annotations.NotNull WebElement element){
        try {
            if(element.isDisplayed()) element.click();
        }catch (ElementNotInteractableException e2){jsClick(element);}

    }

}
