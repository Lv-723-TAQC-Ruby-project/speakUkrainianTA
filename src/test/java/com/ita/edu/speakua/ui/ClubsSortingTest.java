package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
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

    @Test
    public void searchByNameOfClubAttachedToTheLocation() {
        String expectedTitle = new HomePage(driver)
                .clickLocationButton()
                .clickCityInTheLocationSection(0)
                .getCard(0)
                .getTitle();
        String actualResult = new HomePage(driver)
                .enterTextInTheSearchField(expectedTitle)
                .clickSearchButton()
                .getCards()
                .get(0)
                .getTitle();
        Assert.assertEquals(actualResult, expectedTitle);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
