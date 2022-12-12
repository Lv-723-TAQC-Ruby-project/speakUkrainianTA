package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTestRunner {
    @BeforeMethod
    public void setUp() {
        setDriver();
    }
    @Test
    public void RegistrationDataRemembered() {
        boolean dataSaved= new HomePage(driver)
                .openGuestProfileMenu()
                .openRegistrationModel()
                .enterLastName("Войтович")
                .enterFirstName("Світлана")
                .enterPhone("671234567")
                .enterEmail("svitlanawhite@gmail.com")
                .enterPassword("12345678")
                .enterPasswordConfirm("12345678")
                .cancelRegistration()
                .openGuestProfileMenu().openRegistrationModel().allDataSaved();
        Assert.assertTrue(dataSaved);
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

