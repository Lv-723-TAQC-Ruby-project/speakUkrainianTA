package com.ita.edu.speakua.ui;


import com.ita.edu.speakua.ui.Pages.ClubsPO.AdvancedSearchComponent;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;

import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModel;
import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        boolean isContainExit = new HomePage(driver).openGuestProfileMenu().openLoginModel().enterEmail(configProperties.getAdminEmail()).enterPassword(configProperties.getAdminPassword()).clickLogin().openGuestProfileMenu().isContain("Вийти");

        Assert.assertTrue(isContainExit);
    }

    @Test
    public void ClubPageSuccessTest() {
        String actualTitle = new HomePage(driver).clickClub().getCards().get(2).getTitle();

        Assert.assertEquals(actualTitle, "IT освіта: курси \"ГРАНД\"");
    }

    @Test
    public void MessageAboutIncorrectlyEnteredLastNameTest() {
        EditProfileModel editProfileModel = new HomePage(driver).openGuestProfileMenu().openLoginModel().enterEmail(configProperties.getAdminEmail()).enterPassword(configProperties.getAdminPassword()).clickLogin().openUserProfileMenu().openMyProfileModel().openEditProfileModel();
        boolean isMassageMore25Characters = editProfileModel.enterLastName("AfBbCcDdEeFfGgHhIiJjKkLlMmNn").isOpenMassageErrorLastNameContain("Прізвище не може містити більше, ніж 25 символів");
        Assert.assertTrue(isMassageMore25Characters);
        boolean isMassageWithSpecialCharacters = editProfileModel.enterLastName("!@#$%^&,").isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        Assert.assertTrue(isMassageWithSpecialCharacters);
        boolean isMassageWithNumbers = editProfileModel.enterLastName("1234").isOpenMassageErrorLastNameContain("Прізвище не може містити спеціальні символи");
        Assert.assertTrue(isMassageWithNumbers);
        boolean isMassageStartedWithHyphen = editProfileModel.enterLastName("-Lastname").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithHyphen);
        boolean isMassageStartedWithSpace = editProfileModel.enterLastName(" Lastname").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithSpace);
        boolean isMassageStartedWithApostrophe = editProfileModel.enterLastName("'Lastname").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageStartedWithApostrophe);
        boolean isMassageEndedWithHyphen = editProfileModel.enterLastName("Lastname-").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithHyphen);
        boolean isMassageEndedWithSpace = editProfileModel.enterLastName("Lastname ").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithSpace);
        boolean isMassageEndedWithApostrophe = editProfileModel.enterLastName("Lastname'").isOpenMassageErrorLastNameContain("Прізвище повинно починатися і закінчуватися літерою");
        Assert.assertTrue(isMassageEndedWithApostrophe);
        boolean isMassageDeleteData = editProfileModel.deleteLastName().isOpenMassageErrorLastNameContain("Будь ласка введіть Ваше прізвище");
        Assert.assertTrue(isMassageDeleteData);
    }

    @Test
    public void MessageAboutIncorrectlyEnteredNumberPhoneTest() {
        EditProfileModel editProfileModel = new HomePage(driver).openGuestProfileMenu().openLoginModel().enterEmail(configProperties.getAdminEmail()).enterPassword(configProperties.getAdminPassword()).clickLogin().openUserProfileMenu().openMyProfileModel().openEditProfileModel();
        boolean isMassageLessThan13Symbols = editProfileModel.enterNumberPhone("06895").isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageLessThan13Symbols);
        boolean isMassageMoreThan13Symbols = editProfileModel.enterNumberPhone("06593859632586").isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageMoreThan13Symbols);
        boolean isMassageLetters = editProfileModel.enterNumberPhone("jngeoлщшогнеп").isOpenMassageErrorPhoneContain("Телефон не може містити літери\n" + "Телефон не відповідає вказаному формату");
        Assert.assertTrue(isMassageLetters);
        boolean isMassageSpecialCharacters = editProfileModel.enterNumberPhone("!@#$%^&*(_+.:").isOpenMassageErrorPhoneContain("Телефон не відповідає вказаному формату\n" + "Телефон не може містити спеціальні символи");
        Assert.assertTrue(isMassageSpecialCharacters);
        boolean isMassageDeleteData = editProfileModel.deleteNumberPhone().isOpenMassageErrorPhoneContain("Будь ласка введіть Ваш номер телефону");
        Assert.assertTrue(isMassageDeleteData);
    }

    @Test
    public void InputAgeChildTest() {
        AdvancedSearchComponent advancedSearchComponent = new HomePage(driver).openAdvancedSearch().getAdvancedSearchComponent();
        String textNumber1 = advancedSearchComponent.enterNumberAge("1").getAgeChildField();
        Assert.assertEquals(textNumber1, "2");
        String textNumber2 = advancedSearchComponent.enterNumberAge("2").getAgeChildField();
        Assert.assertEquals(textNumber2, "2");
        String textNumber18 = advancedSearchComponent.enterNumberAge("18").getAgeChildField();
        Assert.assertEquals(textNumber18, "18");
        String textNumber19 = advancedSearchComponent.enterNumberAge("19").getAgeChildField();
        Assert.assertEquals(textNumber19, "18");
    }

    @Test
    public void sortAdvancedSearchTest() {
        ClubsPage clubsPage = new HeaderComponent(driver).openAdvancedSearch();
        clubsPage
                .getAdvancedSearchComponent()
                .clickSortAlphabetical()
                .clickSortAscending();
        List<ClubCard> cards = clubsPage.getCards();
        ArrayList<String> listTitle = new ArrayList<>();
        for (ClubCard card : cards) {
            listTitle.add(card.getTitle());
        }
        ArrayList<String> sortedList = new ArrayList<>(listTitle);
        Collections.sort(sortedList);
        Assert.assertEquals(listTitle, sortedList);

//        ArrayList<String> obtainedList = new ArrayList<>();
//        List<WebElement> elementList = driver.findElements(By.xpath("//div[contains(@class,'ant-card ant-card-bordered card')]"));
//        for (WebElement we : elementList) {
////            try {
////                WebElement button = driver.findElement(By.xpath("//div[contains(@class,'ant-card ant-card-bordered card')]"));
////                button.click();
////            }
////            catch(org.openqa.selenium.StaleElementReferenceException ex)
////            {
////                WebElement button = driver.findElement(By.xpath("//div[contains(@class,'ant-card ant-card-bordered card')]"));
////                button.click();
////            }
//            obtainedList.add(we.getText());
//        }
//        ArrayList<String> sortedList = new ArrayList<>();
//        for (String s : obtainedList) {
//            sortedList.add(s);
//            Collections.sort(sortedList);
//            Assert.assertTrue(sortedList.equals(obtainedList));
////            Assert.assertEquals(sortedAlphabeticallyAscending.getClubTitle(),sortedAlphabeticallyAscending.cardsAlphabetically(),"cards don't sorted");
//        }
    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
