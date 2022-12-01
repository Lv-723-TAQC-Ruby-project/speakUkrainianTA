package com.ita.edu.speakua.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GuestProfileMenu extends BasePage{
    @FindBy(xpath = "//div[contains(text(), 'Зареєструватися')]")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[contains(text(), 'Увійти')]")
    private WebElement loginButton;

    public GuestProfileMenu(WebDriver driver) {
        super(driver);
    }

    public LoginModal openLoginModal() {
        loginButton.click();
        return new LoginModal(driver);
    }

    public void openRegistrationModal() {
        registrationButton.click();
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
