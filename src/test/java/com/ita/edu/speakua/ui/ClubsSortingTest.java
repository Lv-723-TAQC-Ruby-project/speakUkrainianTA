package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClubsSortingTest extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    @Description("Test sorting clubs by rating in ASC order")
    public void verifyThatTheClubsCanBeSortedByRatingAsc() {
        int rating = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .clearCityFieldClick()
                .clickSortByRating()
                .clickSortAscending()
                .getClubPage()
                .getCards()
                .get(0)
                .getRatingStars();
        Assert.assertEquals(rating, 0);
    }

    @Test
    @Description("Test sorting clubs by rating in DSC order")
    public void verifyThatTheClubsCanBeSortedByRatingDsc() {
        int rating = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .clearCityFieldClick()
                .clickSortByRating()
                .clickSortDescending()
                .getClubPage()
                .getCards()
                .get(0)
                .getRatingStars();
        Assert.assertEquals(rating, 5);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
