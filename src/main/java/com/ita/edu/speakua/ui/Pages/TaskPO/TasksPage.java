package com.ita.edu.speakua.ui.Pages.TaskPO;

import com.ita.edu.speakua.ui.BasePageWithHeader;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TasksPage extends BasePageWithHeader {

    @FindBy(xpath = "//button[contains(@class, 'add-btn')]")
    private WebElement addTaskButton;

    public TasksPage(WebDriver driver) {
        super(driver);
    }
@Step("click Add Task btn")
    public AddTaskPage clickAddTask() {
        wait.visibility(addTaskButton);
        addTaskButton.click();
        sleep(3);
        return new AddTaskPage(driver);
    }
}
