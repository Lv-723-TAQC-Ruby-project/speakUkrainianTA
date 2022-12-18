package com.ita.edu.speakua.ui.Pages.ChallengePО;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.util.Random;

public class AddChallengePage extends BasePageWithHeader {
    @FindBy(xpath = "//input[@id='sortNumber']")
    private WebElement sequenceNumber;
    @FindBy(xpath = "//input[@id='name']")
    private WebElement challengeName;
    @FindBy(xpath = "//input[@id='title']")
    private WebElement titleInput;
    @FindBy(xpath = "//div[@class='ql-editor ql-blank']")
    private WebElement challengeDescription;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadPhoto;
    @FindBy(xpath = "//button[contains(@class, 'add-contact-type-button')]")
    private WebElement saveButton;
    @FindBy(xpath = "//div[contains(@class,'ant-message')]")
    private WebElement successMessage;

    public AddChallengePage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSequenceNumber() {
        return sequenceNumber;
    }

    public WebElement getChallengeName() {
        return challengeName;
    }

    public WebElement getTitleInput() {
        return titleInput;
    }

    public WebElement getChallengeDescription() {
        return challengeDescription;
    }

    public WebElement getUploadPhoto()
    {
        return uploadPhoto;
    }


    public AddChallengePage enterSequenceNumber(String sequence) {
        Random random = new Random();
        int number = random.nextInt(100);
        sequenceNumber.sendKeys(sequence+number);
        return this;
    }

    public AddChallengePage enterChallengeName(String name) {
        challengeName.sendKeys(name);
        return this;
    }

    public AddChallengePage enterTitle(String title) {
        titleInput.sendKeys(title);
        return this;
    }

    public AddChallengePage enterChallengeDescription(String description) {
        challengeDescription.sendKeys(description);
        return this;
    }

    public AddChallengePage uploadChallengePhoto(String image) {
        ClassLoader classLoader = getClass().getClassLoader();
        File photo = new File(classLoader.getResource(image).getFile());
        String absolutePath = photo.getAbsolutePath();
        uploadPhoto.sendKeys(absolutePath);
        return this;
    }

    public AddChallengePage saveChallengeClick() {
        saveButton.click();
        return new AddChallengePage(driver);
    }

    public boolean successMessage() {
        return successMessage.isDisplayed();
    }
}
