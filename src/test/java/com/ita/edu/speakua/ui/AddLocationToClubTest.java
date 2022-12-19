package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class AddLocationToClubTest extends BaseTestRunner {
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
    public void addCenterTest() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String clubName = "New Club to test add location " + timestamp;
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddClubModel()
                .EnterNameClub(clubName)
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("5")
                .enterToAge("10")
                .clickNextStep()
                .clickAddLocationButton()
                .addLocationName("New Location name" + timestamp)
                .chooseLocationCity("Харків")
                .chooseLocationStation("23 Серпня")
                .chooseLocationDistrict("Київський")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("49.9935, 36.2304")
                .addLocationPhone("0661111111")
                .clickAddLocationButtonToClub()
                .enterPhoneNumber("0661111111")
                .clickNextStep()
                .enterClubDescription("Some description of club in English #$^*@ Опис клубу українською мовою Some description of club in English #$^*@ Опис клубу українською мовою")
                .finishAddingCenter();
        new HomePage(driver)
                .openUserProfileMenu()
                .openMyProfileModel()
                .clickLastElementOfTheListOfCenters()
                .getClubsPage()
                .getCardByName(clubName)
                .getDetailInformation();
        String checkInformationAboutCenterByNumber = new ClubPage(driver)
                .getNumberPhone();
        Assert.assertEquals(checkInformationAboutCenterByNumber, "+380661111111");
        boolean checkInformationAboutCenterByDescription = new ClubPage(driver).getDescriptionAboutCenter("Відділення образотворчого та декоративного мистецтва відкрите з моменту заснування Студії.У 2005р. відбулась перша виставка робіт учасників Студії у Львівському обласному палаці мистецтв.");
        Assert.assertTrue(checkInformationAboutCenterByDescription);
    }
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
