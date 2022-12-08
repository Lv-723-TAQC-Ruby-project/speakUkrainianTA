package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfileModel extends BasePO{

    @FindBy(xpath = "//input[@id='edit_lastName']")
    private WebElement editLastNameField;


    public EditProfileModel(WebDriver driver) {
        super(driver);
    }
}
