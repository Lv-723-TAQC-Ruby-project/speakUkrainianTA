package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginModel extends BasePO {

    @FindBy(xpath = "//input[@id='basic_email']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='basic_password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    private WebElement loginButton;

    public LoginModel(WebDriver driver) {
        super(driver);
    }

    public LoginModel enterEmail(String email) {
        emailInput.sendKeys(email);
        return this;
    }

    public LoginModel enterPassword(String password) {
        passwordInput.sendKeys(password);
        return this;
    }

    public HomePage clickLogin() {
        loginButton.click();
        sleep(2);
        return new HomePage(driver);
    }


}
