package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddContactsCenterModel extends BasePO {

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


    public AddContactsCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddContactsCenterModel centerContactsFacebook(String facebook) {
        contactFacebook.sendKeys(facebook);
        return this;
    }

    public AddContactsCenterModel centerContactsWebSite(String webSite) {
        contactWebSite.sendKeys(webSite);
        return this;
    }

    public AddContactsCenterModel centerContactsEmail(String email) {
        contactEmail.sendKeys(email);
        return this;
    }

    public AddContactsCenterModel centerContactsSkype(String skype) {
        contactSkype.sendKeys(skype);
        return this;
    }

    public AddContactsCenterModel centerContactsWhatsApp(String whatsApp) {
        contactWhatsApp.sendKeys(whatsApp);
        return this;
    }

    public AddContactsCenterModel centerContactsTelephone(String telephone) {
        contactTelephone.sendKeys(telephone);
        return this;
    }

    public AddDescriptionCenterModel clickNextStep() {
        nextButton.click();
        return new AddDescriptionCenterModel(driver);
    }

}
