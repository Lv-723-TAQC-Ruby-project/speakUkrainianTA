package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ClubsPO.AdvancedSearchComponent;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubCard;
import com.ita.edu.speakua.ui.Pages.ClubsPO.ClubsPage;
import com.ita.edu.speakua.ui.headercomponent.HeaderComponent;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.ITestContext;
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
    public void setUp(ITestContext context) {
        setDriver(context);
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
    public void clubFiltersCheck() {

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
    public void centerFiltersCheck() {
        SoftAssert softAssert = new SoftAssert();

        String radioValue = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .getRadioValueString();

        softAssert.assertEquals(radioValue,"Гурток");

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver).clickRadioCenter();

        radioValue = advancedSearchComponent.getRadioValueString();

        softAssert.assertEquals(radioValue,"Центр");

        softAssert.assertTrue(advancedSearchComponent.isCityActive(),"Didn't find city dropdown");
        softAssert.assertTrue(advancedSearchComponent.isDistrictActive(),"Didn't find district dropdown");
        softAssert.assertTrue(advancedSearchComponent.isStationActive(),"Didn't find station dropdown");

        softAssert.assertFalse(advancedSearchComponent.isAgeChildActive(),"Did find child age field");

        softAssert.assertAll();
    }

    @Test
    public void formatListCheck() {
        SoftAssert softAssert = new SoftAssert();

        String radioValue = new HomePage(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .getRadioValueString();

        softAssert.assertEquals(radioValue,"Гурток");

        AdvancedSearchComponent advancedSearchComponent = new AdvancedSearchComponent(driver).clickRadioCenter();

        radioValue = advancedSearchComponent.getRadioValueString();

        softAssert.assertEquals(radioValue,"Центр");

        boolean contentView= advancedSearchComponent
                .clickControlViewList()
                .controlViewDisplay();

        softAssert.assertTrue(contentView,"Content is not displayed as a list");

        softAssert.assertAll();
    }

    @Description("verify sorting of centers alphabetically in both ascending and descending order")
    @Test
    public void sortOfCentersByAlphabeticallySuccessTest() {
        boolean openSearch = new HeaderComponent(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .isAdvancedSearchOpen();
        Assert.assertTrue(openSearch);
        ClubsPage sortAlphabeticallyDescending = new AdvancedSearchComponent(driver)
                .clickRadioCenter()
                .clickSortAlphabetical()
                .clickSortDescending()
                .getClubPage();
        List<ClubCard> cards = sortAlphabeticallyDescending.getCards();
        ArrayList<String> listTitle = new ArrayList<>();
        for (ClubCard card : cards) {
            listTitle.add(card.getTitleOfCenter());
        }
        ArrayList<String> sortedList = new ArrayList<>(listTitle);
        sortedList.sort(Collections.reverseOrder());
        Assert.assertEquals(listTitle, sortedList, "Cards didn't sort");

        String sortAlphabeticallyAscending = new AdvancedSearchComponent(driver)
                .clickSortAscending()
                .getClubPage()
                .getCard(0)
                .getTitleOfCenter();
        Assert.assertEquals(sortAlphabeticallyAscending, "API testing2", "Cards didn't sort");

    }

    @Description("verify sorting of clubs alphabetically and rating in both ascending and descending order")
    @Test
    public void sortOfClubsByAlphabeticallyAndRatingSuccessTest() {
        SoftAssert softAssert = new SoftAssert();
        ClubsPage clubsPageAscRating = new HeaderComponent(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .clickSortByRating()
                .clickSortAscending()
                .getClubPage();
        List<ClubCard> cardsAscRating = clubsPageAscRating.getCards();
        ArrayList<Integer> listTitleAscRating = new ArrayList<>();
        for (ClubCard card : cardsAscRating) {
            listTitleAscRating.add(card.getRatingStars());
        }
        ArrayList<Integer> sortedListAscRating = new ArrayList<>(listTitleAscRating);
        Collections.sort(sortedListAscRating);
        softAssert.assertEquals(listTitleAscRating, sortedListAscRating, "Sorting clubs rating in ascending order failed");

        Integer clubsPageDscRating = new AdvancedSearchComponent(driver)
                .clickSortDescending()
                .getClubPage()
                .getCards()
                .get(0)
                .getRatingStars();
        softAssert.assertEquals(clubsPageDscRating, "5", "Sorting clubs rating in ascending order failed");

    }
    @Description("check that the child's age entered in the field is correct")
    @Test
    public void InputAgeChildTest() {
        SoftAssert softAssert = new SoftAssert();
        AdvancedSearchComponent advancedSearchComponent = new HomePage(driver).openAdvancedSearch().getAdvancedSearchComponent();

        advancedSearchComponent.enterNumberAge("1");
        String textNumber1 = advancedSearchComponent.getAgeChildField();
        softAssert.assertEquals(textNumber1, "2", "check failed with number 1");

        advancedSearchComponent.enterNumberAge("2");
        String textNumber2 = advancedSearchComponent.getAgeChildField();
        softAssert.assertEquals(textNumber2, "2", "check failed with number 2");

        advancedSearchComponent.enterNumberAge("18");
        String textNumber18 = advancedSearchComponent.getAgeChildField();
        softAssert.assertEquals(textNumber18, "18", "check failed with number 18");

        advancedSearchComponent.enterNumberAge("19");
        String textNumber19 = advancedSearchComponent.getAgeChildField();
        softAssert.assertEquals(textNumber19, "18", "check failed with number 19");

        softAssert.assertAll();
    }

    @Description("check sorting of clubs alphabetically and rating in both ascending and descending order")
    @Test
    public void sortingOfClubsInAdvancedSearchByAlphabeticallyAndRatingTest() {
        SoftAssert softAssert = new SoftAssert();
        ClubsPage clubsPage = new HeaderComponent(driver)
                .openAdvancedSearch()
                .getAdvancedSearchComponent()
                .clickSortAlphabetical()
                .clickSortAscending()
                .getClubPage();
        List<ClubCard> cardsAscAlpha = clubsPage.getCards();
        ArrayList<String> listTitleAscAlpha = new ArrayList<>();
        for (ClubCard card : cardsAscAlpha) {
            listTitleAscAlpha.add(card.getTitle());
        }
        ArrayList<String> sortedListAscAlpha = new ArrayList<>(listTitleAscAlpha);
        Collections.sort(sortedListAscAlpha);
        softAssert.assertEquals(listTitleAscAlpha, sortedListAscAlpha, "Sorting clubs alphabetically in ascending order failed");


        List<ClubCard> cardsDescAlpha = new AdvancedSearchComponent(driver)
                .clickSortDescending()
                .getClubPage()
                .getCards();
        ArrayList<String> listTitleDescAlpha = new ArrayList<>();
        for (ClubCard card : cardsDescAlpha) {
            listTitleDescAlpha.add(card.getTitle());
        }
        ArrayList<String> sortedListDescAlpha = new ArrayList<>(listTitleDescAlpha);
        Collections.sort(sortedListDescAlpha, Collections.reverseOrder());
        softAssert.assertEquals(listTitleDescAlpha, sortedListDescAlpha, "Sorting clubs alphabetically in descending order failed");


        List<ClubCard> cardsAscRating = new AdvancedSearchComponent(driver)
                .clickSortByRating()
                .clickSortAscending()
                .getClubPage()
                .getCards();
        ArrayList<Integer> listTitleAscRating = new ArrayList<>();
        for (ClubCard card : cardsAscRating) {
            listTitleAscRating.add(card.getRatingStars());
        }
        ArrayList<Integer> sortedListAscRating = new ArrayList<>(listTitleAscRating);
        Collections.sort(sortedListAscRating);
        softAssert.assertEquals(listTitleAscRating, sortedListAscRating, "Sorting clubs rating in ascending order failed");


        List<ClubCard> cardsDescRating = new AdvancedSearchComponent(driver)
                .clickSortDescending()
                .getClubPage()
                .getCards();
        ArrayList<Integer> listTitleDescRating = new ArrayList<>();
        for (ClubCard card : cardsDescRating) {
            listTitleDescRating.add(card.getRatingStars());
        }
        ArrayList<Integer> sortedListDescRating = new ArrayList<>(listTitleDescRating);
        Collections.sort(sortedListDescRating, Collections.reverseOrder());
        softAssert.assertEquals(listTitleDescRating, sortedListDescRating, "Sorting clubs rating in descending order failed");
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
