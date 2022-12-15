package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
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

    public AddCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddCenterModel enterCenterName(String nameCenter) {
        nameCenterInput.sendKeys(nameCenter);
        return this;
    }

    public AddLocationCenterModel addLocation() {
        addCenterLocation.click();
        return new AddLocationCenterModel(driver);
    }

    public AddContactsCenterModel clickNextStep() {
        nextStepButton.click();
        return new AddContactsCenterModel(driver);
    }


}
