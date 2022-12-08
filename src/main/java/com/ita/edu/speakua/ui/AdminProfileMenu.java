package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class AdminProfileMenu extends BasePO {

    @FindBy(xpath = "//span[contains(text(), 'Контент')]")
    private WebElement contentButton;

    @FindBy(xpath = "//span[contains(text(), 'Челенджі')]")
    private WebElement challengesButton;

    @FindBy(xpath = "//a[contains(text(), 'Завдання')]")
    private WebElement tasksButton;

    public TasksPage openTasksPage() {

        Actions actionContentButton = new Actions(driver);
        actionContentButton.moveToElement(contentButton).perform();
        sleep(2);

        Actions actionChallengesButton = new Actions(driver);
        actionChallengesButton.moveToElement(challengesButton).perform();
        sleep(2);

        tasksButton.click();
        sleep(3);
        return new TasksPage(driver);
    }

    public AdminProfileMenu(WebDriver driver) {
        super(driver);
    }
}
