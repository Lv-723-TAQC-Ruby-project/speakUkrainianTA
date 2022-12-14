package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v106.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddLocationCenterModel extends BasePO {

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

    public AddLocationCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddLocationCenterModel AddLocationName(String locationName) {
        nameLocation.sendKeys(locationName);
        return this;
    }

    public AddLocationCenterModel AddLocationAddress(String locationAddress) {
        addressLocation.sendKeys(locationAddress);
        return this;
    }

    public AddLocationCenterModel AddLocationCoordinates(String locationCoordinates) {
        coordinatesLocation.sendKeys(locationCoordinates);
        return this;
    }

    public AddLocationCenterModel AddLocationPhone(String locationPhone) {
        phoneLocation.sendKeys(locationPhone);
        return this;
    }


    public AddLocationCenterModel ChooseLocationCity(String cityName) {
        chooseCityName.click();
        List<String> cities = new ArrayList<>();
        while (true) {
            WebElement cityWebElement = driver.findElement(By.xpath("//div[contains(@class, 'ant-select-item-option-active')]"));
            String city = cityWebElement.getAttribute("title");
            System.out.println(city);
            if (cities.size() > 2 && cities.get(0).equals(city)) {
                System.out.println("There is no such city as " + cityName);
                break;
            }
            cities.add(city);
            if (cityName.equals(city)) {
                cityWebElement.click();
                break;
            }
            chooseCityName.sendKeys(Keys.ARROW_DOWN);
        }

        return this;
    }

    public AddCenterModel clickAddLocationButton() {
        addLocationButton.click();
        return new AddCenterModel(driver);
    }

}
