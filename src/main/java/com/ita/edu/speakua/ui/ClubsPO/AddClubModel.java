package com.ita.edu.speakua.ui.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class AddClubModel extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameClubInput;

    @FindBy(xpath = "//input[@id= 'basic_ageFrom']")
    private WebElement ageFromInput;

    @FindBy(xpath = "//input[@id= 'basic_ageTo']")
    private WebElement ageToInput;

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

    public AddClubModel(WebDriver driver) {
        super(driver);
    }

    public AddClubModel selectCategoryByName(String categoryName) {
        driver.findElement(xpath(format("//span[text()='%s']//parent::label//input", categoryName))).click();
        return this;
    }

    public AddClubModel EnterNameClub(String nameClub) {
        nameClubInput.sendKeys(nameClub);
        return this;
    }

    public AddClubModel enterFromAge(String ageFrom) {
        ageFromInput.sendKeys(ageFrom);
        return this;
    }

    public AddClubModel enterToAge(String ageTo) {
        ageToInput.sendKeys(ageTo);
        return this;
    }

    public AddClubModel enterPhoneNumber(String phoneNumber) {
        phoneNumberInput.sendKeys(phoneNumber);
        return this;
    }

    public AddClubModel clickNextStep() {
        nextStepButton.click();
        return new AddClubModel(driver);
    }

    public AddClubModel enterClubDescription(String clubDescription) {
        clubDescriptionInput.clear();
        clubDescriptionInput.sendKeys(clubDescription);
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();
    }

    public boolean successMessageDisplayed() {
        return successMessage.isDisplayed();
    }
}
