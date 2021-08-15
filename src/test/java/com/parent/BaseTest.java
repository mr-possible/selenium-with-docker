package com.parent;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {
        // default values
        String host = "localhost";
        DesiredCapabilities dc;

        if (System.getProperty("BROWSER") != null
                && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }else{
            dc = DesiredCapabilities.chrome();
        }

        /*if (System.getProperty("BROWSER") != null
                && System.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            // setup the chromedriver using WebDriverManager
            WebDriverManager.chromedriver().setup();

            //Create Chrome Options
            ChromeOptions option = new ChromeOptions();
            option.addArguments("--test-type");
            option.addArguments("--disable-popup-blocking");
            dc = DesiredCapabilities.chrome();
            dc.setJavascriptEnabled(true);
            option.setCapability(ChromeOptions.CAPABILITY, option);
        }*/

        if (System.getProperty("HUB_HOST") != null) {
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), dc);
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
