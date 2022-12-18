package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AdvancedSearchComponent extends BasePO {
    @FindBy(xpath = "//div[contains(@class,'ant-card-body')]")
    protected List<WebElement> cardsBody;
    private List<ClubCard> cards;
    @FindBy(xpath = "//label[.//span[contains(text(),'Центр')]]//span//input[@type='radio']")
    private WebElement radioCenter;
    @FindBy(xpath = "//label[.//span[contains(text(),'Гурток')]]//span//input[@type='radio']")
    private WebElement radioClub;
    @FindBy(xpath = "//label[.//span[@class='ant-radio ant-radio-checked']]//span[not(@class)]")
    private WebElement radioValue;
    @FindBy(xpath = "//input[@id='basic_cityName']//ancestor::div[contains(@class,'selector')]")
    private WebElement dropDownCity;
    @FindBy(xpath = "//*[@id=\"basic_cityName\"]")
    private WebElement cityInputField;
    @FindBy(xpath = "//div[@id='basic_cityName_list']/ancestor::div[not(@class)][1]")
    private WebElement dropDownCityList;
    @FindBy(xpath = "//input[@id='basic_districtName']//ancestor::div[contains(@class,'selector')]")
    private WebElement dropDownDistrict;
    @FindBy(xpath = "//input[@id='basic_stationName']//ancestor::div[contains(@class,'selector')]")
    private WebElement dropDownStation;
    @FindBy(xpath = "//input[@class='ant-input-number-input']")
    private WebElement inputAgeChildField;
    @FindBy(xpath = "//span[@id='basic_age']")
    private WebElement valueAgeChildField;
    @FindBy(xpath = "//div[@id='basic_isOnline']//span[.//input]")
    private WebElement checkBoxRemote;
    @FindBy(xpath = "//span[text()='за алфавітом']")
    private WebElement sortAlphabetical;
    @FindBy(xpath = "//span[@aria-label='arrow-down']")
    private WebElement sortDescending;
    @FindBy(xpath = "//span[@aria-label='arrow-up']")
    private WebElement sortAscending;
    @FindBy(xpath = "//span[text()='за рейтингом']")
    private WebElement sortByRating;


    public AdvancedSearchComponent(WebDriver driver) {
        super(driver);
    }

    public AdvancedSearchComponent chooseCity(String city) {

        wait.visibility(dropDownCity);
        dropDownCity.click();

        wait.visibility(dropDownCityList);

//        for(){
//            dropDownCityList.findElement(By.xpath(String.format("//div[contains(text(), '%s')]", city))).click();
//            break;
//        }
        return this;
    }

    public boolean isCityActive() {
        try {
            wait.visibility(dropDownCity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDistrictActive() {
        try {
            wait.visibility(dropDownDistrict);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isStationActive() {
        try {
            wait.visibility(dropDownStation);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAgeChildActive() {
        try {
            wait.visibility(inputAgeChildField);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isRemoteActive() {
        try {
            wait.visibility(checkBoxRemote);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isCategoryActive() {
        try {
            wait.visibility(By.xpath("//span[contains(text(), '')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public AdvancedSearchComponent clickRadioCenter() {
        radioCenter.click();
        return this;
    }

    public AdvancedSearchComponent clickRadioClub() {
        radioClub.click();
        return this;
    }

    public AdvancedSearchComponent clickRemote() {
        checkBoxRemote.click();
        return this;
    }

    public boolean isAdvancedSearchOpen() {
        try {
            wait.visibility(By.xpath("//div[contains(text(), 'Розширений пошук')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getRadioValueString() {
        return radioValue.getText();
    }

    public String getAgeChildField() {
        return valueAgeChildField.getAttribute("value");
    }

    public AdvancedSearchComponent enterNumberAge(String ageNumber) {
        wait.visibility(inputAgeChildField);
        inputAgeChildField.sendKeys(ageNumber);
        sleep(2);
        return this;
    }

    public AdvancedSearchComponent clickSortAlphabetical() {
        wait.visibility(sortAlphabetical);
        action.click(sortAlphabetical);
        return this;
    }

    public AdvancedSearchComponent clickSortDescending() {
        wait.visibility(sortDescending);
        action.click(sortDescending);
        return this;
    }

    public AdvancedSearchComponent clickSortAscending() {
        wait.visibility(sortAscending);
        action.click(sortAscending);
        return this;
    }

    public AdvancedSearchComponent clickSortByRating() {
        wait.visibility(sortByRating);
        action.click(sortByRating);
        return this;
    }

    public ClubsPage clickSortByRatingReturnClubs() {
        sortByRating.click();
        return new ClubsPage(driver);
    }


    public AdvancedSearchComponent clearCityField() {
        cityInputField.isEnabled();
        return this;
    }
    public ClubsPage getClubPage(){
        return new ClubsPage(driver);
    }


}
