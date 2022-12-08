package com.ita.edu.speakua.ui.profilemenu;

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

    //  Window "Додати локацію"
    @FindBy(xpath = "//input[@id='name']")
    private WebElement nameLocation;

    @FindBy(xpath = "//input[@id='address']")
    private WebElement addressLocation;

    @FindBy(xpath = "//input[@id='coordinates']")
    private WebElement coordinatesLocation;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phoneLocation;

    public AddCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddCenterModel EnterCenterName(String nameCenter) {
        nameCenterInput.sendKeys(nameCenter);
        return this;
    }

    public AddCenterModel clickNextStep() {
        nextStepButton.click();
        return new AddCenterModel(driver);
    }
}
