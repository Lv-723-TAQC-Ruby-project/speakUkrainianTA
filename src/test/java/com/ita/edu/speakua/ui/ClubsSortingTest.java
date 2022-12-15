package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClubsSortingTest extends BaseTestRunner {

    @BeforeClass
    public void setUp() {
        setDriver();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    public void verifyThatTheClubsCanBeSortedByRating() {
        AdvancedSearchModel sortedClubs = new HomePage(driver)
                .openAdvancedSearch()
                .clearCityField()
                .clickSortByRating();
        //not completed;
    }

   /* @Test
    public void searchByNameOfClub() {
        ClubCard searchedClubByNameAndLocation = new HomePage(driver)
                .
    }*/

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
