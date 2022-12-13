package com.ita.edu.speakua.ui.runners;

import com.ita.edu.speakua.ui.AddClubModel;
import com.ita.edu.speakua.ui.HomePage;
import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModel;
import org.testng.Assert;
import org.testng.annotations.*;

public class ClubTest extends BaseTestRunner {

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

        //Verify that error message appears when user enters letters in Russian language into the field

        boolean withUnvalidRussianLetters = addClubModel.enterClubDescription("ё ы э ъ")
                .isErrorLanguageMessageDisplayed();

        Assert.assertFalse(withUnvalidRussianLetters, "Опис гуртка не може містити російські літери");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
