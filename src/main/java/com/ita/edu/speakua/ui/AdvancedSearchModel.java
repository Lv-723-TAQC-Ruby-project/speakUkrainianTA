package com.ita.edu.speakua.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdvancedSearchModel extends BasePO{

    @FindBy(xpath = "//input[@class='ant-input-number-input']")
    private WebElement inputAgeChildField;

    @FindBy(xpath = "//span[@id='basic_age']")
    private WebElement valueAgeChildField;

    @FindBy(xpath = "//label[.//span[contains(text(),'Центр')]]//span//input[@type='radio']")
    private WebElement radioCenter;
    @FindBy(xpath = "//label[.//span[contains(text(),'Гурток')]]//span//input[@type='radio']")
    private WebElement radioClub;

    @FindBy(xpath = "//label[.//span[@class='ant-radio ant-radio-checked']]//span[not(@class)]")
    private WebElement radioValue;

    public AdvancedSearchModel(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchModel clickRadioCenter() {
        radioCenter.click();
        return this;
    }
    public AdvancedSearchModel clickRadioClub() {
        radioClub.click();
        return this;
    }

    public boolean isAdvancedSearchOpen() {
        try {
            wait.visibility(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
            sleep(2);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getRadioValueString() {
        return radioValue.getText();
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
