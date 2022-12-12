package com.ita.edu.speakua.ui;

import org.openqa.selenium.By;
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
    public boolean isAdvancedSearchOpen() {
        try {
            wait.visibility(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
            sleep(3);
            driver.findElement(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
