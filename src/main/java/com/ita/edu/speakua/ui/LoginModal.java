package com.ita.edu.speakua.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModal extends BasePO {

    @FindBy(xpath = "//input[@id='basic_email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='basic_password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    private WebElement loginButton;

    public LoginModal(WebDriver driver) {
        super(driver);
    }

    @Step
    public LoginModal enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    @Step
    public LoginModal enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    @Step
    public HomePage clickLogin() {
        loginButton.click();
        sleep(5);
        return new HomePage(driver);
    }


}
