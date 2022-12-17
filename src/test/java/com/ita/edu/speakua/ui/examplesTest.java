package com.ita.edu.speakua.ui;


import com.ita.edu.speakua.ui.Pages.ClubsPO.AdvancedSearchComponent;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;

import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.Pages.ProfilePO.EditProfileModel;
import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
    public void VerifyCreatingClubAndFindingInformationAboutTest() {
        new HomePage(driver).openGuestProfileMenu().openLoginModel().enterEmail(configProperties.getHeadClubEmail()).enterPassword(configProperties.getHeadClubPassword()).clickLogin().openUserProfileMenu().openAddClubModel().EnterNameClub("Малявки").selectCategoryByName("Спортивні секції").enterFromAge("8").enterToAge("16").enterBelongingToCenter("Курси програмування IT-stat").clickNextStep().enterPhoneNumber("0934444444").clickNextStep().enterClubDescription("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.").finishAddingCenter();
        String checkInformationAboutCenterByNumber = new HeaderComponent(driver).openUserProfileMenu().openMyProfileModel().clickDetailedSecondCenter().getNumberPhone();
        Assert.assertEquals(checkInformationAboutCenterByNumber, "+380934444444");
        boolean checkInformationAboutCenterByDescription = new ClubPage(driver).getDescriptionAboutCenter("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.");
        Assert.assertTrue(checkInformationAboutCenterByDescription);
    }

    @Test
    public void VerifyEditingClubAndFindingInformationAboutItTest() {
        new HomePage(driver).openGuestProfileMenu().openLoginModel().enterEmail(configProperties.getHeadClubEmail()).enterPassword(configProperties.getHeadClubPassword()).clickLogin().openUserProfileMenu().openMyProfileModel().openEditClubModel();

    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
