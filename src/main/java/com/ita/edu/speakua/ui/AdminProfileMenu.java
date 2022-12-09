package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;


public class AdminProfileMenu extends BasePO {

    @FindBy(xpath = "//span[contains(text(), 'Контент')]")
    private WebElement contentButton;

    @FindBy(xpath = "//span[contains(text(), 'Челенджі')]")
    private WebElement challengesButton;

    @FindBy(xpath = "//a[contains(text(), 'Завдання')]")
    private WebElement tasksButton;

    public TasksPage openTasksPage() {

        wait.visibility(contentButton);
        action.click(contentButton);

        wait.visibility(challengesButton);
        action.click(challengesButton);

        wait.visibility(tasksButton);
        action.click(tasksButton);

        return new TasksPage(driver);
    }

    public AdminProfileMenu(WebDriver driver) {
        super(driver);
    }
}
