package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModel;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyFieldMessageInTheChangePasswordPopUp extends BaseTestRunner {

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
    public void warningMessageAboutConfirmPasswordEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModel editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterCurrentPassword(configProperties.getAdminPassword())
                .enterNewPasswordInTheNewPasswordField("admin1");
        editProfilePassword.clickOnTheSaveChangesButton();
        Assert.assertFalse(editProfilePassword.isPresentEmptyConfirmPasswordMessage(), "Будь ласка, підтвердіть пароль");
    }

    @Test
    public void warningMessageAboutNewPasswordEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModel editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterCurrentPassword(configProperties.getAdminPassword())
                .enterConfirmPassword("adminn");
        editProfilePassword.clickOnTheSaveChangesButton();
        Assert.assertFalse(editProfilePassword.isPresentEmptyNewPasswordFieldMessage(), "Будь ласка, введіть новий пароль");
    }

    @Test
    public void warningMessageAboutCurrentPasswordEmptyFieldInTheChangePasswordPopUp() {
        EditProfileModel editProfilePassword = new HomePage(driver)
                .openAdminProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel()
                .clickChangePasswordCheckBox()
                .enterNewPasswordInTheNewPasswordField("adminn")
                .enterConfirmPassword("adminn");
        editProfilePassword.clickOnTheSaveChangesButton();
        Assert.assertFalse(editProfilePassword.isPresentEmptyCurrentPasswordMessage(), "Введіть старий пароль");
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
