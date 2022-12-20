package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddCenterModal;
import com.ita.edu.speakua.ui.Pages.ClubsPO.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends BasePageWithHeader {

    @FindBy(xpath = ".//div[@class='title']")
    protected List<WebElement> titleClubs;
    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default ant-dropdown-trigger ant-dropdown-open']")
    private WebElement addButton;

    @FindBy(xpath = "//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-active ant-dropdown-menu-item-only-child']//div[contains(text(),'Додати центр')]")
    private WebElement addCenterButton;

    @FindBy(xpath = "//*[@id=\"root\"]/section/section/main/section/main/div[3]/div[2]/div/section/ul/li[8]/a")
    private WebElement lastElementOfListOfCentersButton;


    public MyProfilePage(WebDriver driver) {
        super(driver);
    }
    @Step("open edit profile modal")
    public EditProfileModal openEditProfileModel() {
        wait.visibility(editProfileButton);
        action.click(editProfileButton);
        return new EditProfileModal(driver);
    }

    public ClubsPage getClubsPage() {
        return new ClubsPage(driver);
    }
    public AddCenterModal addCenterModel() {
        addButton.click();
        addCenterButton.click();
        return new AddCenterModal(driver);
    }

    public MyProfilePage clickLastElementOfTheListOfCenters(){
        wait.visibility(lastElementOfListOfCentersButton);
        action.click(lastElementOfListOfCentersButton);
        sleep(3);
        return this;
    }



}
