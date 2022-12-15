package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

public class SearchTest extends BaseTestRunner {
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
                .enterInTheSearchField("j")
                .getComponentsOfTheSearchList();
        String initial = searchListInitialState.get(0).getText();
        String afterAllActions = searchListAfterInputtingData.get(0).getText();
        Assert.assertEquals(initial, afterAllActions);
    }

    @Test
    public void fiftySymbolsEnteredInTheSearchField() {
        List<WebElement> searchListInitialState = new HomePage(driver)
                .clickSearchField()
                .getComponentsOfTheSearchList();
        List<WebElement> searchListAfterInputtingData = new HomePage(driver)
                .clickSearchField()
                .enterInTheSearchField("лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ")
                .getComponentsOfTheSearchList();
        String initial = searchListInitialState.get(0).getText();
        String afterAllActions = searchListAfterInputtingData.get(0).getText();
        Assert.assertEquals(initial, afterAllActions);
    }

    @Test
    public void moreThanFiftySymbolsEnteredInTheSearchField() {
        String inputData = "лпротирпавпнргошлщдзждлшогрнпеаквс65789ш/*длорпІВ1234567890";
        String cutInputData = new HomePage(driver)
                .clickSearchField()
                .enterInTheSearchField(inputData)
                .getSearchFieldInput();
        Assert.assertEquals(cutInputData.length(), 50);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
