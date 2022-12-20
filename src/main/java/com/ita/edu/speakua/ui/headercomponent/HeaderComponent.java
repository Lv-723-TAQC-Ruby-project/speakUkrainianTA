package com.ita.edu.speakua.ui.headercomponent;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.profilemenu.AdminProfileMenu;
import com.ita.edu.speakua.ui.profilemenu.GuestProfileMenu;
import com.ita.edu.speakua.ui.profilemenu.UserProfileMenu;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderComponent extends BasePO {
    @FindBy(xpath = "//div[contains(@class, 'user-profile')]")
    private WebElement profileMenuButton;

    @FindBy(xpath = "//a[contains(text(), 'Гуртки')]")
    private WebElement clubButton;

    @FindBy(xpath = "//*[@data-icon='control']")
    private WebElement advancedSearchButton;

    @FindBy(xpath = "//*[@data-icon='search']")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='search']//input")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class, 'rc-virtual-list-holder-inner')]")
    private WebElement searchListHolder;

    @FindBy(xpath = "//*[@id='root']/section/header/div[3]/div[1]")
    private WebElement locationButton;

    @FindBy(xpath = "//ul[contains(@class, 'ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light')]")
    private WebElement locationDropDownMenu;


    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    @Step("Click location button in header")
    public HeaderComponent clickLocationButton() {
        locationButton.click();
        return this;
    }

    public List<WebElement> getCitiesListFromLocationDropDownMenu() {
        return locationDropDownMenu.findElements(By.tagName("li"));
    }

    @Step("Click city")
    public ClubsPage clickCityInTheLocationSection(int id) {
        getCitiesListFromLocationDropDownMenu().get(id).click();
        return new ClubsPage(driver);
    }

    @Step("Click on the search field")
    public HeaderComponent clickSearchField() {
        searchField.click();
        return this;
    }

    @Step("Enter text in search field")
    public HeaderComponent enterTextInTheSearchField(String input) {
        searchField.sendKeys(input);
        return this;
    }

    @Step("Enter text in search field")
    public HeaderComponent enterTextInTheSearchFieldAndWait(String input, int timeToWait) {
        searchField.sendKeys(input);
        sleep(timeToWait);
        return this;
    }

    @Step("Get value from search field")
    public String getSearchFieldInputValue() {
        String text = searchField.getAttribute("value");
        return text;
    }

    @Step("Get component of the search list result")
    public List<WebElement> getComponentsOfTheSearchList() {
        wait.visibility(searchListHolder);
        return searchListHolder.findElements(By.tagName("div"));
    }

    @Step("Click search button")
    public ClubsPage clickSearchButton() {
        searchButton.click();
        return new ClubsPage(driver);
    }

    public GuestProfileMenu openGuestProfileMenu() {
        profileMenuButton.click();
        sleep(3);
        return new GuestProfileMenu(driver);
    }

    @Step("open profile Menu")
    public AdminProfileMenu openAdminProfileMenu() {
        profileMenuButton.click();
        sleep(3);
        return new AdminProfileMenu(driver);
    }

    public ClubsPage clickClub() {
        clubButton.click();
        sleep(3);
        return new ClubsPage(this.driver);
    }

    @Step("Click Advanced search button")
    public ClubsPage openAdvancedSearch() {
        advancedSearchButton.click();
        return new ClubsPage(driver);
    }
    @Step("open profile menu")
    public UserProfileMenu openUserProfileMenu() {
        wait.visibility(profileMenuButton);
        action.click(profileMenuButton);
        return new UserProfileMenu(driver);
    }

}
