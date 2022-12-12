package com.ita.edu.speakua.ui.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCenterModel extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameCenterInput;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default add-location-btn']")
    private WebElement addCenterLocation;

    @FindBy(xpath = "//button[@class='ant-btn ant-btn-default next-btn']")
    private WebElement nextStepButton;

    public AddCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddCenterModel EnterCenterName(String nameCenter) {
        nameCenterInput.sendKeys(nameCenter);
        return this;
    }

    public AddLocationCenterModel AddLocation() {
        addCenterLocation.click();
        return new AddLocationCenterModel(driver);
    }

    public AddContactsCenterModel clickNextStep() {
        nextStepButton.click();
        return new AddContactsCenterModel(driver);
    }


}
