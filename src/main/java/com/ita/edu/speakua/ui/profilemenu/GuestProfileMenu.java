package com.ita.edu.speakua.ui.profilemenu;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.LoginModal;
import com.ita.edu.speakua.ui.RegisterModal;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GuestProfileMenu extends BasePO {
    @FindBy(xpath = "//div[contains(text(), 'Зареєструватися')]")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[contains(text(), 'Увійти')]")
    private WebElement loginButton;


    public GuestProfileMenu(WebDriver driver) {
        super(driver);
    }

    public LoginModal openLoginModel() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new LoginModal(driver);
    }

    public RegisterModal openRegistrationModel() {
        registrationButton.click();
        return new RegisterModal(driver);
    }


    public boolean isContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
