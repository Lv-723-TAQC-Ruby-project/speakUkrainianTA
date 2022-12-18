package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddClubLocationTest extends BaseTestRunner {

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
    public void addClubLocationTest() {
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddClubModel()
                .EnterNameClub("New club to test location add")
                .selectCategoryByName("Спортивні секції")
                .enterFromAge("4")
                .enterToAge("15")
                .clickNextStep()
                .clickAddLocationButton()
                .addLocationName("Some location to test add location to club")
                .chooseLocationCity("Одеса")
                .chooseLocationStation("Фонтан")
                .chooseLocationDistrict("Малиновський")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("49.9935, 36.2304")
                .addLocationPhone("0661111111")
                .clickAddLocationButton();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
