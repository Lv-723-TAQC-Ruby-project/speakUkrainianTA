package com.ita.edu.speakua.ui.runners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTestRunner {
    protected WebDriver driver;

    @BeforeSuite
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public void setDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://speak-ukrainian.org.ua/dev/");
    }

    @AfterSuite
    public void quiteDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
