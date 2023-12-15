package com.newtours.pages.flightpreferences;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Oneway {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select s;

    public Oneway(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "passCount")
    private WebElement numberOfPassengersDropdown;

    @FindBy(name = "fromPort")
    private WebElement departingCityDropdown;

    @FindBy(name = "fromMonth")
    private WebElement departingDateDropdown_Month;

    @FindBy(name = "fromDay")
    private WebElement departingDateDropdown_Date;

    @FindBy(name = "toPort")
    private WebElement arrivalCityDropdown;

    @FindBy(name = "servClass")
    private WebElement travelClassRadioButton;

    @FindBy(name = "airline")
    private WebElement airlinePrefDropdown;

    @FindBy(id = "findFlights")
    private WebElement continueButton;

    public void enterFlightDetails(String numberOfPassengers) {
        this.wait.until(ExpectedConditions.visibilityOf(this.numberOfPassengersDropdown));
        s = new Select(this.numberOfPassengersDropdown);
        s.selectByValue(numberOfPassengers);
    }

    public void enterTravelPreferences(String travelClass, String airlinePreference) {
        this.wait.until(ExpectedConditions.visibilityOf(this.travelClassRadioButton));
        s = new Select(this.airlinePrefDropdown);
        s.selectByVisibleText(airlinePreference);
    }

    public void goToFindFlightsPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.continueButton));
        this.continueButton.click();
    }

}
