package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SearchTests extends BaseTestRunner {
    @BeforeClass
    public void setUp() {
        setDriver();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    public void oneSymbolEnteredInTheField() {
        List<WebElement> searchListInitialState = new HomePage(driver)
                .clickSearchField()
                .getComponentsOfTheSearchList();
        List<WebElement> searchListAfterInputtingData = new HomePage(driver)
                .clickSearchField()
                .enterTextInTheSearchFieldAndWait("з", 10)
                .getComponentsOfTheSearchList();
        String initial = searchListInitialState.get(3).getText();
        String afterAllActions = searchListAfterInputtingData.get(3).getText();
        Assert.assertNotEquals(initial, afterAllActions);
    }

    @Test(invocationCount = 10)
    public void fiftySymbolsEnteredInTheSearchField() {
        List<WebElement> searchListInitialState = new HomePage(driver)
                .clickSearchField()
                .getComponentsOfTheSearchList();
        List<WebElement> searchListAfterInputtingData = new HomePage(driver)
                .clickSearchField()
                .enterTextInTheSearchFieldAndWait("лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1", 1)
                .getComponentsOfTheSearchList();
        String initial = searchListInitialState.get(1).getAttribute("title");
        String afterAllActions = searchListAfterInputtingData.get(1).getAttribute("title");
        Assert.assertNotEquals(initial, afterAllActions);
    }

    @Test
    public void moreThanFiftySymbolsEnteredInTheSearchField() {
        String inputData = "лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1234567890";
        String cutInputData = new HomePage(driver)
                .clickSearchField()
                .enterTextInTheSearchField(inputData)
                .getSearchFieldInputValue();
        Assert.assertEquals(cutInputData, "лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
