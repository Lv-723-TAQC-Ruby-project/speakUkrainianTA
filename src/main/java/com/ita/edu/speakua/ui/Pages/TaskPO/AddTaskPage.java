package com.ita.edu.speakua.ui.Pages.TaskPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @FindBy(xpath = "(//div[contains(@class, 'ql-editor ql-blank')])[1]")
    public WebElement taskDescription;

    @FindBy(xpath = "//input[@id='challengeId']")
    public WebElement chooseChallenge;

    @FindBy(xpath = "//div[contains(text(), 'New Challenge')]")
    public WebElement challenge;

    @FindBy(xpath = "//button[contains(@class, 'ant-btn ant-btn-primary flooded-button add-contact-type-button')]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='ant-message']")
    private WebElement errorMessage;

    public AddTaskPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getStartDate() {
        return startDate;
    }

    public WebElement getUploadImage() {
        return uploadImage;
    }

    public WebElement getTaskName() {
        return taskName;
    }

    public WebElement getTaskTitle() {
        return taskTitle;
    }

    public WebElement getTaskDescription() {
        return taskDescription;
    }

    public WebElement getChooseChallenge() {
        return chooseChallenge;
    }

    public WebElement getChallenge() {
        return challenge;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }

    //String date = "2023-1-1";
    public AddTaskPage enterStartDate(String date) {
        startDate.sendKeys(date, Keys.ENTER);
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

    public boolean isContainErrorMessage(String name) {
        try {
            driver.findElement(By.xpath(String.format("//div[@class='ant-message']", name)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public AddTaskPage chooseChallenge() {
        chooseChallenge.click();
        challenge.click();
        return this;
    }

    public AddTaskPage clickSave() {
        saveButton.click();
        sleep(3);
        return this;
    }
}
