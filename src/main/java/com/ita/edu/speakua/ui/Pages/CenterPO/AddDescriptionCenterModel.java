package com.ita.edu.speakua.ui.Pages.CenterPO;

import com.ita.edu.speakua.ui.BasePO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddDescriptionCenterModel extends BasePO {
    @FindBy(xpath = "//span[text()='Завантажити лого']")
    private WebElement addLogo;

    @FindBy(xpath = "//span[text()='Завантажити фото']")
    private WebElement addPhoto;

    @FindBy(xpath = "//textarea[@id='basic_description']")
    private WebElement addDescription;
    @FindBy(xpath = "//span[contains(text(),'Наступний крок')]")
    private WebElement nextButton;



    public AddDescriptionCenterModel(WebDriver driver) {
        super(driver);
    }

    public AddDescriptionCenterModel addLogo(String logoLink) {
        addLogo.sendKeys(logoLink);
        return this;
    }

    public AddDescriptionCenterModel addPhoto(String photoLink) {
        addPhoto.sendKeys(photoLink);
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
