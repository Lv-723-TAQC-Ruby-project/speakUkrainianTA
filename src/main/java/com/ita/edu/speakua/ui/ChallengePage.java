package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengePage extends BasePO{
    @FindBy(xpath = "//button[contains(@class, 'add-btn')]")
    private WebElement addChallengeButton;
    public ChallengePage(WebDriver driver) {super(driver);}

    public AddChallengePage clickAddChallengeButton(){
        addChallengeButton.click();
        return new AddChallengePage(driver);
    }
}
