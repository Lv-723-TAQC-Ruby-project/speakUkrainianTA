package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddCenterModel;
import com.ita.edu.speakua.ui.Pages.ClubsPO.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyProfilePage extends BasePO {

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

    public EditProfileModel openEditProfileModel() {
        wait.visibility(editProfileButton);
        action.click(editProfileButton);
        return new EditProfileModel(driver);
    }

    public ClubsPage getClubsPage() {
        clubsPage = new ClubsPage(driver);
        return clubsPage;
    }

    public AddCenterModel addCenterModel() {
        addButton.click();
        addCenterButton.click();
        return new AddCenterModel(driver);
    }



}
