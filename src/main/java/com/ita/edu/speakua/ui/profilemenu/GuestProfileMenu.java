package com.ita.edu.speakua.ui.profilemenu;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.LoginModel;
import com.ita.edu.speakua.ui.RegisterModel;
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

    public LoginModel openLoginModel() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(loginButton));
        loginButton.click();
        return new LoginModel(driver);
    }

    public RegisterModel openRegistrationModel() {
        registrationButton.click();
        return new RegisterModel(driver);
    }


    public boolean isContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]",  name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
