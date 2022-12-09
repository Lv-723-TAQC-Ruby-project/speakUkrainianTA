package com.ita.edu.speakua.ui.profilemenu;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.ChallengePage;
import com.ita.edu.speakua.ui.ProfilePO.MyProfilePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AdminProfileMenu extends UserProfileMenu{
@FindBy(xpath = "//span[contains(text(), 'Контент')]")
private WebElement contentButton;
@FindBy(xpath = "//span[contains(text(), 'Челенджі')]")
private WebElement challengeButton;
@FindBy(xpath = "//a[contains(text(), 'Челенджі')]")
private WebElement challengesButton;


    public ChallengePage openChallengePage() {
        Actions action1 = new Actions(driver);
        action1.moveToElement(contentButton).perform();
        sleep(3);
        Actions action2 = new Actions(driver);
        action2.moveToElement(challengeButton).perform();
        sleep(3);
        challengesButton.click();
        sleep(3);
        return new ChallengePage(driver);
    }
    public AdminProfileMenu(WebDriver driver) {super(driver);}
}
