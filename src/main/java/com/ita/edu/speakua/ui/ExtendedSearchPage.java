package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.ProfilePO.EditProfileModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExtendedSearchPage extends BasePO{

    @FindBy(xpath = "//span[text()='Центр']")
    private WebElement centerButton;

    @FindBy(xpath = "//input[@class='ant-input-number-input']")
    private WebElement ageChildField;

    @FindBy(xpath = "//span[@id='basic_age']")
    private WebElement valueAgeChildField;


    public ExtendedSearchPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedSearchPage clickCenter() {
        centerButton.click();
        return this;
    }

    public ExtendedSearchPage EnterNumberAge(String numberAge ){
        ageChildField.sendKeys(numberAge);
        sleep(2);
        return this;
    }


    public String getAgeChildField() {
        return valueAgeChildField.getAttribute("value");
    }



}
