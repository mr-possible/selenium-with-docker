package com.parent;

import org.openqa.selenium.WebDriver;
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
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null
                && System.getProperty("BROWSER").equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

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
