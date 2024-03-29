package com.parent;

import com.newtours.listeners.TestListener;
import com.newtours.utils.Config;
import com.newtours.utils.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;
import java.net.URL;

@Listeners({TestListener.class})
public class BaseTest {
    public static final Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeSuite
    public void testParamsSetup() {
        Config.init();
    }

    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        this.driver = Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED)) ? getRemoteDriver() : getLocalDriver();
        ctx.setAttribute("driver", this.driver);
    }

    private WebDriver getRemoteDriver() throws MalformedURLException {
        Capabilities capabilities = new ChromeOptions();
        if (Constants.BROWSER.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
            capabilities = new FirefoxOptions();
        }

        String urlFormat = Config.get(Constants.GRID_URL_FORMAT);
        String hub_host = Config.get(Constants.GRID_HUB_HOST);
        String gridUrl = String.format(urlFormat, hub_host);

        log.info("Grid URL => {}", gridUrl);

        return new RemoteWebDriver(new URL(gridUrl), capabilities);
    }

    private WebDriver getLocalDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
