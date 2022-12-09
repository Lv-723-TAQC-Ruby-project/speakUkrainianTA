package com.ita.edu.speakua.ui.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePO {

    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;


    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    public EditProfileModel openEditProfileModel(){
        editProfileButton.click();
        return new EditProfileModel(driver);
    }
}
