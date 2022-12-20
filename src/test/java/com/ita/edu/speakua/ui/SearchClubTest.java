package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchClubTest extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    @Description("Verify if name of club is attached to the location of this club")
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
