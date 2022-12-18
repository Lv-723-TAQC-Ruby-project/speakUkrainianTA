package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseClubCenterModel extends BasePO {


    @FindBy(xpath = "//div[@class='form-fields']/div[1]/div[1]/label/span[@class='ant-checkbox']")
    WebElement club;

    @FindBy(xpath = "//button[@class='finish-btn']")
    WebElement finishButton;

    public ChooseClubCenterModel(WebDriver driver) {
        super(driver);
    }

    public ChooseClubCenterModel chooseClub() {
        club.click();
        return this;
    }

    public HomePage finishAddCenter() {
        finishButton.click();
        return new HomePage(driver);
    }
}
