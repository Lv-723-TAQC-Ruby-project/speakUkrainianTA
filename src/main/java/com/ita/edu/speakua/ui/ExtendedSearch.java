package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearch extends BasePO{

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    public ExtendedSearch(WebDriver driver) {
        super(driver);
    }

    public ExtendedSearch clickCenter() {
        centerButton.click();
        return this;
    }

}
