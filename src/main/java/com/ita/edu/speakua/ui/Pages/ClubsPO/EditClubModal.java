package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.Pages.ProfilePO.MyProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditClubModal extends BasePO {

    @FindBy(xpath = "//div[text()='Адреса і контакти']")
    private WebElement addressAndContactsButton;

    @FindBy(xpath = "basic_clubContactТелефон")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//div[text()='Опис гуртка']")
    private WebElement descriptionButton;

    @FindBy(id = "basic_descriptionText")
    private WebElement clubDescriptionInput;

    @FindBy(xpath = "//*[@id=\"basic\"]/div[4]/button[1]/span")
    private WebElement saveInContactSectionButton;

    @FindBy(xpath = "//*/body/div[5]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[5]/button[1]/span")
    private WebElement saveInDescriptionSectionButton;

    @FindBy(xpath = "/html/body/div[5]/div/div[2]/div/div[2]/div/div[2]/div[2]/div/div[3]/form/div[5]/button[2]/span")
    private WebElement saveInDescriptionSectionButton2;
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
        return new MyProfilePage(driver);
    }

}
