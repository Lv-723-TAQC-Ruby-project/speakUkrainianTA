package com.ita.edu.speakua.ui.Pages.ChallengePО.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

public class AddDescriptionCenterModel extends BasePO {
    @FindBy(xpath = "//input[@id='basic_urlLogo']")
    private WebElement addLogo;

    @FindBy(xpath = "//input[@id='basic_urlBackground']")
    private WebElement addPhoto;

    @FindBy(xpath = "//textarea[@id='basic_description']")
    private WebElement addDescription;
    @FindBy(xpath = "//span[contains(text(),'Наступний крок')]")
    private WebElement nextButton;


    public AddDescriptionCenterModel(WebDriver driver) {
        super(driver);
    }


    public AddDescriptionCenterModel addLogo(String logo) {
        File file = new File(getClass().getClassLoader().getResource(logo).getFile());
        String imagePath = file.getAbsolutePath();
        addLogo.sendKeys(imagePath);
        return this;
    }

    public AddDescriptionCenterModel addPhoto(String photo) {
        File file = new File(getClass().getClassLoader().getResource(photo).getFile());
        String imagePath = file.getAbsolutePath();
        addPhoto.sendKeys(imagePath);
        return this;
    }

    public AddDescriptionCenterModel addDescription(String description) {
        addDescription.sendKeys(description);
        return this;
    }

    public ChooseClubCenterModel clickNextStep() {
        nextButton.click();
        return new ChooseClubCenterModel(driver);
    }
}
