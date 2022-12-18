package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactsCenterModal extends BasePO {

    @FindBy(xpath = "//input[@id='contacts_contactFacebook']")
    private WebElement contactFacebook;

    @FindBy(xpath = "//input[@id='contacts_contactContact']")
    private WebElement contactWebSite;
    @FindBy(xpath = "//input[@id='contacts_contactПошта']")
    private WebElement contactEmail;

    @FindBy(xpath = "//input[@id='contacts_contactSkype']")
    private WebElement contactSkype;

    @FindBy(xpath = "//input[@id='contacts_contactWhatsApp']")
    private WebElement contactWhatsApp;

    @FindBy(xpath = "//input[@id='contacts_contactТелефон']")
    private WebElement contactTelephone;

    @FindBy(xpath = "//span[contains(text(),'Наступний крок')]")
    private WebElement nextButton;


    public AddContactsCenterModal(WebDriver driver) {
        super(driver);
    }

    public AddContactsCenterModal centerContactsFacebook(String facebook) {
        contactFacebook.sendKeys(facebook);
        return this;
    }

    public AddContactsCenterModal centerContactsWebSite(String webSite) {
        contactWebSite.sendKeys(webSite);
        return this;
    }

    public boolean isMessageErrorCenterWithoutName() {
        try {
            driver.findElement(By.xpath("//div[contains(text(), 'Некоректна назва центру')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public AddContactsCenterModal centerContactsEmail(String email) {
        contactEmail.sendKeys(email);
        return this;
    }

    public AddContactsCenterModal centerContactsSkype(String skype) {
        contactSkype.sendKeys(skype);
        return this;
    }

    public AddContactsCenterModal centerContactsWhatsApp(String whatsApp) {
        contactWhatsApp.sendKeys(whatsApp);
        return this;
    }

    public AddContactsCenterModal centerContactsTelephone(String telephone) {
        contactTelephone.sendKeys(telephone);
        return this;
    }

    public AddDescriptionCenterModal clickNextStep() {
        nextButton.click();
        return new AddDescriptionCenterModal(driver);
    }

}
