package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

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
    public void checkIfErrorAppearsAfterEmptyFields() {
        boolean message = new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModel()
                .clickNextStep()
                .isMessageErrorCenterWithoutName();
        Assert.assertTrue(message, "Error message 'Некоректна назва центру’ doesn't appear under 'Назва центру' field with empty 'Назва центру' field");
    }
    @Test
    public void addCenterTest() {
        new HomePage(driver)
                .openUserProfileMenu()
                .openAddCenterModel()
                .enterCenterName("New Center Name")
                .addLocation()
                .addLocationName("New Location name")
                .chooseLocationCity("Харків")
                .chooseLocationStation("23 Серпня")
                .chooseLocationDistrict("Київський")
                .addLocationAddress("New Location address")
                .addLocationCoordinates("49.9935, 36.2304")
                .addLocationPhone("0661111111")
                .clickAddLocationButton()
                .selectCenterLocation()
                .clickNextStep()
                .centerContactsTelephone("0661111111")
                .centerContactsEmail("admin@com.ua")
                .centerContactsSkype("Skype")
                .clickNextStep()
                .addLogo("centerLogo.png")
                .addPhoto("centerPhoto.jpeg")
                .addDescription("There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc.")
                .clickNextStep()
                .chooseClub()
                .finishAddCenter();
        Assert.assertEquals(driver.getTitle(), "Навчай українською");
    }

//    @Test
//    public void CheckCenter() {
//        new HomePage(driver)
//                .openAdvancedSearch()
//                .getAdvancedSearchComponent()
//                .clickRadioCenter()
//                .chooseCity("Харків")
//                .;
//    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
