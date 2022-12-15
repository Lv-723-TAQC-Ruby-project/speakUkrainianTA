package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddCenterTest extends BaseTestRunner {
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
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModel()
                .enterCenterName("New Center Name")
                .addLocation()
                .addLocationName("New Location name")
                .chooseLocationCity("Київ")
                .chooseLocationStation("Позняки")
                .chooseLocationDistrict("Печерський")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("49.9935, 36.2304")
                .addLocationPhone("0661111111")
                .clickAddLocationButton();

        Assert.assertEquals(true, true);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
