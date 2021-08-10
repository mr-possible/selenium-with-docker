package com.newtours.tests;

import com.newtours.pages.billing.EnterBillingAddressPage;
import com.newtours.pages.flightbooking.FlightBookPage;
import com.newtours.pages.flightpreferences.Oneway;
import com.newtours.pages.iternary.FlightItineryPage;
import com.newtours.pages.registration.RegistrationConfirmationPage;
import com.newtours.pages.registration.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookFlightTest {
    private WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    @Test(priority = 1)
    public void registrationPageTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enterFirstName("Sam");
        registrationPage.enterLastName("Morris");
        registrationPage.enterUsername("sam");
        registrationPage.enterPassword("1234");
        registrationPage.enterConfirmPassword("1234");
        registrationPage.clickRegisterButton();
    }

    @Test(priority = 2, dependsOnMethods = "registrationPageTest")
    public void registrationConfirmationTest() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        String confirmHeading = registrationConfirmationPage.checkLandingOnRegistrationConfirmPage();
        String expectedConfirmationHeading = "Registration Confirmation Page";
        Assert.assertEquals(confirmHeading, expectedConfirmationHeading);
        registrationConfirmationPage.goToFlightsPrefPage();
    }

    @Test(priority = 3, dependsOnMethods = "registrationConfirmationTest")
    public void flightPreferenceTest() {
        Oneway oneway = new Oneway(driver);
        oneway.enterFlightDetails("1");
        oneway.goToFindFlightsPage();
    }

    @Test(priority = 4, dependsOnMethods = "flightPreferenceTest")
    public void flightBookingTest() {
        FlightBookPage flightBookPage = new FlightBookPage(driver);
        flightBookPage.clickReserveFlightsButton();
    }

    @Test(priority = 5, dependsOnMethods = "flightBookingTest")
    public void setBillingAddress() {
        EnterBillingAddressPage enterBillingAddressPage = new EnterBillingAddressPage(driver);
        enterBillingAddressPage.enterBillingaddress("Bhilai");
        enterBillingAddressPage.clickContinueButton();
    }

    @Test(priority = 6, dependsOnMethods = "setBillingAddress")
    public void flightItineryTest() {
        FlightItineryPage flightItineryPage = new FlightItineryPage(driver);
        String actualFlightItineryHeader = flightItineryPage.checkFlighItineryPage();
        String expectedFlightItineryHeader = "Flight Itinerary Page";
        Assert.assertEquals(actualFlightItineryHeader, expectedFlightItineryHeader, "Flight itinery headers do not match !");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
