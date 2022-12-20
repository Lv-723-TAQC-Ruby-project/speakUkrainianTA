package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.Pages.ChallengePО.AddChallengePage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import io.qameta.allure.Description;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ChallengeTest extends BaseTestRunner {

    @BeforeClass
    public void setUp(ITestContext context) {
        setDriver(context);
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


    @Description("Add challenge")
    @Test//(invocationCount = 10)
    public void addChallenge() {
        AddChallengePage addChallengePage = new HomePage(driver)
                .openAdminProfileMenu()
                .openChallengePage()
                .clickAddChallengeButton();
        SoftAssert softAssert = new SoftAssert(); //Check if fields empty
        softAssert.assertEquals(addChallengePage.getSequenceNumber().getText(), "", "Sequence field is empty");
        softAssert.assertEquals(addChallengePage.getUploadPhoto().getText(), "", "Photo is not uploaded");
        softAssert.assertEquals(addChallengePage.getChallengeName().getText(), "", "Challenge name field is empty");
        softAssert.assertEquals(addChallengePage.getTitleInput().getText(), "", "Title field is empty");
        softAssert.assertEquals(addChallengePage.getChallengeDescription().getText(), "", "Description field is empty");
        softAssert.assertAll();
        softAssert = new SoftAssert();
        boolean dataFilled = new AddChallengePage(driver)
                .enterSequenceNumber("215")
                .uploadChallengePhoto("OIP.jpeg")
                .enterChallengeName("ChallengeTest")
                .enterTitle("ChallengeTest")
                .enterChallengeDescription("Racing in an event like Red Bull Defiance is an emotional rollercoaster of highs and lows,\n but knowing about the biggest challenges you'll have to face beforehand\n gives you the best chance of making it to the finish.")
                .saveChallengeClick()
                .successMessage();

        softAssert.assertTrue(dataFilled);
        softAssert.assertAll();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
