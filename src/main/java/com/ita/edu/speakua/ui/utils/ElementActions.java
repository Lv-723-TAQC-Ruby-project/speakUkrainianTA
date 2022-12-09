package com.ita.edu.speakua.ui.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementActions {
    private WebDriver driver;
    private Actions actions;

    public ElementActions(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    public void click(WebElement element){
        actions.moveToElement(element).click().perform();
    }
}
