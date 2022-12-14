package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModel;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ClubTests extends BaseTestRunner {

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
    public void addVerifyDescriptionClubTest() {
        AddClubModel addClubModel = new HomePage(driver)
                .openUserProfileMenu()
                .openAddClubModel()
                .EnterNameClub("Спорт")
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("5")
                .enterToAge("10")
                .clickNextStep()
                .enterPhoneNumber("0932584213")
                .clickNextStep();


        SoftAssert softAssert = new SoftAssert();
        //TUA-176
        softAssert.assertTrue(addClubModel.enterClubDescription("В гурток ходить 3 людини").isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів."));
        //TUA-178
        softAssert.assertTrue(addClubModel.enterClubDescription("ё ы э ъ").isErrorMessageDisplayed("Опис гуртка не може містити російські літери"));
        softAssert.assertTrue(addClubModel.enterClubDescription("ё ы э ъ").isErrorMessageDisplayed("Некоректний опис гуртка"));
        //TUA-173
        softAssert.assertTrue(addClubModel.enterClubDescription("'Education', 'students', 'Школа' 'балету'").successMessageDisplayed());
        softAssert.assertTrue(addClubModel.enterClubDescription("1234567890123456789012345678901234567890").successMessageDisplayed());
        softAssert.assertTrue(addClubModel.enterClubDescription("!#$%&'()*+,-./:;<=>?@[]^_`{}~%^$#)&&^^(_&($%^#@!").successMessageDisplayed());
        addClubModel.finishAddingCenter();
        softAssert.assertTrue(addClubModel.completeButtonEnabled());
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


