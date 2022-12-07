package com.ita.edu.speakua.ui.runners;

import com.ita.edu.speakua.utils.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTestRunner {
    protected WebDriver driver;
    protected ConfigProperties configProperties;

    @BeforeSuite
    public void initDriver() {
        configProperties = new ConfigProperties();
        WebDriverManager.chromedriver().setup();
    }

    public void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(configProperties.getBaseWebUrl());
    }

    @AfterSuite
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
