package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


public class AddLocationModal extends BasePO {

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

    @FindBy(xpath = "//input[@id='districtName']")
    private WebElement chooseDistrictName;

    @FindBy(xpath = "//input[@id='stationName']")
    private WebElement chooseStationName;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default flooded-button add-club-content-next']")
    private WebElement addLocationButton;

    @FindBy(xpath = "//div[@class='ant-select-item-option-content']")
    private WebElement city;

    public AddLocationModal(WebDriver driver) {
        super(driver);
    }

    public AddLocationModal addLocationName(String locationName) {
        nameLocation.sendKeys(locationName);
        return this;
    }

    public AddLocationModal addLocationAddress(String locationAddress) {
        addressLocation.sendKeys(locationAddress);
        return this;
    }

    public AddLocationModal addLocationCoordinates(String locationCoordinates) {
        coordinatesLocation.sendKeys(locationCoordinates);
        return this;
    }

    public AddLocationModal addLocationPhone(String locationPhone) {
        phoneLocation.sendKeys(locationPhone);
        return this;
    }


    private AddLocationModal selectLocation(WebElement webElement, String locationName) {
        webElement.click();
        List<String> locations = new ArrayList<>();
        while (true) {
            if (driver.findElements(By.xpath("//div[contains(@class, 'ant-select-item-option-active') and contains(@aria-selected, 'false')]")).isEmpty()) {
                System.out.println("There is no list to check for " + locationName);
                break;
            }
            WebElement locationWebElement = driver.findElement(By.xpath("//div[contains(@class, 'ant-select-item-option-active') and contains(@aria-selected, 'false')]"));
            String location = locationWebElement.getAttribute("title");
            if (locations.size() > 2 && locations.get(0).equals(location)) {
                System.out.println("There is no such location as " + locationName);
                break;
            }
            locations.add(location);
            if (locationName.equals(location)) {
                locationWebElement.click();
                break;
            }
            webElement.sendKeys(Keys.ARROW_DOWN);
        }
        return this;
    }

    public AddLocationModal chooseLocationCity(String cityName) {
        selectLocation(chooseCityName, cityName);
        return this;
    }

    public AddLocationModal chooseLocationStation(String stationName) {
        selectLocation(chooseStationName, stationName);
        return this;
    }

    public AddLocationModal chooseLocationDistrict(String districtName) {
        selectLocation(chooseDistrictName, districtName);
        return this;
    }


    public AddCenterModal clickAddLocationButton() {
        addLocationButton.click();
        return new AddCenterModal(driver);
    }

}
