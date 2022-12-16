package com.ita.edu.speakua.ui.headercomponent;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.profilemenu.AdminProfileMenu;
import com.ita.edu.speakua.ui.profilemenu.GuestProfileMenu;
import com.ita.edu.speakua.ui.profilemenu.UserProfileMenu;
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

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/div[1]/div[2]/div[2]/span[1]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[@class='search']//input")
    private WebElement searchField;

    @FindBy(xpath = "//div[contains(@class, 'rc-virtual-list-holder-inner')]")
    private WebElement searchListHolder;

    @FindBy(xpath = "//*[@id=\"root\"]/section/header/div[3]/div[1]")
    private WebElement locationButton;

    @FindBy(xpath = "//ul[contains(@class, 'ant-dropdown-menu ant-dropdown-menu-root ant-dropdown-menu-vertical ant-dropdown-menu-light')]")
    private WebElement locationDropDownMenu;


    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent clickLocationButton() {
        locationButton.click();
        return this;
    }

    public HeaderComponent chooseCity(String city) {
        locationDropDownMenu.getAttribute(city);
        return this;
    }

    public HeaderComponent clickSearchField() {
        searchField.click();
        return this;
    }

    public HeaderComponent enterTextInTheSearchField(String input) {
        searchField.sendKeys(input);
        return this;
    }

    public String getSearchFieldInputValue() {
        String text = searchField.getAttribute("value");
        return text;
    }

    public List<WebElement> getComponentsOfTheSearchList() {
        wait.visibility(searchListHolder);
        return searchListHolder.findElements(By.tagName("div"));
    }

    public HeaderComponent clickSearchButton() {
        searchButton.click();
        return this;
    }

    public GuestProfileMenu openGuestProfileMenu() {
        profileMenuButton.click();
        return new GuestProfileMenu(driver);
    }

    public AdminProfileMenu openAdminProfileMenu() {
        profileMenuButton.click();
        return new AdminProfileMenu(driver);
    }

    public ClubsPage clickClub() {
        clubButton.click();
        sleep(3);
        return new ClubsPage(this.driver);
    }

    public ClubsPage openAdvancedSearch() {
        advancedSearchButton.click();
        return new ClubsPage(driver);
    }

    public UserProfileMenu openUserProfileMenu() {
        wait.visibility(profileMenuButton);
        action.click(profileMenuButton);
        return new UserProfileMenu(driver);
    }

}
