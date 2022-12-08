package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchPage extends BasePO{

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    public ExtendedSearchPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedSearchPage clickCenter() {
        centerButton.click();
        return this;
    }

}
