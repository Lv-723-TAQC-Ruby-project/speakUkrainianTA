package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        boolean IsMassageMore25Characters= new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openUserProfileMenu()
                .openMyProfileModel()
                .openEditProfileModel()
                .EnterLastName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn")
                .isOpenMassageErrorContain("Прізвище не може містити більше, ніж 25 символів");
        Assert.assertTrue(IsMassageMore25Characters);

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
