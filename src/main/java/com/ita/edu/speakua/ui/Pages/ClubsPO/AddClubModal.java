package com.ita.edu.speakua.ui.Pages.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.HomePage;
import com.ita.edu.speakua.ui.Pages.CenterPO.AddLocationModal;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class AddClubModal extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameClubInput;

    @FindBy(xpath = "//input[@id= 'basic_ageFrom']")
    private WebElement ageFromInput;

    @FindBy(xpath = "//input[@id= 'basic_ageTo']")
    private WebElement ageToInput;

    @FindBy(xpath = "//span[@class='add-club-location']")
    private WebElement addLocationButton;

    @FindBy(xpath = "//input[@id= 'basic_contactТелефон']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//button[contains(@class, 'add-club-content-next')]")
    private WebElement nextStepButton;

    @FindBy(id = "basic_description")
    private WebElement clubDescriptionInput;

    @FindBy(id = "basic_description_help")
    private WebElement errorMessage;

    @FindBy(css = ".anticon-check-circle")
    private WebElement successMessage;

    @FindBy(xpath = "//div[contains(@class, 'ant-form-item-explain-error')]")
    private WebElement languageErrorMessage;

    @FindBy(xpath = "//div[contains(@class, 'ant-form-item-explain-error')]")
    private WebElement inappropriateDescriptionLengthMessage;

    @FindBy(xpath = "//input[@id=\"basic_centerId\"][@type='search']")
    private WebElement enterBelongingCenterInput;

    @FindBy(xpath = "//*[text()= 'Завершити']")
    private WebElement completeButton;

    public AddClubModal(WebDriver driver) {
        super(driver);
    }

    @Step("Select category by name")
    public AddClubModal selectCategoryByName(String categoryName) {
        driver.findElement(xpath(format("//span[text()='%s']//parent::label//input", categoryName))).click();
        return this;
    }

    @Step("Enter name of club")
    public AddClubModal enterNameClub(String nameClub) {
        wait.visibility(nameClubInput);
        nameClubInput.sendKeys(nameClub);
        return this;
    }

    @Step("Enter from age")
    public AddClubModal enterFromAge(String ageFrom) {
        ageFromInput.sendKeys(ageFrom);
        return this;
    }

    @Step("Enter to age")
    public AddClubModal enterToAge(String ageTo) {
        ageToInput.sendKeys(ageTo);
        return this;
    }

    public AddLocationModal clickAddLocationButton() {
        wait.visibility(addLocationButton);
        action.click(addLocationButton);
        return new AddLocationModal(driver);
    }

    @Step("Enter phone number")
    public AddClubModal enterPhoneNumber(String phoneNumber) {
        wait.visibility(phoneNumberInput);
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    @Step("Click next step button")
    public AddClubModal clickNextStep() {
        nextStepButton.click();
        sleep(3);
        return new AddClubModal(driver);
    }

    public AddClubModal enterClubDescription(String clubDescription) {
        clubDescriptionInput.clear();
        clubDescriptionInput.sendKeys(clubDescription);
        return this;
    }

    public boolean successMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public boolean isErrorMessageDisplayed(String errorMessage) {
        wait.visibility(xpath(format("//div[text()='%s']", errorMessage)));
        return driver.findElement(xpath(format("//div[text()='%s']", errorMessage))).isDisplayed();
    }

    public AddClubModal enterBelongingToCenter(String nameCenter) {
        enterBelongingCenterInput.sendKeys(nameCenter);
        return this;
    }

    public HomePage finishAddingCenter() {
        completeButton.click();
        sleep(2);
        return new HomePage(driver);
    }

    public boolean completeButtonEnabled() {
        return completeButton.isEnabled();
    }
}
