package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddLocationModel extends BasePO {

    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameLocation;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressLocation;

    @FindBy(xpath = "//input[@id='coordinates']")
    private WebElement coordinatesLocation;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneLocation;

    @FindBy(xpath = "//input[@id='cityName']")
    private WebElement chooseCityName;

    public AddLocationModel(WebDriver driver) {
        super(driver);
    }

    public AddLocationModel AddLocationName(String locationName) {
        nameLocation.sendKeys(locationName);
        return this;
    }

    public AddLocationModel AddLocationAddress(String locationAddress) {
        addressLocation.sendKeys(locationAddress);
        return this;
    }

    public AddLocationModel AddLocationCoordinates(String locationCoordinates) {
        coordinatesLocation.sendKeys(locationCoordinates);
        return this;
    }

    public AddLocationModel AddLocationPhone(String locationPhone) {
        phoneLocation.sendKeys(locationPhone);
        return this;
    }

    public AddLocationModel ChooseLocationCity(String cityName) {
        Select select = new Select(chooseCityName);
        select.selectByValue(cityName);
        return this;
    }

}
