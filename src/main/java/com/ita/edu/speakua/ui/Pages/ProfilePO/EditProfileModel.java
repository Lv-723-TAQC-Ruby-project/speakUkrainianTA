package com.ita.edu.speakua.ui.Pages.ProfilePO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProfileModel extends BasePO {
    @FindBy(xpath = "//input[@id='edit_lastName']")
    private WebElement editLastNameField;

    @FindBy(xpath = "//input[@id='edit_phone']")
    private WebElement editNumberPhoneField;

    @FindBy(xpath = "//*[@id=\"edit_currentPassword\"]")
    private WebElement currentPasswordField;

    @FindBy(xpath = "//*[@id=\"edit_password\"]")
    private WebElement newPasswordField;

    @FindBy(xpath = "//*[@id=\"edit\"]/div[2]/div[10]/button")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//div[@class='ant-form-item-explain-error']")
    private WebElement messageAboutIncorrectlyEnteredLastName;

    @FindBy(xpath = "//*[@id=\"edit_currentPassword_help\"]/div")
    private WebElement emptyCurrentPasswordFieldMessage;

    @FindBy(xpath = "//*[@id=\"edit_password_help\"]/div")
    private WebElement emptyNewPasswordFieldMessage;
    @FindBy(xpath = "//*[@id=\"edit_confirmPassword_help\"]/div")
    private WebElement emptyConfirmPasswordMessage;

    @FindBy(xpath = "//div[2]/div[7]/div/input")
    private WebElement changePasswordCheckBox;

    public EditProfileModel(WebDriver driver) {
        super(driver);
    }

    public EditProfileModel clickChangePasswordCheckBox() {
        changePasswordCheckBox.click();
        return this;
    }

    public boolean isOpenMassageErrorLastNameContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentEmptyConfirmPasswordMessage() {
        try {
            driver.findElement(By.xpath(String.valueOf(emptyConfirmPasswordMessage.isDisplayed())));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentEmptyCurrentPasswordMessage() {
        try {
            driver.findElement(By.xpath(String.valueOf(emptyCurrentPasswordFieldMessage.isDisplayed())));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isPresentEmptyNewPasswordFieldMessage() {
        try {
            driver.findElement(By.xpath(String.valueOf(emptyNewPasswordFieldMessage.isDisplayed())));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isOpenMassageErrorPhoneContain(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-form-item-explain-error']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EditProfileModel enterCurrentPassword(String password) {
        currentPasswordField.sendKeys(Keys.ENTER);
        return this;
    }

    public EditProfileModel enterNewPasswordInTheNewPasswordField(String newPassword) {
        newPasswordField.sendKeys(Keys.ENTER);
        return this;
    }

    public EditProfileModel enterConfirmPassword(String password) {
        currentPasswordField.sendKeys(Keys.ENTER);
        return this;
    }

    public MyProfilePage clickOnTheSaveChangesButton() {
        saveChangesButton.click();
        return new MyProfilePage(driver);
    }

    public EditProfileModel enterLastName(String lastName) {
        editLastNameField.clear();
        wait.visibility(editLastNameField);
        editLastNameField.sendKeys(lastName);
        return this;
    }

    public EditProfileModel deleteLastName() {
        editLastNameField.clear();
        wait.visibility(editLastNameField);
        return this;
    }

    public EditProfileModel enterNumberPhone(String numberPhone) {
        editNumberPhoneField.clear();
        wait.visibility(editNumberPhoneField);
        editNumberPhoneField.sendKeys(numberPhone);
        return this;
    }

    public EditProfileModel deleteNumberPhone() {
        editNumberPhoneField.clear();
        wait.visibility(editNumberPhoneField);
        return this;
    }
}
