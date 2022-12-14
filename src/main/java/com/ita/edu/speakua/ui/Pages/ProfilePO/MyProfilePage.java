package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;
import com.ita.edu.speakua.ui.Pages.ClubsPO.EditClubModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePO {

    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;

    @FindBy(xpath = "//a[@href='/dev/club/948']")
    private WebElement detailedSecondCenterButton;

    @FindBy(xpath = "//span[@class='ant-dropdown-menu-title-content']//div[text()='Редагувати гурток']")
    private WebElement editButton;

    @FindBy(xpath = "//div[@class='update-club-dropdown']")
    private WebElement menuClubButton;


    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditProfileModel openEditProfileModel(){
        editProfileButton.click();
        return new EditProfileModel(driver);
    }

    public ClubPage clickDetailedSecondCenter(){
        wait.visibility(detailedSecondCenterButton);
        action.click(detailedSecondCenterButton);
        return new ClubPage(driver);
    }

    public EditClubModel openEditClubModel() {
        wait.visibility(menuClubButton);
        action.click(menuClubButton);
        wait.visibility(editButton);
        action.click(editButton);
        return new EditClubModel(driver);
    }




}
