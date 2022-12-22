package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditClubModal extends BasePO {

    @FindBy(xpath = "//div[text()='Адреса і контакти']")
    private WebElement addressAndContactsButton;

    @FindBy(id = "basic_clubContactТелефон")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//div[text()='Опис гуртка']")
    private WebElement descriptionButton;

    @FindBy(id = "basic_descriptionText")
    private WebElement clubDescriptionInput;

    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/button[1]/span")
    private WebElement saveInContactSectionButton;

    @FindBy(xpath = "//div[@tabindex='0']/form[@class='ant-form ant-form-horizontal']/div[5]//span[text()='Зберегти зміни вікна']")
    private WebElement saveInDescriptionSectionButton;

    @FindBy(xpath = "//div[@tabindex='0']/form[@class='ant-form ant-form-horizontal']/div[5]//span[text()='Зберегти гурток']")
    private WebElement saveInDescriptionSectionButton2;
    @FindBy(xpath = "//input[@id='basic_clubContactSkype']")
    private WebElement loginOfSkypeInput;
    public EditClubModal(WebDriver driver) {
        super(driver);
    }

    public EditClubModal openAddressAndContactsSection(){
        wait.visibility(addressAndContactsButton);
        action.click(addressAndContactsButton);
        return this;
    }

    public EditClubModal enterPhoneNumber(String phoneNumber) {
        wait.visibility(phoneNumberInput);
        phoneNumberInput.clear();
        phoneNumberInput.sendKeys(Keys.DELETE);
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public EditClubModal openDescriptionSection(){
        wait.visibility(descriptionButton);
        action.click(descriptionButton);
        return this;
    }
    public EditClubModal enterClubDescription(String clubDescription) {
        clubDescriptionInput.clear();
        clubDescriptionInput.sendKeys(clubDescription);
        return this;
    }

    public EditClubModal clickSaveInContactSectionButton(){
        wait.visibility(saveInContactSectionButton);
        action.click(saveInContactSectionButton);
        return this;
    }
    public MyProfilePage clickSaveInDescriptionSectionButton(){
        wait.visibility(saveInDescriptionSectionButton);
        action.click(saveInDescriptionSectionButton);
        sleep(2);
        wait.visibility(saveInDescriptionSectionButton2);
        action.click(saveInDescriptionSectionButton2);
        sleep(3);
        return new MyProfilePage(driver);
    }

    public EditClubModal enterLoginOfSkype(String login) {
        loginOfSkypeInput.sendKeys(login);
        return this;
    }

}
