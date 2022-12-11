package com.ita.edu.speakua.ui.TaskPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskPage extends BasePO {

    @FindBy(xpath = "//input[@id='startDate']")
    public WebElement startDate;

    @FindBy(xpath = "//input[@id='picture']")
    public WebElement uploadImage;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement taskName;

    @FindBy(xpath = "//div[contains(@class, 'ql-editor ql-blank')]")
    public WebElement taskTitle;

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor ql-blank')])[2]")
    public WebElement taskDescription;

    @FindBy(xpath = "//input[@id=challengeId]")
    public WebElement challenge;

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    //String date = "2023-1-1";
    public AddTaskPage enterStartDate(String date) {
        startDate.sendKeys(date);
        return this;
    }

    //String filePath = "C:\\Users\\User\\Desktop\\world-cup.jpg";
    public AddTaskPage uploadImage(String filePath) {
        uploadImage.sendKeys(filePath);
        return this;
    }

    public AddTaskPage enterTaskName(String taskName) {
        this.taskName.sendKeys(taskName);
        return this;
    }

    public AddTaskPage enterTaskTitle(String taskTitle) {
        this.taskTitle.sendKeys(taskTitle);
        return this;
    }

    public AddTaskPage enterTaskDescription(String taskDescription) {
        this.taskDescription.sendKeys(taskDescription);
        return this;
    }
}
