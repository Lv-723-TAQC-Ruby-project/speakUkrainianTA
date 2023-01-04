package com.ita.edu.speakua.ui.profilemenu;

import com.ita.edu.speakua.ui.Pages.ChallengePО.ChallengePage;
import com.ita.edu.speakua.ui.Pages.TaskPO.TasksPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminProfileMenu extends UserProfileMenu {
    @FindBy(xpath = "//span[contains(text(), 'Контент')]")
    private WebElement contentButton;
    @FindBy(xpath = "//span[contains(text(), 'Челенджі')]")
    private WebElement challengeButton;
    @FindBy(xpath = "//a[contains(text(), 'Челенджі')]")
    private WebElement challengesButton;
    @FindBy(xpath = "//a[contains(text(), 'Завдання')]")
    private WebElement tasksButton;

    public AdminProfileMenu(WebDriver driver) {
        super(driver);
    }

    @Step("open Task")
    public TasksPage openTasksPage() {

        openContentSubMenu();
        openChallengeSubMenu();
        wait.visibility(tasksButton);
        action.click(tasksButton);

        return new TasksPage(driver);
    }

    @Step("open Challenge")
    public ChallengePage openChallengePage() {
        openContentSubMenu();
        openChallengeSubMenu();

        wait.visibility(challengesButton);
        action.click(challengesButton);
        return new ChallengePage(driver);
    }

    @Step("open Content Sub Menu")
    public AdminProfileMenu openContentSubMenu() {
        wait.visibility(contentButton);
        action.click(contentButton);
        return this;
    }

    @Step("open Challenge Sub Menu")
    public AdminProfileMenu openChallengeSubMenu() {
        wait.visibility(challengeButton);
        action.click(challengeButton);
        return this;
    }

}
