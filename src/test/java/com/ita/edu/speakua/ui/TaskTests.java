package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTests extends BaseTestRunner {
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
    public void AddTask() {
        new HomePage(driver)
                .openAdminProfileMenu()
                .openTasksPage()
                .clickAddTask()
                .enterStartDate("2023-01-01")
                .uploadImage("C:\\Users\\User\\Desktop\\world-cup.jpg")
                .enterTaskName("World Cup task")
                .enterTaskTitle("The FIFA World Cup, often simply called the World Cup, is an international association football competition contested by the senior men's national teams of the members of the Federation Internationale de Football Association (FIFA, the International Federation of Association Football), the sport's global governing body")
                .enterTaskDescription("As of the 2018 FIFA World Cup, twenty-one final tournaments have been held and a total of 79 national teams have competed. The trophy has been won by eight national teams. Brazil have won five times, and they are the only team to have played in every tournament. The other World Cup winners are Germany and Italy, with four titles each; Argentina, France, and inaugural winner Uruguay, with two titles each; and England and Spain, with one title each.")
                .chooseChallenge()
                .clickSave();

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
