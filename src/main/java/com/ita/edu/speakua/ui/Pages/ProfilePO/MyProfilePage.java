package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ClubsPO.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends BasePO {

    private ClubsPage clubsPage;

    @FindBy(xpath = ".//div[@class='title']")
    protected List<WebElement> titleClubs;
    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;


    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditProfileModel openEditProfileModel() {
        editProfileButton.click();
        return new EditProfileModel(driver);
    }

    public ClubsPage getClubsPage() {
        clubsPage = new ClubsPage(driver);
        return clubsPage;
    }



}
