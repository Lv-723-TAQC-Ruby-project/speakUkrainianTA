package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfileModel extends BasePO{

    @FindBy(xpath = "//span[text()='Редагувати профіль']")
    private WebElement editProfileButton;


    public MyProfileModel(WebDriver driver) {
        super(driver);
    }

    public EditProfileModel openEditProfileModel(){
        editProfileButton.click();
        return new EditProfileModel(driver);
    }
}
