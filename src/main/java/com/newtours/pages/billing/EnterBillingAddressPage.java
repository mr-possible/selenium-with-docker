package com.newtours.pages.billing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EnterBillingAddressPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public EnterBillingAddressPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input_53_city")
    private WebElement cityTextbox;

    @FindBy(id = "buyFlights")
    private WebElement continueButton;

    public void enterBillingaddress(String billingCity) {
        this.wait.until(ExpectedConditions.visibilityOf(this.cityTextbox));
        this.cityTextbox.sendKeys(billingCity);
    }

    public void clickContinueButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));
        this.continueButton.click();
    }
}
