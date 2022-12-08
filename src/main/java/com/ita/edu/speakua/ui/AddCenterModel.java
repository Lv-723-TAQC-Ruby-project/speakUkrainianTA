package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AddCenterModel extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameCenterInput;


    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default add-location-btn']")
    private WebElement addCenterLocation;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default next-btn']")
    private WebElement nextStepButton;

    //  Window "Додати локацію"
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


    public AddCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddCenterModel EnterCenterName(String nameCenter) {
        nameCenterInput.sendKeys(nameCenter);
        return this;
    }


    public AddCenterModel AddLocation() {
        addCenterLocation.click();
        return this;
    }

    public AddCenterModel AddLocationName(String locationName) {
        nameLocation.sendKeys(locationName);
        return this;
    }

    public AddCenterModel AddLocationAddress(String locationAddress) {
        addressLocation.sendKeys(locationAddress);
        return this;
    }

    public AddCenterModel AddLocationCoordinates(String locationCoordinates) {
        coordinatesLocation.sendKeys(locationCoordinates);
        return this;
    }

    public AddCenterModel AddLocationPhone(String locationPhone) {
        phoneLocation.sendKeys(locationPhone);
        return this;
    }

    public AddCenterModel ChooseLocationCity(String cityName) {
        Select select = new Select(chooseCityName);
        select.selectByValue(cityName);
        return this;
    }

    public AddCenterModel clickNextStep() {
        nextStepButton.click();
        return new AddCenterModel(driver);
    }


}
