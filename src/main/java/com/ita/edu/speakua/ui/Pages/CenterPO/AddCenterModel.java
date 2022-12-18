package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCenterModel extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameCenterInput;

    @FindBy(xpath = "//span[contains(text(),'Додати локацію')]")
    private WebElement addCenterLocation;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default next-btn']")
    private WebElement nextStepButton;
    @FindBy(xpath = "//span[text()='New Center Name']")
    private WebElement selectCenterLocation;
    @FindBy(xpath = "//div[1]//label[1]")
    private WebElement scroll;

    @FindBy(xpath = "//div[contains(@class, 'ant-checkbox-group location-list')]/div[last()]/label/span/input")
    private WebElement newLocation;


    public AddCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddCenterModel enterCenterName(String nameCenter) {
        nameCenterInput.sendKeys(nameCenter);
        return this;
    }

    public AddLocationModel addLocation() {
        addCenterLocation.click();
        return new AddLocationModel(driver);
    }

    public AddCenterModel selectCenterLocation() {
        scroll.click();
        scroll.click();
        scroll.sendKeys(Keys.END);
        newLocation.click();
        return this;
    }

    public AddContactsCenterModel clickNextStep() {
        nextStepButton.click();
        return new AddContactsCenterModel(driver);
    }


}
