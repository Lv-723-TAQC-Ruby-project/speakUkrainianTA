package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchModel extends BasePO{

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    public AdvancedSearchModel(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchModel clickCenter() {
        centerButton.click();
        return this;
    }

}
