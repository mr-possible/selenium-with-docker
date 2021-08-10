package com.newtours.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@id='cid_37']/table//tr[1]/td[1]/h1)[2]")
    private WebElement registrationConfirmPageHeading;

    @FindBy(id = "flight-link")
    private WebElement flightsLink;

    public String checkLandingOnRegistrationConfirmPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.registrationConfirmPageHeading));
        return this.registrationConfirmPageHeading.getText().trim();
    }

    public void goToFlightsPrefPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightsLink));
        this.flightsLink.click();
    }
}
