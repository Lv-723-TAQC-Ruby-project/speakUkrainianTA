package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import com.ita.edu.speakua.ui.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseClubCenterModal extends BasePO {


    @FindBy(xpath = "//div[@class='form-fields']/div[1]/div[1]/label/span[@class='ant-checkbox']")
    WebElement club;

    @FindBy(xpath = "//button[@class='finish-btn']")
    WebElement finishButton;

    public ChooseClubCenterModal(WebDriver driver) {
        super(driver);
    }

    @Step("choose club")
    public ChooseClubCenterModal chooseClub() {
        wait.visibility(club);
        action.click(club);
        return this;
    }

    @Step("finish add center")
    public HomePage finishAddCenter() {
        finishButton.click();
        sleep(5);
        return new HomePage(driver);
    }
}
