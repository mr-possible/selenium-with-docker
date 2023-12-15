package com.newtours.pages.flightbooking;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightBookPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FlightBookPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "reserveFlights")
    private WebElement reserveFlightsButton;

    public void clickReserveFlightsButton() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.reserveFlightsButton));
        this.reserveFlightsButton.click();
    }
}
