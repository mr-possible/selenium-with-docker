package com.newtours.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
    }

    @FindBy(name = "firstName")
    private WebElement firstNameTextbox;

    @FindBy(name = "lastName")
    private WebElement lastNameTextbox;

    @FindBy(name = "phone")
    private WebElement phoneTextbox;

    @FindBy(id = "userName")
    private WebElement emailTextbox;

    @FindBy(id = "email")
    private WebElement usernameTextbox;

    @FindBy(name = "password")
    private WebElement passwordTextbox;

    @FindBy(name = "confirmPassword")
    private WebElement confirmpasswordTextbox;

    @FindBy(id = "register-btn")
    private WebElement registerButton;

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
    }

    public void enterFirstName(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.firstNameTextbox));
        this.firstNameTextbox.sendKeys(val);
    }

    public void enterLastName(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.lastNameTextbox));
        this.lastNameTextbox.sendKeys(val);
    }

    public void enterPhone(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.phoneTextbox));
        this.phoneTextbox.sendKeys(val);
    }

    public void enterEmail(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.emailTextbox));
        this.emailTextbox.sendKeys(val);
    }

    public void enterUsername(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.usernameTextbox));
        this.usernameTextbox.sendKeys(val);
    }

    public void enterPassword(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.passwordTextbox));
        this.passwordTextbox.sendKeys(val);
    }

    public void enterConfirmPassword(String val) {
        wait.until(ExpectedConditions.elementToBeClickable(this.confirmpasswordTextbox));
        this.confirmpasswordTextbox.sendKeys(val);
    }

    public void clickRegisterButton() {
        wait.until(ExpectedConditions.elementToBeClickable(this.registerButton));
        this.registerButton.click();
    }
}
