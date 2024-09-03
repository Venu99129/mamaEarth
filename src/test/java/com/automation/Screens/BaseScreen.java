package com.automation.Screens;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Collections;

public class BaseScreen {

    WebDriver driver;
    JavascriptExecutor js;

  
    public boolean displayedElement(WebElement element){
        DriverManager.setImplicitlyWait(5);
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
        if(ConfigReader.getConfigValue("running.platform").equals("mobile"))
            ((AppiumDriver) driver ).executeScript("arguments[0].click();",element);

        else js.executeScript("arguments[0].click();",element);
    }

    public BaseScreen(){
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
            WebElement notificationAllowBtn = driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button"));

            if (displayedElement(notificationAllowBtn)) {
                notificationAllowBtn.click();
            }
            WebElement skipAdd = driver.findElement(By.xpath("//android.widget.TextView[@text='SKIP']"));
            if(displayedElement(skipAdd)){
                skipAdd.click();
            }
        } catch (Exception ignored) {}

    }

    public void close_burgerMenu(){
        int x = driver.manage().window().getSize().getWidth();
        int y = driver.manage().window().getSize().getHeight();

        scrollOrSwipe(x/2,y/2 , 0,y/2);
    }

    public void clickAnyway(WebElement element){
        try {
            if(element.isDisplayed()) element.click();
        }catch (ElementNotInteractableException e2){jsClick(element);}

    }

    public void scrollOrSwipe(int startX, int startY, int endX, int endY) {
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
                .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(finger1, Duration.ofSeconds(2)))
                .addAction(finger1.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) driver).perform(Collections.singletonList(sequence));
    }

    public void scrollWindow(){
        int x = driver.manage().window().getSize().getWidth()/2;
        int y = driver.manage().window().getSize().getHeight()/2;

        scrollOrSwipe(x,y,x,y-500);
    }

    public double filterAmount(String amount){
        if(amount.contains(",")) amount = amount.replace(",","");
        if(amount.contains("-")) amount = amount.replace("-","");
        if(amount.contains("₹")) amount = amount.replace("₹","");
        return Double.parseDouble(amount);
    }
}
