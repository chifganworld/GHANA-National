package org.motechproject.functional.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class FireFoxWebDriver extends BaseWebDriver {

    @Value("#{functionalTestProperties['firefox.display']}")
    private String firefoxDisplay;

    public WebDriver getDriver() {
        if (driver == null) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setEnableNativeEvents(true);
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.setEnvironmentProperty("DISPLAY", System.getProperty("functional.test.display", ":0.0"));
            driver = new FirefoxDriver(firefoxBinary, profile);
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }
}