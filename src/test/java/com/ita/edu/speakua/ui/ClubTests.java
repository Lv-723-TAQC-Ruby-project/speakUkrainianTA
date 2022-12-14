package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModel;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

        //Verify that the ‘Опис’ text field is filled in with valid data

        boolean withValidValueUkrainianAndEnglishLetters = addClubModel.enterClubDescription("'Education', 'students', 'Школа' 'балету' ")
                .successMessageDisplayed();

        Assert.assertTrue(withValidValueUkrainianAndEnglishLetters, "Error message doesn't display");

        boolean withValidValueNumbers = addClubModel.enterClubDescription("1234567890123456789012345678901234567890")
                .successMessageDisplayed();

        Assert.assertTrue(withValidValueNumbers, "Error message doesn't display");

        boolean withValidValueSpecialCharacters = addClubModel.enterClubDescription("!#$%&'()*+,-./:;<=>?@[]^_`{}~%^$#)&&^^(_&($%^#@!")
                .successMessageDisplayed();

        Assert.assertTrue(withValidValueSpecialCharacters, "Error message doesn't display");

        boolean withInappropriateDescription = addClubModel.enterClubDescription("ё ы э ъ")
                .isErrorMessageDisplayed("Опис гуртка не може містити російські літери");

        Assert.assertTrue(withInappropriateDescription, "Error message is displayed");

        boolean withShortDescription = addClubModel.enterClubDescription("В гурток ходить 3 людини")
                .isErrorMessageDisplayed("Опис гуртка може містити від 40 до 1500 символів.");

        Assert.assertTrue(withShortDescription, "Error message is displayed");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


