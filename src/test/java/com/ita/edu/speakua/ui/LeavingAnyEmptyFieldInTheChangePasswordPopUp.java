package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModel;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeavingAnyEmptyFieldInTheChangePasswordPopUp extends BaseTestRunner {

    @BeforeClass
    public void setUp() {
        setDriver();
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin();
    }
    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }


    @Test
    public void warningMessageAboutEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModel editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterCurrentPassword(configProperties.getAdminPassword())
                .enterNewPasswordInTheNewPasswordField("admin1")
                .clickOnTheSaveChangesButton().openEditProfileModel(); //not completed!!
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
