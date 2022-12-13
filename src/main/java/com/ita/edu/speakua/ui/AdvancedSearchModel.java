package com.ita.edu.speakua.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AdvancedSearchModel extends BasePO{


    @FindBy(xpath = "//label[.//span[contains(text(),'Центр')]]//span//input[@type='radio']")
    private WebElement radioCenter;
    @FindBy(xpath = "//label[.//span[contains(text(),'Гурток')]]//span//input[@type='radio']")
    private WebElement radioClub;

    @FindBy(xpath = "//label[.//span[@class='ant-radio ant-radio-checked']]//span[not(@class)]")
    private WebElement radioValue;

    @FindBy(xpath = "//input[@id='basic_cityName']")
    private WebElement dropDownCity;
    @FindBy(xpath = "//div[@id='basic_cityName_list']")
    private WebElement dropDownCityList;

    @FindBy(xpath = "//input[@id='basic_districtName']")
    private WebElement dropDownDistrict;

    @FindBy(xpath = "//input[@id='basic_stationName']")
    private WebElement dropDownStation;

    @FindBy(xpath = "//input[@class='ant-input-number-input']")
    private WebElement inputAgeChildField;

    @FindBy(xpath = "//span[@id='basic_age']")
    private WebElement valueAgeChildField;

    public AdvancedSearchModel(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchModel chooseDropDownCity(String city) {

        wait.visibility(dropDownCity);
        dropDownCity.click();

        wait.visibility(dropDownCityList);
        dropDownCityList.findElement(By.xpath(String.format("//div[text() = '%s']", city))).click();

        return this;
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
