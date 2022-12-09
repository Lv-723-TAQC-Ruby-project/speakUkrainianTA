package com.ita.edu.speakua.ui.ChallengePage;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChallengePage extends BasePO {
    @FindBy(xpath = "//button[contains(@class, 'add-btn')]")
    private WebElement addChallengeButton;
    public ChallengePage(WebDriver driver) {super(driver);}

    public AddChallengePage clickAddChallengeButton(){
        wait.visibility(addChallengeButton);
        addChallengeButton.click();
        return new AddChallengePage(driver);
    }
}
