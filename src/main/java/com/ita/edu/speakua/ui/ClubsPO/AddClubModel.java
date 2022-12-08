package com.ita.edu.speakua.ui.ClubsPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddClubModel extends BasePO {

    @FindBy(xpath = "//input[@id= 'basic_name']")
    private WebElement nameClubInput;


    @FindBy(xpath = "//button[contains(@class, 'add-club-content-next')]")
    private WebElement nextStepButton;

    public AddClubModel(WebDriver driver){
        super(driver);
    }

    public AddClubModel EnterNameClub(String nameClub){
        nameClubInput.sendKeys(nameClub);
        return this;
    }

    public AddClubModel clickNextStep(){
        nextStepButton.click();
        return new AddClubModel(driver);
    }

}
