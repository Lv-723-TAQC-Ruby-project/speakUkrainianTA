package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.ChallengePО.AddChallengePage;
import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChallengeTest extends BaseTestRunner {

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




    @Test//(invocationCount = 10)
    public void addChallenge() {
        new HomePage(driver)
                .openAdminProfileMenu()
                .openChallengePage()
                .clickAddChallengeButton()
                .emptyFields();
        Assert.assertEquals("","");
        new AddChallengePage(driver)
                .enterSequenceNumber("12345678")
                .uploadChallengePhoto("C:\\Users\\lovel\\IdeaProjects\\speakUkrainianTA723\\OIP.jpeg")
                .enterChallengeName("ChallengeTest")
                .enterTitle("ChallengeTest")
                .enterChallengeDescription("Racing in an event like Red Bull Defiance is an emotional rollercoaster of highs and lows,\n but knowing about the biggest challenges you'll have to face beforehand\n gives you the best chance of making it to the finish.")
                .saveChallengeClick();

    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
