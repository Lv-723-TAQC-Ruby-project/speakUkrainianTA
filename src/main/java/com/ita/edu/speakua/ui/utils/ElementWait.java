package com.ita.edu.speakua.ui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementWait {
    private final Duration TIMEOUT = Duration.ofSeconds(10);
    private final WebDriver driver;
    private final WebDriverWait wait;

    public ElementWait(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    public void visibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


    public void visibility(WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void visibility(WebElement element) {
        visibility(element, TIMEOUT.getSeconds());
    }

    public void clickable(By locator) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
    }


    public void clickable(WebElement element, long seconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.elementToBeClickable(element));
            System.out.println("Element is clickable");
        }
        catch(TimeoutException e) {
            System.out.println("Element isn't clickable");
        }
    }

    public void clickable(WebElement element) {
        clickable(element, TIMEOUT.getSeconds());
    }

}
