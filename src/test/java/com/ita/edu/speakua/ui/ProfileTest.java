package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModal;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTest extends BaseTestRunner {
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
        driver.get(configProperties.getBaseWebUrl());}

    @Test
    public void MessageAboutIncorrectlyEnteredLastNameTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileModal editProfileModal = new HomePage(driver).openUserProfileMenu().openMyProfileModel().openEditProfileModel();
        boolean isMassageMore25Characters = editProfileModal.enterLastName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn").isOpenMassageErrorLastNameContain("Прізвище не може містити більше, ніж 25 символів");
        softAssert.assertTrue(isMassageMore25Characters, "the message more 25 characters check failed");
        boolean isMassageWithSpecialCharacters = editProfileModal.enterLastName("!@#$%^&,").isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        softAssert.assertTrue(isMassageWithSpecialCharacters, "the message with special characters check failed");
        boolean isMassageWithNumbers = editProfileModal.enterLastName("1234").isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        softAssert.assertTrue(isMassageWithNumbers,"the message with numbers check failed" );
        boolean isMassageStartedWithHyphen = editProfileModal.enterLastName("-Lastname").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMassageStartedWithHyphen, "the message started with hyphen check failed" );
        boolean isMassageStartedWithSpace = editProfileModal.enterLastName(" Lastname").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMassageStartedWithSpace, "the message started with space check failed" );
        boolean isMassageStartedWithApostrophe = editProfileModal.enterLastName("'Lastname").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMassageStartedWithApostrophe, "the message started with apostrophe check failed" );
        boolean isMassageEndedWithHyphen = editProfileModal.enterLastName("Lastname-").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMassageEndedWithHyphen, "the message ended with hyphen check failed");
        boolean isMassageEndedWithSpace = editProfileModal.enterLastName("Lastname ").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMassageEndedWithSpace, "the message ended with space check failed");
        boolean isMassageEndedWithApostrophe = editProfileModal.enterLastName("Lastname'").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        softAssert.assertTrue(isMassageEndedWithApostrophe, "the message ended with apostrophe check failed");
        boolean isMassageDeleteData = editProfileModal.deleteLastName().isOpenMassageErrorLastNameContain("Будь ласка введіть Ваше прізвище");
        softAssert.assertTrue(isMassageDeleteData, "the message delete data check failed" );
        softAssert.assertAll();
    }

    @Test
    public void MessageAboutIncorrectlyEnteredNumberPhoneTest() {
        SoftAssert softAssert = new SoftAssert();
        EditProfileModal editProfileModal = new HomePage(driver).openUserProfileMenu().openMyProfileModel().openEditProfileModel();
        boolean isMassageLessThan13Symbols = editProfileModal.enterNumberPhone("06895").isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        softAssert.assertTrue(isMassageLessThan13Symbols, "the message less than 13 symbols check failed");
        boolean isMassageMoreThan13Symbols = editProfileModal.enterNumberPhone("06593859632586").isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        softAssert.assertTrue(isMassageMoreThan13Symbols, "the message more than 13 symbols check failed");
        boolean isMassageLetters = editProfileModal.enterNumberPhone("jngeoлщшогнеп").isOpenMassageErrorPhoneContain("Телефон не може містити літери\n" + "Телефон не відповідає вказаному формату");
        softAssert.assertTrue(isMassageLetters, "the message letters check failed");
        boolean isMassageSpecialCharacters = editProfileModal.enterNumberPhone("!@#$%^&*(_+.:").isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату\n" + "Телефон не може містити спеціальні символи");
        softAssert.assertTrue(isMassageSpecialCharacters, "the message special characters check failed");
        boolean isMassageDeleteData = editProfileModal.deleteNumberPhone().isOpenMassageErrorPhoneContain("Будь ласка введіть Ваш номер телефону");
        softAssert.assertTrue(isMassageDeleteData, "the message delete data check failed");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
