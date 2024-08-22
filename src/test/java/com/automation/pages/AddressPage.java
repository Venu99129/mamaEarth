package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressPage extends BasePage {

    @FindBy(xpath = "//div[@class='step-container']/div[contains(text(),'Address')]")
    WebElement addressText;

    //.delivery-address-heading

    @FindBy(xpath = "//div[ @class = 'name-and-address-type']/span[1]")
    WebElement fullName;

    @FindBy(xpath = "//div[ @class = 'name-and-address-type']/div")
    WebElement deliveryType;

    @FindBy(css = ".address")
    WebElement addressInWeb;

    @FindBy(css = ".phone-number")
    WebElement phoneNumber;

    @FindBy(xpath = "//div[text()='Proceed to pay']")
    WebElement proceedToPayBtn;

    public boolean verifyAddressPage(){
        return addressText.isDisplayed();
    }

    public void clickOnProceedToPayBtn(){
        proceedToPayBtn.click();
    }

    public void verifyAddressDetails(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOf(fullName));

        Assert.assertEquals(ConfigReader.getConfigValue("address.first.name")+" "+ConfigReader.getConfigValue("address.last.name"),fullName.getText());
        Assert.assertEquals("Work",deliveryType.getText());
        String address = ConfigReader.getConfigValue("address.address")+", "+ConfigReader.getConfigValue("address.city")+", "+ConfigReader.getConfigValue("address.state")+" - "+ConfigReader.getConfigValue("address.postal");
        Assert.assertEquals(address,addressInWeb.getText());

    }
}
