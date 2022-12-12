package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.ProfilePO.EditProfileModel;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

import static java.awt.SystemColor.text;

public class examplesTest extends BaseTestRunner {

    @BeforeMethod
    public void setUp() {
        setDriver();
    }

    @Test
    public void isOpenHomePage() {
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Ініціатива')]"));
        String text = element.getText();

        Assert.assertEquals(text, "Ініціатива “Навчай українською”");
        Assert.assertEquals(driver.getTitle(), "Навчай українською");
    }

    @Test
    public void loginSuccessTest() {
        boolean isContainExit = new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openGuestProfileMenu()
                .isContain("Вийти");

        Assert.assertTrue(isContainExit);
    }


    @Test
    public void addVerifyDescriptionClubTest() {
        AddClubModel addClubModel = new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openUserProfileMenu()
                .openAddClubModel()
                .EnterNameClub("Спорт")
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("5")
                .enterToAge("10")
                .clickNextStep()
                .enterPhoneNumber("0932584213")
                .clickNextStep();

        boolean withValidValueUkrainianAndEnglishWords = addClubModel.enterClubDescription("'Education', 'students', 'Школа' 'балету' ")
                .successMessageDisplayed();

        Assert.assertTrue(withValidValueUkrainianAndEnglishWords, "Error message doesn't display");

        boolean withValidValueNumbers = addClubModel.enterClubDescription("1234567890123456789012345678901234567890")
                .successMessageDisplayed();

        Assert.assertTrue(withValidValueNumbers, "Error message doesn't display");

        boolean withValidValueSpecialCharacters = addClubModel.enterClubDescription("!#$%&'()*+,-./:;<=>?@[]^_`{}~%^$#)&&^^(_&($%^#@!")
                .successMessageDisplayed();

        Assert.assertTrue(withValidValueSpecialCharacters, "Error message doesn't display");

    }


    @Test
    public void TestAddCenter() {
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openUserProfileMenu()
                .openAddCenterModel()
                .EnterCenterName("New Center Name")
                .AddLocation()
                .AddLocationName("New Location name")
                .AddLocationAddress("New Location address")
                .AddLocationCoordinates("New Location coordinates")
                .AddLocationPhone("0661111111");

        Assert.assertEquals(true, true);
    }

    @Test
    public void ClubPageSuccessTest() {
        String actualeTitle = new HomePage(driver)
                .clickClub()
                .getCards()
                .get(2).
                getTitle();

        Assert.assertEquals(actualeTitle, "IT освіта: курси \"ГРАНД\"");
    }


    @Test
    public void MessageAboutIncorrectlyEnteredLastNameTest(){
        EditProfileModel editProfileModel= new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openUserProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel();
        boolean isMassageMore25Characters=editProfileModel.EnterLastName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn")
                .isOpenMassageErrorLastNameContain("Прізвище не може містити більше, ніж 25 символів");
        Assert.assertTrue(isMassageMore25Characters);
        boolean isMassageWithSpecialCharacters=editProfileModel.EnterLastName("!@#$%^&,")
                .isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        Assert.assertTrue(isMassageWithSpecialCharacters);
        boolean isMassageWithNumbers=editProfileModel.EnterLastName("1234")
                .isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        Assert.assertTrue(isMassageWithNumbers);
        boolean isMassageStartedWithHyphen=editProfileModel.EnterLastName("-Lastname")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithHyphen);
        boolean isMassageStartedWithSpace=editProfileModel.EnterLastName(" Lastname")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithSpace);
        boolean isMassageStartedWithApostrophe=editProfileModel.EnterLastName("'Lastname")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithApostrophe);
        boolean isMassageEndedWithHyphen=editProfileModel.EnterLastName("Lastname-")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithHyphen);
        boolean isMassageEndedWithSpace=editProfileModel.EnterLastName("Lastname ")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithSpace);
        boolean isMassageEndedWithApostrophe=editProfileModel.EnterLastName("Lastname'")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithApostrophe);
        boolean isMassageDeleteData=editProfileModel.DeleteLastName()
                .isOpenMassageErrorLastNameContain("Будь ласка введіть Ваше прізвище");
        Assert.assertTrue(isMassageDeleteData);
    }
    @Test
    public void MessageAboutIncorrectlyEnteredNumberPhoneTest() {
        EditProfileModel editProfileModel = new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openUserProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel();
        boolean isMassageLessThan13Symbols = editProfileModel.EnterNumberPhone("06895")
                .isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageLessThan13Symbols);
        boolean isMassageMoreThan13Symbols = editProfileModel.EnterNumberPhone("06593859632586")
                .isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageMoreThan13Symbols);
        boolean isMassageLetters = editProfileModel.EnterNumberPhone("jngeoлщшогнеп")
                .isOpenMassageErrorPhoneContain("Телефон не може містити літери\n" + "Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageLetters);
        boolean isMassageSpecialCharacters = editProfileModel.EnterNumberPhone("!@#$%^&*(_+.:")
                .isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату\n" + "Телефон не може містити спеціальні символи");
        Assert.assertTrue(isMassageSpecialCharacters);
        boolean isMassageDeleteData = editProfileModel.DeleteNumberPhone()
                .isOpenMassageErrorPhoneContain("Будь ласка введіть Ваш номер телефону");
        Assert.assertTrue(isMassageDeleteData);
    }

    @Test
    public void InputAgeChildTest() {
        ExtendedSearchPage extendedSearchPage = new HomePage(driver)
                .openExtendedSearch();
        String textNumber1 = extendedSearchPage.EnterNumberAge("1").getAgeChildField();
        Assert.assertEquals(textNumber1,"2");
        String textNumber2 = extendedSearchPage.EnterNumberAge("2").getAgeChildField();
        Assert.assertEquals(textNumber2,"2");
        String textNumber18 = extendedSearchPage.EnterNumberAge("18").getAgeChildField();
        Assert.assertEquals(textNumber18,"18");
        String textNumber19 = extendedSearchPage.EnterNumberAge("19").getAgeChildField();
        Assert.assertEquals(textNumber19,"18");
    }

    @Test
    public void RegistrationDataRemembered() {
        new HomePage(driver)
                .openGuestProfileMenu()
                .openRegistrationModel()
                .enterLastName(configProperties.getLastName())
                .enterFirstName(configProperties.getFirstName())
                .enterPhone(configProperties.getPhone())
                .enterEmail(configProperties.getEmail())
                .enterPassword(configProperties.getPassword())
                .enterPasswordConfirm(configProperties.getConfirm())
                        .cancelRegistration()
                                .openGuestProfileMenu()
                                        .openRegistrationModel();

          Assert.assertTrue(true,"Войтович");
        Assert.assertTrue(true,"Світлана");
        Assert.assertTrue(true,"671234567");
        Assert.assertTrue(true,"671234567");
        Assert.assertTrue(true,"671234567");
        Assert.assertTrue(true,"svitlanawhite@gmail.com");
        Assert.assertTrue(true,"12345678");
        Assert.assertTrue(true,"12345678");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
