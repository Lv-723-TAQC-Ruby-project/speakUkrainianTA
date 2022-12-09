package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class contentTest extends BaseTestRunner {
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



    @Test//(invocationCount = 10)
    public void ClickAddChallenge() {
        new HomePage(driver)
                .openAdminProfileMenu()
                .openChallengePage()
                .clickAddChallengeButton();

    }
    @Test
    public void OpenAddTaskPage() {
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .addTaskButton();

    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
