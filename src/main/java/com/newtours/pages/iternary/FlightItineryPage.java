package com.newtours.pages.iternary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightItineryPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public FlightItineryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//*[@id='cid_37']/table//tr[1]/td[1]/h1)[4]/font")
    private WebElement flightItineryHeading;

    public String checkFlighItineryPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.flightItineryHeading));
        return this.flightItineryHeading.getText().trim();
    }
}
