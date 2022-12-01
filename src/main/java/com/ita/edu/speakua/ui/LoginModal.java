package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends BasePage {

    @FindBy(xpath = "//input[@id='basic_email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='basic_password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    private WebElement loginButton;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    public LoginModal enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginModal enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage clickLogin() {
        loginButton.click();
        sleep(3);
        return new HomePage(driver);
    }


}
