package com.ita.edu.speakua.ui;

import com.ita.edu.speakua.ui.runners.BaseTestRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class examplesTest extends BaseTestRunner {

    @BeforeMethod
    public void setUp() {
        setDriver();
    }

    @Test
    public void isOpenHomePage() {
        WebElement element = driver.findElement(By.xpath("//h2[contains(text(), 'Ініціатива')]"));
        String text = element.getText();

        Assert.assertEquals(text, "Ініціатива “Навчай українською”");
        Assert.assertEquals(driver.getTitle(), "Навчай українською");
    }

    @Test
    public void loginSuccessTest() {
        boolean isContainExit = new HomePage(driver)
                .openGuestProfileMenu()
                .openLoginModel()
                .enterEmail(configProperties.getAdminEmail())
                .enterPassword(configProperties.getAdminPassword())
                .clickLogin()
                .openGuestProfileMenu()
                .isContain("Вийти");

        Assert.assertTrue(isContainExit);
    }

    @Test
    public void ClubPageSuccessTest() {
        String actualeTitle = new HomePage(driver)
                .clickClub()
                .getCards()
                .get(2).
                getTitle();

        Assert.assertEquals(actualeTitle, "IT освіта: курси \"ГРАНД\"");
    }
    @Test
    public void RegistrationDataRemembered() {
        new HomePage(driver)
                .openGuestProfileMenu()
                .openRegistrationModel()
                .enterLastName(configProperties.getLastName())
                .enterFirstName(configProperties.getFirstName())
                .enterPhone(configProperties.getPhone())
                .enterEmail(configProperties.getEmail())
                .enterPassword(configProperties.getPassword())
                .enterPasswordConfirm(configProperties.getConfirm())
                        .cancelRegistration();


         Assert.assertEquals("Войтович","Войтович");
        Assert.assertEquals("Світлана","Світлана");
        Assert.assertEquals("671234567","671234567");
        Assert.assertEquals("svitlanawhite@gmail.com","svitlanawhite@gmail.com");
        Assert.assertEquals("12345678","12345678");
        Assert.assertEquals("12345678","12345678");


    }


    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
