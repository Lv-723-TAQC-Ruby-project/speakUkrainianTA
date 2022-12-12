package com.ita.edu.speakua.ui.Pages.ChallengePО;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddChallengePage extends BasePO {
    @FindBy(xpath =  "//input[@id='sortNumber']")
    private WebElement sequenceNumber;
    @FindBy(xpath =  "//input[@id='name']")
    private WebElement challengeName;
    @FindBy(xpath =  "//input[@id='title']")
    private WebElement titleInput;
    @FindBy(xpath =  "//div[@class='ql-editor ql-blank']")
    private WebElement challengeDescription;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadPhoto;
    @FindBy(xpath = "//button[contains(@class, 'add-contact-type-button')]")
    private WebElement saveButton;

    public AddChallengePage enterSequenceNumber(String sequence){
        sequenceNumber.sendKeys(sequence);
        return this;
    }
    public AddChallengePage enterChallengeName(String name){
        challengeName.sendKeys(name);
        return this;
    }
    public AddChallengePage enterTitle(String title){
        titleInput.sendKeys(title);
        return this;
    }
    public AddChallengePage enterChallengeDescription(String description){
        challengeDescription.sendKeys(description);
        return this;
    }
    public AddChallengePage uploadChallengePhoto(String path){
        uploadPhoto.sendKeys(path);
        return this;
    }
    public AddChallengePage saveChallengeClick(){
        saveButton.click();
        return new AddChallengePage(driver);
    }
    public boolean sequenceNumberEmpty(){
        return sequenceNumber.getAttribute("value") == "";
    }

    public boolean challengeNameEmpty(){
        return challengeName.getAttribute("value") == "";
    }
    public boolean titleEmpty(){
        return titleInput.getAttribute("value") == "";
    }
    public boolean challengeDescriptionEmpty(){
        return challengeDescription.getAttribute("value") == "";
    }
    public boolean notLoadedPhoto() {
        return uploadPhoto.getAttribute("value") == "";
    }
public boolean emptyFields() {
    return sequenceNumberEmpty() && challengeNameEmpty() && titleEmpty() && challengeDescriptionEmpty() && notLoadedPhoto();
}
    public AddChallengePage(WebDriver driver) {super(driver);
    }
}
