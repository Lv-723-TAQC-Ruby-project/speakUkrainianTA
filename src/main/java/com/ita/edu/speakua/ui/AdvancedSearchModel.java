package com.ita.edu.speakua.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchModel extends BasePO{

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    @FindBy(xpath = "//input[@class='ant-input-number-input']")
    private WebElement inputAgeChildField;

    @FindBy(xpath = "//span[@id='basic_age']")
    private WebElement valueAgeChildField;

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

    public String getAgeChildField(){
        return valueAgeChildField.getAttribute("value");
    }

    public AdvancedSearchModel EnterNumberAge(String ageNumber) {
        inputAgeChildField.sendKeys(ageNumber);
        sleep(2);
        return this;
    }
}
