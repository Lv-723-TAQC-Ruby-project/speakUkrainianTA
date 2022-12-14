package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.AddClubModel;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;
import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModel;
import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.profilemenu.UserProfileMenu;
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
        boolean isMassageMore25Characters=editProfileModel.enterLastName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn")
                .isOpenMassageErrorLastNameContain("Прізвище не може містити більше, ніж 25 символів");
        Assert.assertTrue(isMassageMore25Characters);
        boolean isMassageWithSpecialCharacters=editProfileModel.enterLastName("!@#$%^&,")
                .isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        Assert.assertTrue(isMassageWithSpecialCharacters);
        boolean isMassageWithNumbers=editProfileModel.enterLastName("1234")
                .isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        Assert.assertTrue(isMassageWithNumbers);
        boolean isMassageStartedWithHyphen=editProfileModel.enterLastName("-Lastname")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithHyphen);
        boolean isMassageStartedWithSpace=editProfileModel.enterLastName(" Lastname")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithSpace);
        boolean isMassageStartedWithApostrophe=editProfileModel.enterLastName("'Lastname")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithApostrophe);
        boolean isMassageEndedWithHyphen=editProfileModel.enterLastName("Lastname-")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithHyphen);
        boolean isMassageEndedWithSpace=editProfileModel.enterLastName("Lastname ")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithSpace);
        boolean isMassageEndedWithApostrophe=editProfileModel.enterLastName("Lastname'")
                .isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithApostrophe);
        boolean isMassageDeleteData=editProfileModel.deleteLastName()
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
        boolean isMassageLessThan13Symbols = editProfileModel.enterNumberPhone("06895")
                .isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageLessThan13Symbols);
        boolean isMassageMoreThan13Symbols = editProfileModel.enterNumberPhone("06593859632586")
                .isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageMoreThan13Symbols);
        boolean isMassageLetters = editProfileModel.enterNumberPhone("jngeoлщшогнеп")
                .isOpenMassageErrorPhoneContain("Телефон не може містити літери\n" + "Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageLetters);
        boolean isMassageSpecialCharacters = editProfileModel.enterNumberPhone("!@#$%^&*(_+.:")
                .isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату\n" + "Телефон не може містити спеціальні символи");
        Assert.assertTrue(isMassageSpecialCharacters);
        boolean isMassageDeleteData = editProfileModel.deleteNumberPhone()
                .isOpenMassageErrorPhoneContain("Будь ласка введіть Ваш номер телефону");
        Assert.assertTrue(isMassageDeleteData);
    }

    @Test
    public void InputAgeChildTest() {
        AdvancedSearchModel advancedSearchModel = new HomePage(driver)
                .openAdvancedSearch();
        String textNumber1 = advancedSearchModel.EnterNumberAge("1").getAgeChildField();
        Assert.assertEquals(textNumber1,"2");
        String textNumber2 = advancedSearchModel.EnterNumberAge("2").getAgeChildField();
        Assert.assertEquals(textNumber2,"2");
        String textNumber18 = advancedSearchModel.EnterNumberAge("18").getAgeChildField();
        Assert.assertEquals(textNumber18,"18");
        String textNumber19 = advancedSearchModel.EnterNumberAge("19").getAgeChildField();
        Assert.assertEquals(textNumber19,"18");
    }



    @Test
    public void VerifyCreatingClubAndFindingInformationAboutTest(){
        new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getHeadClubEmail())
                .enterPassword(configProperties.getHeadClubPassword())
                .clickLogin()
                .openUserProfileMenu()
                .openAddClubModel()
                .EnterNameClub("Малявки")
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("8")
                .enterToAge("16")
                .enterBelongingToCenter("Курси програмування IT-stat")
                .clickNextStep()
                .enterPhoneNumber("0934444444")
                .clickNextStep()
                .enterClubDescription("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.")
                .finishAddingCenter();
        String checkInformationAboutCenterByNumber= new HeaderComponent(driver)
                .openUserProfileMenu()
                .openMyProfileModel()
                .clickDetailedSecondCenter()
                .getNumberPhone();
        Assert.assertEquals(checkInformationAboutCenterByNumber, "+380934444444");
        boolean checkInformationAboutCenterByDescription = new ClubPage(driver)
                .getDescriptionAboutCenter("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.");
        Assert.assertTrue(checkInformationAboutCenterByDescription);
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
