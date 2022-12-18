package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddCenterModal;
import com.ita.edu.speakua.ui.Pages.ClubsPO.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends BasePageWithHeader {

    private ClubsPage clubsPage;

    @FindBy(xpath = ".//div[@class='title']")
    protected List<WebElement> titleClubs;
    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default ant-dropdown-trigger ant-dropdown-open']")
    private WebElement addButton;

    @FindBy(xpath = "//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-active ant-dropdown-menu-item-only-child']//div[contains(text(),'Додати центр')]")
    private WebElement addCenterButton;


    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditProfileModal openEditProfileModel() {
        wait.visibility(editProfileButton);
        action.click(editProfileButton);
        return new EditProfileModal(driver);
    }

    public ClubsPage getClubsPage() {
        clubsPage = new ClubsPage(driver);
        return clubsPage;
    }

    public AddCenterModal addCenterModel() {
        addButton.click();
        addCenterButton.click();
        return new AddCenterModal(driver);
    }



}
