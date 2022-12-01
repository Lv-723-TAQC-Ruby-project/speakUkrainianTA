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
                .openLoginModal()
                .enterEmail("ToDo")
                .enterPassword("ToDo")
                .clickLogin()
                .openGuestProfileMenu()
                .isContain("Вийти");

        Assert.assertTrue(isContainExit);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }



}
