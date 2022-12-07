package com.ita.edu.speakua.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends BasePO{

    @FindBy(xpath = "//button[contains(@class, 'add-btn')]")
    private WebElement addTaskButton;

    public TasksPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddTask() {
        addTaskButton.click();
        sleep(3);
        //return new AddTaskPage(driver);
    }
}
