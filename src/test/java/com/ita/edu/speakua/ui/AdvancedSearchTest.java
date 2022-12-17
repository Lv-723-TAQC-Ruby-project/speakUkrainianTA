package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.AdvancedSearchComponent;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdvancedSearchTest extends BaseTestRunner {

    @BeforeClass
    public void setUp() {
        setDriver();
    }

    @BeforeMethod
    public void goHomePage() {
        driver.get(configProperties.getBaseWebUrl());
    }

    @Test
    public void openCheck() {
        SoftAssert softAssert = new SoftAssert();

        HomePage Page = new HomePage(driver);

        boolean check  = Page
               .openAdvancedSearch()
                .getAdvancedSearchComponent()
               .isAdvancedSearchOpen();

        softAssert.assertTrue(check);

        check = Page
               .openAdvancedSearch()
                .getAdvancedSearchComponent()
               .isAdvancedSearchOpen();

        softAssert.assertFalse(check);

        softAssert.assertAll();
    }

    @Test
    public void activateClubFiltersCheck() {

        SoftAssert softAssert = new SoftAssert();

        String radioValue = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .getRadioValueString();

        softAssert.assertEquals(radioValue,"Гурток");

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver);

        softAssert.assertTrue(advancedSearchComponent.isCityActive(),"Didn't find city dropdown");
        softAssert.assertTrue(advancedSearchComponent.isDistrictActive(),"Didn't find district dropdown");
        softAssert.assertTrue(advancedSearchComponent.isStationActive(),"Didn't find station dropdown");
        softAssert.assertTrue(advancedSearchComponent.isRemoteActive(),"Didn't find remote checkbox");
        softAssert.assertTrue(advancedSearchComponent.isCategoryActive(),"Didn't find category checkboxes");
        softAssert.assertTrue(advancedSearchComponent.isAgeChildActive(),"Didn't find child age field");

        softAssert.assertAll();
    }

    @Test
    public void activateCenterFiltersCheck() {
        SoftAssert softAssert = new SoftAssert();

        String radioValue = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .getRadioValueString();

        softAssert.assertEquals(radioValue,"Гурток");

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver).clickRadioCenter();
        softAssert.assertEquals(radioValue,"Центр");

        softAssert.assertTrue(advancedSearchComponent.isCityActive(),"Didn't find city dropdown");
        softAssert.assertTrue(advancedSearchComponent.isDistrictActive(),"Didn't find district dropdown");
        softAssert.assertTrue(advancedSearchComponent.isStationActive(),"Didn't find station dropdown");
        softAssert.assertFalse(advancedSearchComponent.isAgeChildActive(),"Did find child age field");

        softAssert.assertAll();
    }

    @Test
    public void sortAlphabeticallySuccessTest() {
        boolean openSearch = new HeaderComponent(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .isAdvancedSearchOpen();
        Assert.assertTrue(openSearch);
        ClubsPage sortAlphabeticallyAscending = new AdvancedSearchComponent(driver)
                .clickRadioCenter()
                .clickSortAlphabetical()
                .clickSortAscending()
                .getClubPage();
        List<ClubCard> cards = sortAlphabeticallyAscending.getCards();
        ArrayList<String> listTitle = new ArrayList<>();
        for (ClubCard card : cards) {
            listTitle.add(card.getTitleOfCenter());
        }
        ArrayList<String> sortedList = new ArrayList<>(listTitle);
        Collections.sort(sortedList);
        Assert.assertEquals(listTitle, sortedList, "Cards don't sort");


        ClubsPage sortAlphabeticallyDescending = new AdvancedSearchComponent(driver)
                .clickRadioCenter()
                .clickSortAlphabetical()
                .clickSortDescending()
                .getClubPage();
        List<ClubCard> cardsDesceninng = sortAlphabeticallyDescending.getCards();
        ArrayList<String> listTitleDesceninng = new ArrayList<>();
        for (ClubCard card : cardsDesceninng) {
            listTitleDesceninng.add(card.getTitleOfCenter());
        }
        ArrayList<String> sortedListDesk = new ArrayList<>(listTitleDesceninng);
        sortedListDesk.sort(Collections.reverseOrder());
        Assert.assertEquals(listTitleDesceninng, sortedListDesk, "Cards don't sort");

    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
