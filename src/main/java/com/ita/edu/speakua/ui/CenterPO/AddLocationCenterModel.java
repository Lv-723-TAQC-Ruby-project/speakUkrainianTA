package com.ita.edu.speakua.ui.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


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
        String xpathString = "//div[@class='ant-select-item-option-content'][contains(text(),'" + cityName + "')]";

//        WebElement city = driver.findElement(By.xpath(xpathString));
//        city.click();

        List<WebElement> myElements = driver.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));
        for(WebElement e : myElements) {
            if(e.getText().equals(cityName)) {
                e.click();
            }
        }

        return this;
    }

    public AddCenterModel clickAddLocationButton() {
        addLocationButton.click();
        return new AddCenterModel(driver);
    }

}
